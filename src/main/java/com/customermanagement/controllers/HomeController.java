package com.customermanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customermanagement.config.ServiceConfig;
import com.customermanagement.pojo.User;
import com.customermanagement.security.dto.UserDto;
import com.customermanagement.service.IUserService;
import com.customermanagement.service_communication.ProducService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class HomeController {

	@Autowired
	ServiceConfig config;
	
	@Autowired
	ProducService service;
	
	@Autowired
	IUserService userService;

	@Autowired
	ObjectMapper mapper;
	
	@GetMapping("/")
	public String hello()
	{
		return config.getProperty();
	}
	
	@GetMapping("/un")
	public String helloUnprotected()
	{
		System.err.println("/un");
		return config.getProperty();
	}
	
//	@PostMapping("/users")
//	public ResponseEntity<?> addNewUser(@RequestBody User newUser)
//	{
//		System.err.println(newUser);
//		return ResponseEntity.ok(userService.addNewUser(newUser));
//	}
	@PostMapping("/users")
	public ResponseEntity<?> addNewUser(@RequestBody UserDto dto)
	{
		User newUser=new User(dto);
		System.err.println(newUser);
		return ResponseEntity.ok(userService.addNewUser(newUser));
	}
	
	@PutMapping("/users")
	public ResponseEntity<?> updateUser(@RequestBody UserDto dto)
	{
//		User newUser=new User(dto);
//		System.err.println(newUser);
		return ResponseEntity.ok(userService.updateUser(dto));
	}
	
	@GetMapping("/users/email/{email}")
	public ResponseEntity<?> findByEmail(@PathVariable String email)
	{
		return ResponseEntity.ok(userService.findByEmail(email));
	}
}
