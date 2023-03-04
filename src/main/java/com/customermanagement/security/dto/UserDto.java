package com.customermanagement.security.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.customermanagement.enums.RoleEnum;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto {
	
	private String firstName; 
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	private String role;
	
	private String mobile;
	
	private String address;
	
	

}
