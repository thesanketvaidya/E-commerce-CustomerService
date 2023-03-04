package com.customermanagement.service;

import com.customermanagement.pojo.User;
import com.customermanagement.security.dto.UserDto;

public interface IUserService {
	
	User updateUser(UserDto dto);
	User addNewUser(User newUser);
	User findByEmail(String email);
}
