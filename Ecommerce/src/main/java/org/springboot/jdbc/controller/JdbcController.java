package org.springboot.jdbc.controller;

import java.util.List;

import org.springboot.jdbc.model.Product;
import org.springboot.jdbc.model.User;
import org.springboot.jdbc.service.ProductService;
import org.springboot.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JdbcController {

	@Autowired
	UserService userservice;
	@Autowired
	ProductService productservice;
	
	@GetMapping("/user")
	private List<User> getAllUser(){
		return userservice.getAllUsers();
	}
	
	//getting specific user
	@GetMapping("/user/{id}")
	private User getUser(@PathVariable("id") int id){
		return userservice.getUserById(id);
	}
	

	//deleting specific user
	@DeleteMapping("/user/{id}")
	private void deleteUser(@PathVariable ("id") int id){
		userservice.delete(id);
	}
	
   @PostMapping("/user")
	private int saveUser(@RequestBody User user){
		userservice.saveOrUpdate(user);
		return user.getId();
	}
	
   //============================product service==========================
   @GetMapping("/product")
   private List<Product> getAllProduct(){
	   return productservice.getAllProducts();
   }
   
   //getting specific product
   @GetMapping("/product/{id}")
   private Product getProduct(@PathVariable("id") int id) {
	   return productservice.getProductById(id);
   }
   
   
   //deleting a specific product
   @DeleteMapping("/product/{id}")
   private void deleteProduct(@PathVariable("id") int id) {
	   productservice.delete(id);
   }
   
   @PostMapping("/product")
   private int saveProduct(@RequestBody Product product) {
	   productservice.saveOrUpdate(product);
	   return product.getId();
   }
	
}