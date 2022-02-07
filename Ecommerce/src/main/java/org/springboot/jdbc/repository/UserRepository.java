package org.springboot.jdbc.repository;

import org.springboot.jdbc.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,Integer>{

	
	
}