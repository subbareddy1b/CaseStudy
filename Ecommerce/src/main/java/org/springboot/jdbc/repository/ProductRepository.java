package org.springboot.jdbc.repository;


import org.springboot.jdbc.model.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product,Integer>{

	
	
}