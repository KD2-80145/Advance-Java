package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

@WebServlet("/candedit")
public class CandidateEditServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String candId = req.getParameter("id");
		int id = Integer.parseInt(candId);
		Candidate c = null;
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			c = candDao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit Candidate</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h5>Edit Candidate</h5>");
		out.println("<form method='post' action='candedit'>");
		out.printf("Id: <input type='text' name='id' value='%s' readonly>\r\n<br/>", c.getId());
		out.printf("Name: <input type='text' name='name' value='%s'>\r\n<br/>", c.getName());
		out.printf("Party: <input type='text' name='party' value='%s'>\r\n<br/>", c.getParty());
		out.printf("Votes: <input type='text' name='votes' value='%s' readonly>\r\n<br/>", c.getVotes());
		out.println("<input type='submit' value='Update'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String candId = req.getParameter("id");
		int id = Integer.parseInt(candId);
		String candVotes= req.getParameter("votes");
		int votes = Integer.parseInt(candVotes);
		String name = req.getParameter("name");
		String party = req.getParameter("party");
		Candidate c = new Candidate(id, name, party, votes);
		int cnt = 0;
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			cnt = candDao.update(c);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		String message = "Candidates Updated: " + cnt;
		req.setAttribute("message", message);

		RequestDispatcher rd = req.getRequestDispatcher("result"); 
		rd.forward(req, resp);
	}
}
