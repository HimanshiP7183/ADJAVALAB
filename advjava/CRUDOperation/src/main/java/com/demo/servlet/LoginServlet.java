package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import com.demo.service.LoginServiceImpl;
import com.demo.beans.MyUser;
import com.demo.service.LoginService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
//		send username and password for validation
		String uname=req.getParameter("uname");
		String password=req.getParameter("pwd");
		
		LoginService ls=new LoginServiceImpl();
		MyUser user=ls.validation(uname,password);
		
		if(user!=null && user.getRole().equals("admin")) {
//			out.println("<h1>Admin Login Successfully...!!!</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("showprod");
			rd.forward(req, res);
		}
		else {
			out.println("<h1>Wrong credentials....!!!</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
	}
//	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
//		doGet(request,response);
//	}
}
