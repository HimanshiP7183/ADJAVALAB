package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.MyUser;
import com.demo.beans.Person;

public class LoginDaoImpl implements LoginDao {

	static Connection conn;
	static PreparedStatement seluser,adduser,addPerson;
	static {
		
		try {
			conn=DBUtil.getMyConnection();
			seluser=conn.prepareStatement("select uname ,pwd, role from user where uname=? and pwd=?");
			adduser=conn.prepareStatement("insert into user(uname,pwd,role) values(?,?,?)");
			addPerson=conn.prepareStatement("insert into person(fname,lname,gender,degree,city,skills) values(?,?,?,?,?,?)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public MyUser validation(String uname, String password) {
		try {
			seluser.setString(1,uname);
			seluser.setString(2, password);
			ResultSet rs=seluser.executeQuery();
			if(rs.next()) {
				return new MyUser(rs.getString(1),rs.getString(2),rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean registration(Person p, MyUser user) {
		
		try {
//			conn.setAutoCommit(false);
//			System.out.println(user.getUname()+"------"+user.getPasswd());
			adduser.setString(1, user.getUname());
			adduser.setString(2,user.getPasswd());
			adduser.setString(3,user.getRole());
			adduser.executeUpdate();
			
			addPerson.setString(1, p.getFname());
			addPerson.setString(2, p.getLname());
			addPerson.setString(3, p.getGender());
			addPerson.setString(4, p.getDegree());
			addPerson.setString(5, p.getCity());
			addPerson.setString(6,String.join(",",p.getSkills()) );
			addPerson.executeUpdate();
//			conn.commit();
			
			return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			try {
//				conn.rollback();
//				
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			e.printStackTrace();
		}
//			finally {
//			try {
//				conn.setAutoCommit(true);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		return false;
	}

	

}
