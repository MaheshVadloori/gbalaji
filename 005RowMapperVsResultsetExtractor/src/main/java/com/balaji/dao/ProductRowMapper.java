package com.balaji.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.balaji.model.Product;

public class ProductRowMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setPid(rs.getInt(1));
		product.setPname(rs.getString(2));
		product.setPcost(rs.getDouble(3));
		return product;
	}

}
