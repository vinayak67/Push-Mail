package com.cts.dao;

import java.util.List;

import com.cts.model.Product;
import com.cts.model.Vendor;

public interface VendorDAO {
	
	List<Vendor> listAllVendors();

	List<Product> listAllVendorProducts(int theId);

	void saveVendor(Vendor vendor);

	void deleteVendor(int theId);



}
