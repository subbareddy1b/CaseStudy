package org.springboot.jdbc.service;

import java.util.ArrayList;
import java.util.List;

import org.springboot.jdbc.model.Product;
import org.springboot.jdbc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	ProductRepository productrepo;

	//getting all products
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();

		productrepo.findAll().forEach(product -> products.add(product));
		return products;
	}
	
	//Get product by Id
	public Product getProductById(int id) {
		return productrepo.findById(id).get();
	}

	
	//save or update a record
	public void saveOrUpdate(Product product) {
		productrepo.save(product);
	}
	
	//delete a record by id
	public void delete(int id) {
		productrepo.deleteById(id);
	}

}
