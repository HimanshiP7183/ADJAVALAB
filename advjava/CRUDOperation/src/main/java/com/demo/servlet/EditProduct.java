package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class EditProduct extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession sess=request.getSession();
		String role=(String)sess.getAttribute("role");
		if(role!=null && role.equals("admin")) {
			int pid=Integer.parseInt(request.getParameter("pid"));
			ProductService pservice=new ProductServiceImpl();
			Product p=pservice.getById(pid);
			if(p!=null) {
				out.println("<form action='updateProd'>");
				out.println("Product Id : <input type='text' name='pid' id='pid' value='"+p.getPid()+"' readonly>");
				out.println("Product Name : <input type='text' name='pname' id='pname' value='"+p.getPname()+"'>");
				out.println("Product Quantity : <input type='text' name='qty' id='qty' value='"+p.getQty()+"'>");
				out.println("Product Price:  <input type='text' name='price' id='price'value='"+p.getPrice()+"'>");
				String dt=p.getExpdate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				out.println("Expiry date : <input type='text' name='expdate' id='expdate' value='"+dt+"'>");
				out.println("Category Id : <input type='text' name='cid' id='cid' value='"+p.getCid()+"'>");
				out.println("<button type='submit' name='btn' id='btn' value='add'>Update Product</button>");
				out.println("</form><br>");
				out.println("<a href='logout'>Logout</a>");
		
		
			}else {
				RequestDispatcher rd=request.getRequestDispatcher("showprod");
				rd.forward(request, response);
			}
		}else {
			   out.println("Pls login to the application!!");
			   RequestDispatcher rd=request.getRequestDispatcher("login.html");
			   rd.include(request, response);
		   }
	}
}
