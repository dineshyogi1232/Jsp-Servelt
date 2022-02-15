package com.dao;

import java.util.List;
import com.model.User;

/**
 * @author	Dinesh Yogi
 * @desc	create abstract method of data transaction
 */
public interface UserService {

	public int insertUserData(User user);

	public List<User> getAllUser();

}