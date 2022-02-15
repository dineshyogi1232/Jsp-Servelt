package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author	Dinesh Yogi
 * @desc	Established database connection
 */
public class DBConnectionProvider{

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(DBConstant.DRIVER);
			connection = DriverManager.getConnection(DBConstant.URL, DBConstant.USERNAME, DBConstant.PASSWORD);
		} catch (SQLException e) {
			System.err.println("***SQL Exception Throw***");
		} catch (ClassNotFoundException e) {
			System.err.println("***ClassNoFoundException Throw Exception Throw***");
		}
		System.out.println("Connection successfull...");
		return connection;
	}

}