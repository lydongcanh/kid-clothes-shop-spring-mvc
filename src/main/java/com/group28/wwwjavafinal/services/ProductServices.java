package com.group28.wwwjavafinal.services;

import java.util.List;

import com.group28.wwwjavafinal.entities.Product;
import com.group28.wwwjavafinal.infrastructure.database.IRepository;

public class ProductServices {
	private IRepository<Product> productRepository;
	
	public ProductServices(IRepository<Product> productRepository) {
		this.productRepository = productRepository;
	}
}
