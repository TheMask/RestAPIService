package com.aman.rest.service;


import java.util.List;

import com.aman.rest.model.User;

public interface UserService {

	public List<User> getAllUsers();
	
	public User findUserById(String userId);
		
	public String createUser(User u);

	public String deleteUser(String userId);
		
	public String updateUser(User u);
	
	
}
