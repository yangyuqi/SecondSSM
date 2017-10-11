package com.second.api.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.api.dao.user.UserDao;
import com.second.api.model.user.User;

@Service
public class UserServiceImp {

	@Autowired
	UserDao dao ;
	
	public User getUserInfo(String name) {
		return dao.getUserInfo(name);
	}
	
}
