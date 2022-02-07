package org.springboot.jdbc.service;

import java.util.ArrayList;
import java.util.List;

import org.springboot.jdbc.model.User;
import org.springboot.jdbc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository userrepo;
	
	//listing all users
	public List <User> getAllUsers()
	{
		List <User> users=new ArrayList<User>();
		
		userrepo.findAll().forEach(user -> users.add(user));
		return users;
	}
	
	//listing specific user record
	
	public User getUserById(int id)
	{
		
		return userrepo.findById(id).get();
		
	}
	

	//save or update
	public void saveOrUpdate(User  user)
	{
		
		userrepo.save(user);
	}
	//delete a specific record
	
	public void delete(int id)
	{
		
		userrepo.deleteById(id);
	}
}