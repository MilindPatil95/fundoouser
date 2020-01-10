package com.bridgelab.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelab.dto.LoginDto;
import com.bridgelab.dto.UserDto;
import com.bridgelab.model.User;
import com.bridgelab.service.UserService;
@RestController
@RequestMapping("/fundoo")
public class UserController
{
	@Autowired
	private UserService userService;
	@GetMapping("/users")
	public  List<User>  users()
	{ 
	  return userService.getUsers();	 
	}
	@PostMapping("/registration")
	public String addUser(@RequestBody UserDto userDto)
	{
		System.out.println(userDto.getName());
		userService.addUser(userDto);
		return "added";
	}   
	@GetMapping("/login")
	public String loginUser(@RequestBody LoginDto logindto)
	{
	 return userService.loginVerification(logindto); 
	}
}