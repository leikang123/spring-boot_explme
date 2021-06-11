package com.bjsxt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjsxt.dao.UserDaoIm;

@Service
public class UserServiceIm {
	 
	@Autowired
	private UserDaoIm userDaoIm;
	
	
	public void addUser() {
		this.userDaoIm.saveUser();
	}

}
