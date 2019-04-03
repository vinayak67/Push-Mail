package com.cts.service;

import java.util.List;

import com.cts.model.Product;
import com.cts.model.Vendor;

public interface VendorService {
	
	
	
	List<Vendor> getAllVendors();

	List<Product> showAllProducts(int theId);

	void saveVendor(Vendor vendor);

	void deleteVendor(int theId);

}
