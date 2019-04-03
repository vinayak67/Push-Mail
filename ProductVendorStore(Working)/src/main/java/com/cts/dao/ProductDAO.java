package com.cts.dao;
import java.util.List;
import com.cts.model.Product;


public interface ProductDAO {

	void  saveProduct(Product product);
  List<Product>  listAllProducts();
 Product getProduct(int id);
 void deleteProduct(int id);

 
}
