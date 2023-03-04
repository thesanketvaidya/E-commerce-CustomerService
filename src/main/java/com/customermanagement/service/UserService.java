package com.customermanagement.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.customermanagement.dao.IUserDao;
import com.customermanagement.pojo.User;
import com.customermanagement.security.dto.UserDto;

@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	IUserDao userDao;
	
	@Autowired 
	PasswordEncoder passEncoder;
	
	@Override
	public User addNewUser(User newUser) {
		
		newUser.setPassword(passEncoder.encode(newUser.getPassword()));
		return userDao.save(newUser);
	}

	@Override
	public User findByEmail(String email) {
		
		return userDao.findByEmail(email);
	}

	@Override
	public User updateUser(UserDto dto) {
		// TODO Auto-generated method stub
		return null;
	}
}
