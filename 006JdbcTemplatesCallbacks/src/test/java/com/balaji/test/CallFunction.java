package com.balaji.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallFunction {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/vidvaan","postgres","root");
	    CallableStatement callableStatement = connection.prepareCall("{?=call increment(?)}");
	    callableStatement.setInt(2, 10);
	    callableStatement.registerOutParameter(1, Types.INTEGER);
	    callableStatement.execute();
	    
	    System.out.println(callableStatement.getInt(1));
	
	}

}
