package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao {

	static Connection conn;
	static PreparedStatement getAll, insertPro,getById,delPro,updateprod;
	static {

		try {
			conn = DBUtil.getMyConnection();
			getAll = conn.prepareStatement("select * from product1");
			insertPro = conn.prepareStatement("insert into product1 values(?,?,?,?,?,?)");
			getById=conn.prepareStatement("select * from product where pid=?");
			delPro=conn.prepareStatement("delete from product1 where pid=? ");
			updateprod=conn.prepareStatement("update product1 set pname=?,qty=?,price=?,expdate=?,cid=? where pid=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> showAllProduct() {
		List<Product> plist = new ArrayList<>();
		try {
			ResultSet rs = getAll.executeQuery();
			while (rs.next()) {
				plist.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4),
						rs.getDate(5).toLocalDate(), rs.getInt(6)));
			}
			if (plist.size() > 0)
				return plist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public boolean insertProduct(Product p) {
		try {
			insertPro.setInt(1, p.getPid());
			insertPro.setString(2, p.getPname());
			insertPro.setInt(3, p.getQty());
			insertPro.setDouble(4, p.getPrice());
			insertPro.setDate(5, java.sql.Date.valueOf(p.getExpdate()));
			insertPro.setInt(6, p.getCid());
			int n=insertPro.executeUpdate();
			if(n>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Product getById(int pid) {
		try {
			getById.setInt(1, pid);
			ResultSet rs=getById.executeQuery();
			if(rs.next()) {
				return new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate(),rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public boolean deletById(int pid) {
		try {
			delPro.setInt(1, pid);
			int n=delPro.executeUpdate();
			if(n>0) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}


	@Override
	public boolean updateProduct(Product p) {
		try {
			updateprod.setString(1, p.getPname());
			updateprod.setInt(2, p.getQty());
			updateprod.setDouble(3, p.getPrice());
			updateprod.setDate(4, java.sql.Date.valueOf(p.getExpdate()));
			updateprod.setInt(5, p.getCid());
			updateprod.setInt(6, p.getPid());
			int n=updateprod.executeUpdate();
			if (n>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
