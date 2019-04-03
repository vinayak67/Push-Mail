package com.cts.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="vendor_tab")
public class Vendor{
	
	public Vendor(int id, String name, long contact, String location, List<Product> product) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.location = location;
		this.product = product;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Id
	@Column(name="vendor_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="name",length=50)
	String name;
	
	@Column(name="contact")
	long contact;
	
	@Column(name="location",length=50)
	String location;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="vendor_id",fetch=FetchType.EAGER)
	private List<Product> product=new ArrayList<>();
	
	public Vendor() {
		super();
	}

	public Vendor(int id, String name, long contact, String location) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", contact=" + contact + ", location=" + location + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


}