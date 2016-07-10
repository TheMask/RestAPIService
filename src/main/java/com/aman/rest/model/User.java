package com.aman.rest.model;

public class User {

		private String userId;
     
	    private String name;
	     
	    private int age;
	     
	    private double salary;
	 
	   	public User()
	   	{}		
	   		    
	   	public String getUserId() {
			return userId;
		}


		public void setUserId(String userId) {
			this.userId = userId;
		}


		public User(String userId, String name, int age, double salary){
			this.userId=userId;
	        this.name = name;
	        this.age = age;
	        this.salary = salary;
	    }
	     
	 
	    public String getName() {
	        return name;
	    }
	 
	    public void setName(String name) {
	        this.name = name;
	    }
	 
	    public int getAge() {
	        return age;
	    }
	 
	    public void setAge(int age) {
	        this.age = age;
	    }
	 
	    public double getSalary() {
	        return salary;
	    }
	 
	    public void setSalary(double salary) {
	        this.salary = salary;
	    }
}
