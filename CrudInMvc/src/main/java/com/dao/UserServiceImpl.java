package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.User;
import com.util.DBConnectionProvider;

/**
 * @author Dinesh Yogi
 * @desc implement methods of data transaction
 */
public class UserServiceImpl implements UserService {

	User user;
	Connection connection = null;

	@SuppressWarnings("null")
	@Override
	public int insertUserData(User user) {
		int flag = 0;
		connection = DBConnectionProvider.getConnection();
		PreparedStatement preparedStatement = null;
		String query = "insert into userdata(firstname,lastname,email,password) values(?,?,?,?);";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			flag = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("***SQL Exception***");
		} finally {
			try {
				if (preparedStatement == null) {
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException e) {
				System.err.println("** Insert method exception **");
			}
		}
		return flag;
	}

	@SuppressWarnings("null")
	@Override
	public List<User> getAllUser() {
		List<User> usersData = new ArrayList<>();
		connection = DBConnectionProvider.getConnection();
		String query = "Select * from userdata;";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				user = new User();
				user.setFirstName(resultSet.getString("firstname"));
				user.setLastName(resultSet.getString("lastname"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
				usersData.add(user);
			}
		} catch (SQLException e) {
			System.err.println("***Sql Exception***");
		} finally {
			try {
				if (resultSet.first() == false && preparedStatement == null) {
					resultSet.close();
					preparedStatement.closeOnCompletion();
					connection.close();
				}
			} catch (SQLException e) {
				System.err.println("** SQL Exceptionm in transaction when close**");
			}
		}
		return usersData;
	}

}