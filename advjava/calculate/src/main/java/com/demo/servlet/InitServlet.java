package com.demo.servlet;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/initservlet")
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void init(ServletConfig config){
    	System.out.println("in init method of initparamservlet");
    } 
    public void destroy(){
    	System.out.println("in destroy method of initparamservlet");
    } 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
