package com.aman.rest.dao;

import java.util.List;

import com.aman.rest.model.User;

public interface UserDAO {

	
	
	public List<User> getAllUsers();
	
	
	public List<User> findUserById(String userId);
	
	
	public void insertUser(User u);
	
	
	public void deleteUser(String userId);
	
	
	public void updateUser(User user);
	
}
