package com.balaji.callbacks;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.balaji.model.Product;

public class ProductPSC implements PreparedStatementCallback<Integer>{
	private Product product;
	public ProductPSC(Product product) {
		super();
		this.product = product;
	}
	@Override
	public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
		ps.setInt(1, product.getPid());
		ps.setString(2, product.getPname());
		ps.setDouble(3, product.getPcost());
		int count = ps.executeUpdate();
		return count;
	}

}
