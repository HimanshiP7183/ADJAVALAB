package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.demo.beans.MyUser;
import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddProduct extends HttpServlet{
   public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	   response.setContentType("text/html");
	   PrintWriter out=response.getWriter();
	   
	   HttpSession sess=request.getSession();
	   String role=(String) sess.getAttribute("role");
	   System.out.println("Session role: " + role);
//	   MyUser user = (MyUser) sess.getAttribute("admin");
//	   String role=user.getRole();
	   System.out.println(" role: " + role);
	   if(role!=null && role.equals("admin")) {
		   int pid=Integer.parseInt(request.getParameter("pid")); 
		   String pname=request.getParameter("pname");
		   int qty=Integer.parseInt(request.getParameter("qty")); 
		   double price=Double.parseDouble(request.getParameter("price")); 
		   String dt=request.getParameter("expdate"); 
		   LocalDate ldt=LocalDate.parse(dt,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		   int cid=Integer.parseInt(request.getParameter("cid"));
		   Product p=new Product(pid,pname,qty,price,ldt,cid);
		   ProductService pservice=new ProductServiceImpl();
		   boolean status=pservice.insertProduct(p);
		   RequestDispatcher rd=request.getRequestDispatcher("showprod");
		   rd.forward(request, response);
	   }else {
		   out.println("Pls login to the application!!");
		   RequestDispatcher rd=request.getRequestDispatcher("login.html");
		   rd.include(request, response);
	   }
	   
   }
	
}
