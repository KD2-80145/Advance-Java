package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// if "candidate" is name of radio button (single selection) of prev page:
			// String id = req.getParameter("candidate");
		// if "candidate" is name of check-boxes (multi selection) of prev page:
			// String[] ids = req.getParameterValues("candidate");
		HttpSession session = req.getSession();
		User curUser = (User) session.getAttribute("curUser");
		if(curUser.getStatus() != 0) {
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Voting Done</title>");
			out.println("</head>");
			out.println("<body>");

			String userName = "User";
			Cookie[] arr = req.getCookies();
			if(arr != null) {
				for(Cookie c : arr) {
					if(c.getName().equals("uname")) {
						userName = c.getValue();
						break;
					}
				}
			}
			out.printf("Hello, %s<hr/>\r\n", userName);
			//out.printf("Hello, %s %s <hr/>\r\n", curUser.getFirstName(), curUser.getLastName());

			out.println("<h5>You have already voted.</h5>");
			out.println("<a href='logout'>Sign Out</a>");
			out.println("</body>");
			out.println("</html>");
		}
		else {
			String candId = req.getParameter("candidate");
			int cId = Integer.parseInt(candId);
			try(CandidateDao candDao = new CandidateDaoImpl()) {
				int cnt = candDao.incrementVote(cId);
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Voting Done</title>");
				out.println("</head>");
				out.println("<body>");
	
				out.printf("Hello, %s %s <hr/>\r\n", curUser.getFirstName(), curUser.getLastName());
				
				if(cnt == 1) {
					try(UserDao userDao = new UserDaoImpl()) {
						curUser.setStatus(1);
						cnt = userDao.updateStatus(curUser.getId(), true);
						if(cnt == 1)
							out.println("<h5>Your vote registered successfully.</h5>");
					}
				}
				if(cnt == 0)
					out.println("<h5>Some error occurred. Try again.</h5>");
				out.println("<a href='logout'>Sign Out</a>");
				out.println("</body>");
				out.println("</html>");
			} // candDao.close();
			catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
	}
}






