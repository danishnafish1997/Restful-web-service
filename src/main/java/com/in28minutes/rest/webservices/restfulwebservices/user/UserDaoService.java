package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	private static Integer userCount = 3;
	
	static{
		users.add(new User(1,"Danish",new Date()));
		users.add(new User(2,"Abid",new Date()));
		users.add(new User(3,"Atif",new Date()));
	}
	
	public List<User> findAll(){
		return users; 
	}
	
	public User save(User user){
		if(user.getId()== null){
				user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public  User findById(int id){
		for(User user:users)
			if(user.getId()==id)
				return user;
		return null;
	}
	
	public User delete(int id){
		User user = findById(id);
		if(user != null){
			users.remove(user);
			return user;
		}
		return null;	
	}
}
