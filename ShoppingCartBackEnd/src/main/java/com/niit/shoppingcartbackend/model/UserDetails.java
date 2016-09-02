package com.niit.shoppingcartbackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "UserDetails")
@Component
public class UserDetails {
	private String User_id;
	private String User_name;
	private String Phone_no;
	private String Gender;
	private String Password;

	public String getUser_id() {
		return User_id;
	}

	public void setUser_id(String user_id) {
		User_id = user_id;
	}

	public String getUser_name() {
		return User_name;
	}

	public void setUser_name(String user_name) {
		User_name = user_name;
	}

	public String getPhone_no() {
		return Phone_no;
	}

	public void setPhone_no(String phone_no) {
		Phone_no = phone_no;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
}
