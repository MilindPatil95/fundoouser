package com.bridgelab;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/fundoo")
public class FundooController
{
	@Autowired
	private FundooService fundooService;
	@GetMapping("/users")
	public  List<User>  users()
	{ 
	  return fundooService.getUsers();	 
	}
	@PostMapping("/registration")
	public String addUser(@RequestBody UserDto userDto)
	{
		System.out.println(userDto.getName());
		fundooService.addUser(userDto);
		return "added";
	}   
	@GetMapping("/login")
	public String loginUser(@RequestBody LoginDto logindto)
	{
	 return fundooService.loginVerification(logindto); 
	}
}