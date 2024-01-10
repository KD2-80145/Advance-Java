package com.sunbeam.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/announcement")
public class AnnouncementServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);	
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String msg = req.getParameter("msg");
		ServletContext ctx = req.getServletContext();
		ctx.setAttribute("announce", msg);
		
		//RequestDispatcher rd = req.getRequestDispatcher("result");
		RequestDispatcher rd = ctx.getRequestDispatcher("/result");
		rd.forward(req, resp);
	}
}








