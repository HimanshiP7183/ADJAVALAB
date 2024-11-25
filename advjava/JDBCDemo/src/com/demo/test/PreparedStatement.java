package com.demo.test;
import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;

public class PreparedStatement {

	public static void main(String[] args) {
		Connection conn=null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://localhost:3306/adjava?useSSL=false";
			 conn=DriverManager.getConnection(url,"root","welcome");
			PreparedStatement pst= (PreparedStatement) conn.prepareStatement("select * from product1");
			ResultSet rs=((java.sql.PreparedStatement) pst).executeQuery();

			while(rs.next()) {
				System.out.println("pid : "+rs.getInt(1));
				System.out.println("pname : "+rs.getString(2));
				System.out.println("qty : "+rs.getInt(3));
				System.out.println("price : "+rs.getDouble(4));
				System.out.println("expiry date : "+rs.getDate(5));
				System.out.println("cid : "+rs.getInt(6));
				System.out.println("-------------------------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
