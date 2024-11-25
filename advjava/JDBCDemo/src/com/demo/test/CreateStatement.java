package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

public class CreateStatement {
	public static void main(String[] args) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			String url="jdbc:mysql://localhost:3306/adjava?useSSL=false";
			Connection conn=DriverManager.getConnection(url,"root","welcome");
			
			Statement st=conn.createStatement();
			
//			ResultSet rs=st.executeQuery("select * from product");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter product id:");
			int pid =sc.nextInt();
			System.out.println("Enter product name:");
			String pname=sc.next();
			System.out.println("Enter product quantity:");
			int qty=sc.nextInt();
			System.out.println("Enter product price:");
			double price=sc.nextDouble();
			LocalDate dt=LocalDate.of(2025,02,01);
			System.out.println("Enter product category id:");
			int cid=sc.nextInt();
			String query="insert into product1 values("+pid+",'"+pname+"',"+qty+","+price+",'"+dt+"',"+cid+")";
			System.out.println(query);
			
			int n=st.executeUpdate(query);
			if(n>0) {
				System.out.println("Insertion done");
			}else {
				System.out.println("error occured");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
