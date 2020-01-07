package com.bridgelab;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class FundooService {
	ModelMapper mappper = new ModelMapper();
	@Autowired
	private FundooRepository fundooRepository;

	public List<User> getUsers() {
		List<User> list = new ArrayList<User>();
		fundooRepository.findAll().forEach(list::add);
		return list;
	}

	public void addUser(UserDto userDto) {
		User user = mappper.map(userDto, User.class);
		fundooRepository.save(user);
	}

	public void removeUser(int id) {
		fundooRepository.deleteById(id);
	}

	public void searchUser(int id) {
		fundooRepository.findById(id);
	}

	public String loginVerification(LoginDto logindto) // userdto is data transfer object
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