package com.cts.service;

import java.util.List;


import com.cts.model.Product;



public interface ProductService {
	
List<Product> getAllProducts();
void saveProduct(Product product);
public Product getProduct(int theId);
public void deleteProduct(int theId);

}
