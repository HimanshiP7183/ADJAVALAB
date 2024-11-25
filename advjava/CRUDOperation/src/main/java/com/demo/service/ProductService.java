package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {



	List<Product> showAllProducts();
	boolean insertProduct(Product p);

	Product getById(int pid);
	boolean deletById(int pid);
	boolean updateProduct(Product p);

}
