package com.pos.service;

import java.util.List;


import com.pos.model.Product;

public interface ProductService {
	public Product saveProduct(Product product);
	public List<Product> getAllCategorys();
	public Product getProductById(Long id);
	public Product updateProduct(Product product);
	public void deleteProductById(Product product);
	public List<Product> listAll(String keyword);
}
