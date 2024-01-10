package com.sunbeam.beans;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class LoginBean {
	String email;
	String password;
	User user;
	
	public LoginBean() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void authenticate()
	{
		try(UserDao user = new UserDaoImpl())
		{
			User u = user.findByEmail(email);
			if(u!=null && u.getPassword().equals(password)) {
				this.user = u;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
