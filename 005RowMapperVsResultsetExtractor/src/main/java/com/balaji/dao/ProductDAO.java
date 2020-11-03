package com.balaji.dao;

import java.util.List;

import com.balaji.model.Product;

public interface ProductDAO {
	
	public Product findById(int pid);
	public List<Product> findAll();

}
