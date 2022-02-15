package com.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author	Dinesh Yogi
 * @desc	User model class which use for data set and get
 */

@Getter
@Setter
public class User {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;

}