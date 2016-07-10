package com.aman.rest.controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aman.rest.model.User;
import com.aman.rest.service.UserService;

@RestController
public class MainController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/user/{id}")
	public ResponseEntity<User> handleSingleUserRequest(@PathVariable("id") String userId)
	{
		User user=null;
		try {	
		user=userService.findUserById(userId);
		}
		catch(Exception e)
		{
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(user==null)
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
		
		
		
	}
	
	@RequestMapping("/users")
	public ResponseEntity<List<User>> handleAllUsersRequest()
	{
		List<User> list=null;
		try
		{
		list=userService.getAllUsers();
		}
		catch(Exception e)
		{
			return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(list==null || list.size()==0)
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value="/createuser",method=RequestMethod.POST)
	public ResponseEntity<Void> handleCreateUserRequest(@RequestBody User user)
	{
		try
		{
			if(userService.createUser(user).equals("CONFLICT"))
			{
				return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			}
		}
		catch(Exception e)
		{
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
		
		
	}
	
	@RequestMapping("/deleteuser/{id}")
	public ResponseEntity<User> handleDeleteUserRequest(@PathVariable("id") String userId)
	{
		try{
			if(	userService.deleteUser(userId).equals("NOT FOUND"))
			{
				return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception e)
		{
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateuser",method=RequestMethod.POST)
	public ResponseEntity<Void> handleDeleteUserRequest(@RequestBody User user)
	{
		try{
			if(userService.updateUser(user).equals("NOT FOUND"))
			{
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception e)
		{
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
}
