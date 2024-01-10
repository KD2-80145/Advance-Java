package com.sunbeam.beans;

import java.sql.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class RegistrationBean {
	String firstName;
	String lastName;
	String email;
	String password;
	String dob;
	String role;
	boolean status;
	
	
	public RegistrationBean() {
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void save() {
		
		try(UserDao ud = new UserDaoImpl())
		{
			Date dt = Date.valueOf(dob);
			User u = new User(1,firstName,lastName,email,password,dt,0,role);
			int cnt = ud.save(u);
			if(cnt == 1)
				this.status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
