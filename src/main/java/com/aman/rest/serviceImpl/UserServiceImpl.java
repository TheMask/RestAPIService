package com.aman.rest.serviceImpl;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.aman.rest.dao.UserDAO;
import com.aman.rest.model.User;
import com.aman.rest.service.UserService;

public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserDAO userDao;
		
	public List<User> getAllUsers()
	{
		
		List<User> userList= userDao.getAllUsers();
		return userList;
		
	}
	
	public User findUserById(String userId)
	{
		List<User> userList=userDao.findUserById(userId);
		if(userList.size()==0)
		{
			return null;
		}
		else
			return userList.get(0);
		
	}
	
	
	@Transactional
	public String createUser(User u)
	{
		if(findUserById(u.getUserId())!=null)
		{
			return "CONFLICT";
		}
		
		userDao.insertUser(u);
		return "SUCCESS";
	}
	
	@Transactional
	public String deleteUser(String userId)
	{
		if(findUserById(userId)==null)
		{
			return "NOT FOUND";
		}
		
		
		userDao.deleteUser(userId);
		return "SUCCESS";
	}
	
	@Transactional
	public String updateUser(User u)
	{
		if(findUserById(u.getUserId())==null)
		{
			return "NOT FOUND";
		}
			
		userDao.updateUser(u);
		return "SUCCESS";
		
	}
	
}
