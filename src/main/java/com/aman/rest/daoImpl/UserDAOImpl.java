package com.aman.rest.daoImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.aman.rest.dao.UserDAO;
import com.aman.rest.model.User;

public class UserDAOImpl implements UserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String sql;
	
	public List<User> getAllUsers()
	{
		
		sql="select * from users";
		List<User> userList=new ArrayList<User>();
		List<Map<String, Object>> rows=jdbcTemplate.queryForList(sql);
		for(Map<String, Object> row:rows)
		{
			User u=new User((String)row.get("USERID"),(String)row.get("NAME"),((BigDecimal)row.get("AGE")).intValue(),((BigDecimal)row.get("SALARY")).doubleValue());
			userList.add(u);
		}
		return userList;
	}
	
	public List<User> findUserById(String userId)
	{
		sql="select * from Users where USERID=?";
		return jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class), userId);
	}
	
	public void insertUser(User u)
	{
		
		sql="Insert into users values(?,?,?,?)";
		jdbcTemplate.update(sql, u.getUserId(),u.getName(),u.getAge(),u.getSalary());
	}
	
	public void deleteUser(String userId)
	{
		sql="delete from users where USERID=?";
		jdbcTemplate.update(sql,userId);
	}
	
	public void updateUser(User user)
	{
		sql="Update users set name=?,age=?,salary=? where USERID=?";
		jdbcTemplate.update(sql,user.getName(),user.getAge(),user.getSalary(),user.getUserId());
	}
}
