package com.balaji.callbacks;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;

public class IncrementCSC implements CallableStatementCallback<Integer>{
	
	private int num;
	
	

	public IncrementCSC(int num) {
		super();
		this.num = num;
	}



	@Override
	public Integer doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
		cs.setInt(2, num);
		cs.registerOutParameter(1, Types.INTEGER);
		cs.execute();
		return cs.getInt(1);
	}

}
