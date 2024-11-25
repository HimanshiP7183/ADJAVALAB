package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			String url="jdbc:mysql://localhost:3306/adjava?useSSL=false";
			
		Connection conn=DriverManager.getConnection(url,"root","welcome");
		
		if(conn!=null) {
			System.out.println("connection done......");
		}else {
			System.out.println("error Occured");
		}
		conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
