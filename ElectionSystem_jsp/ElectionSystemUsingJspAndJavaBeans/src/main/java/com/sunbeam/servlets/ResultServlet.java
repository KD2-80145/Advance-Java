package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;
import com.sunbeam.pojos.User;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			List<Candidate> list = candDao.getCandidatewiseVotes();
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Election Result</title>");
			out.println("</head>");
			out.println("<body>");
			
			ServletContext ctx = req.getServletContext();
			String title = ctx.getInitParameter("appTitle");
			out.printf("<h3>%s</h3>\r\n", title);
			
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

			//out.printf("Hello, %s %s <hr/>\r\n", curUser.getFirstName(), curUser.getLastName());
			
			out.println("<h5>Election Result</h5>");
			out.println("<table border='1'>");
			out.println("<thead>");
			out.println("<th>Id</th>");
			out.println("<th>Name</th>");
			out.println("<th>Party</th>");
			out.println("<th>Votes</th>");
			out.println("<th>Action</th>");
			out.println("</thead>");
			out.println("<tbody>");
			for (Candidate c : list) {
				out.println("<tr>");
				out.printf("<td>%s</td>\r\n", c.getId());
				out.printf("<td>%s</td>\r\n", c.getName());
				out.printf("<td>%s</td>\r\n", c.getParty());
				out.printf("<td>%s</td>\r\n", c.getVotes());
				out.printf("<td><a href='candedit?id=%s'><img src='edit.png' alt='Edit' width='24' height='24'/></a> <a href='canddel?id=%s'><img src='delete.png' alt='Delete' width='24' height='24'/></a></td>\r\n", c.getId(), c.getId());
				out.println("</tr>");
			}
			out.println("</tbody>");
			out.println("</table>");
			
			String message = (String) req.getAttribute("message");
			if(message != null)
				out.printf("%s\r\n<br/><br/>", message);
			
			out.println("<a href='announcement.html'>Announcement</a>");
			out.println("<a href='logout'>Sign Out</a>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
