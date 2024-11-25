package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//@WebServlet("/calculationServlet")
public class calculationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("html/text");
		PrintWriter out=response.getWriter();
		
		int n1=Integer.parseInt(request.getParameter("num1"));
		int n2=Integer.parseInt(request.getParameter("num2"));
		String btn=request.getParameter("btn1");
		switch(btn) {
		case "add":
			out.println("<h1>Addition : "+(n1+n2)+"</h1>");
			break;
		
		case "sub":
			out.println("<h1>Subtraction : "+(n1-n2)+"</h1>");
			break;
		case "mult":
			out.println("<h1>Multiplication : "+(n1*n2)+"</h1>");
			break;
		case "div":
			out.println("<h1>Division : "+(n1/n2)+"</h1>");
			break;
		}

	}

}
