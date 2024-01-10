package com.sunbeam.servlets;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;
import com.sunbeam.pojos.User;

@WebServlet("/candlist")
public class CandidateListServlet extends HttpServlet {
	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException ,java.io.IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Candidate List</title>");
		out.println("</head>");
		out.println("<body>");

		HttpSession session = req.getSession();
		User curUser = (User) session.getAttribute("curUser");
		
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
		
		ServletContext ctx = req.getServletContext();
		String msg = (String)ctx.getAttribute("announce");
		if(msg != null)
			out.printf("Announcement: %s<hr/>\r\n", msg);
		
		out.println("<h5>Election Candidates</h5>");
		out.println("<form method='post' action='vote'>");
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			List<Candidate> list = candDao.findAll();
			for (Candidate c : list) {
				out.printf("<input type='radio' name='candidate' value='%d'/> %s - %s <br/>\r\n", c.getId(), c.getName(), c.getParty());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		out.println("<input type='submit' value='Vote'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
}
