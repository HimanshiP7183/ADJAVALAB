package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	List<Product> showAllProduct();

	boolean insertProduct(Product p);

	Product getById(int pid);

	boolean deletById(int pid);

	boolean updateProduct(Product p);

}
