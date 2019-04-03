package com.cts.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.dao.ProductDAO;
import com.cts.model.Product;


@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO productDAO;
	
	@Override
	@Transactional
	public List<Product> getAllProducts() {
		
		return productDAO.listAllProducts();
	}

	@Override
	@Transactional
	public void saveProduct(Product product) {
		
		productDAO.saveProduct(product);
	}

	@Override
	@Transactional
	public Product getProduct(int theId) {
		
		Product product=productDAO.getProduct(theId);
		return product;
	}

	@Override
	@Transactional
	public void deleteProduct(int theId) {
		
		productDAO.deleteProduct(theId);
		
	}
	
}
