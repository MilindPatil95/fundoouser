package com.bridgelab.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelab.dto.LoginDto;
import com.bridgelab.dto.UserDto;
import com.bridgelab.model.User;
import com.bridgelab.repository.UserRepository;

@Service
public class UserService {
	ModelMapper mappper = new ModelMapper();
	@Autowired
	private UserRepository userRepository;
	// @method: return users list
	public List<User> getUsers() {                          
		List<User> list = new ArrayList<User>();
		userRepository.findAll().forEach(list::add);
		return list;
	}
	// @method: add data in repository
	public void addUser(UserDto userDto) {
		User user = mappper.map(userDto, User.class);   //convert dto to User type object
		userRepository.save(user);
	}
	// @method: remove user form repository
	public void removeUser(int id) {
		userRepository.deleteById(id);
	}
	// @method: search user by id in repository
	public void searchUser(int id) {
		userRepository.findById(id);
	}
	// @method: verify log user
	/**
	 * @purpose : login verification 
	 * @param logindto : store credential data
	 * @return : string
	 */
	public String loginVerification(LoginDto logindto) 
	{
		int flag=0, flag1=0;
		List<User> list = getUsers();
	
		for (User u : list) {
			 flag=0;flag1=0;
			if (u.getName().equals(logindto.getUserName())) {
				flag = 1;
				if (u.getPassword().equals(logindto.getPassword())) {
					flag1 = 1;
					return "**************************WELCOME************** you r login";
				}else break;
			}
		}
		if (list.isEmpty()) {
			return " users not  present";
		}
		if (flag == 0) {
			return "login fail: User name is wrong";
		} else if (flag1 == 0) {
			return "login fail:User password is wrong";
		} 
		return "";
	}

}