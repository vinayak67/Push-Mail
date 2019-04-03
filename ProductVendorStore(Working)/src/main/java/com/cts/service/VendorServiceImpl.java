package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.dao.VendorDAO;
import com.cts.model.Product;
import com.cts.model.Vendor;

@Service("vendorService")
public class VendorServiceImpl implements VendorService {

	
	@Autowired
	VendorDAO vendorDAO;
	@Override
	@Transactional
	public List<Vendor> getAllVendors() {
		
		
		return vendorDAO.listAllVendors();
	}
	@Override
	@Transactional
	public List<Product> showAllProducts(int theId) {
	
		return vendorDAO.listAllVendorProducts(theId) ;
	}


	@Override
	@Transactional
	public void saveVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		vendorDAO.saveVendor(vendor);
	}


	@Override
	public void deleteVendor(int theId) {
		// TODO Auto-generated method stub
		vendorDAO.deleteVendor(theId);
	}
}
