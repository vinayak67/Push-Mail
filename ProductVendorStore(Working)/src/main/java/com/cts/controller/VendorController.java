package com.cts.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Product;
import com.cts.model.Vendor;
import com.cts.service.VendorService;



@Controller
@RequestMapping("/vendor")
public class VendorController {

@Autowired
VendorService vendorService;


@GetMapping("/vendorlist")
@Transactional
public String getAllVendors(Model model)
{

	List<Vendor> lb=vendorService.getAllVendors();
	model.addAttribute("vendor",lb);
	return "vendorlist";
}

@GetMapping("/showProduct")
public String showProductOfVendor(@RequestParam("vendorId") int theId, Model model)
{
	List<Product> theProducts =vendorService.showAllProducts(theId);
	model.addAttribute("products",theProducts);
	return "showproduct";
}

@GetMapping("/logout")
public String logoutPage(HttpServletRequest request,HttpServletResponse response)
{
	Authentication auth=SecurityContextHolder.getContext().getAuthentication();
	
	if(auth!=null)
		new SecurityContextLogoutHandler().logout(request, response, auth);
	
	return "redirect:/login?logout=true";
}


@GetMapping("/showForm")
@Transactional
public String showFormForAdd(Model model)
{
	Vendor vendor = new Vendor();
	
	model.addAttribute("vendor",vendor);
	return "addvendor";
}

@PostMapping("/saveVendor")
@Transactional
public String saveAVendor(@ModelAttribute("vendor") Vendor vendor)
{
	vendorService.saveVendor(vendor);
	return "redirect:/vendor/vendorlist";
}



@GetMapping("/delete")
@Transactional
public String deleteAVendor(@RequestParam("vendorId") int theId , Model model)
{
	vendorService.deleteVendor(theId);
	return "redirect:/vendor/vendorlist";
}

}