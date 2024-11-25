package com.demo.service;

import java.util.List;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{

	  private ProductDao pdao;

	  public ProductServiceImpl() {
	  	super();
	  	this.pdao = new ProductDaoImpl();
	  }

	  @Override
		public List<Product> showAllProducts() {
			
			return pdao.showAllProduct();
		}



	@Override
	public boolean insertProduct(Product p) {
		
		return pdao.insertProduct(p);
	}

	@Override
	public Product getById(int pid) {
		
		return pdao.getById(pid);
	}

	@Override
	public boolean deletById(int pid) {
		// TODO Auto-generated method stub
		return pdao.deletById(pid);
	}

	@Override
	public boolean updateProduct(Product p) {
		// TODO Auto-generated method stub
		return pdao.updateProduct(p);
	}



	

}
