package com.balaji.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.balaji.callbacks.IncrementCSC;
import com.balaji.callbacks.ProductPSC;
import com.balaji.model.Product;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Integer saveWithPSC(Product product) {
		String query = "INSERT INTO PRODUCT VALUES(?,?,?)";
		return jdbcTemplate.execute(query, new ProductPSC(product));
	}

	@Override
	public Integer callIncrementFunction(int num) {
		return jdbcTemplate.execute("{?=call increment(?)}", new IncrementCSC(num));
	}

	@Override
	public Integer callIncrementFunctionWithJava8(int num) {
		
		return jdbcTemplate.execute("{?=call increment(?)}", (CallableStatementCallback<Integer>)cs-> {
			cs.setInt(2, num);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			return cs.getInt(1);
		});
	}
	
	
	

}
