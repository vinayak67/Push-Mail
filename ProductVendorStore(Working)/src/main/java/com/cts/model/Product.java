package com.cts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_tab")
public class Product {
	
	public int getVendor_id() {
		return vendor_id;
	}


	public void setVendor_id(int vendor_id) {
		this.vendor_id = vendor_id;
	}


	public Product(int id, String brand, String category, String name, float price, float rating, String description,
			int vendor_id) {
		super();
		this.id = id;
		this.brand = brand;
		this.category = category;
		this.name = name;
		this.price = price;
		this.rating = rating;
		this.description = description;
		this.vendor_id = vendor_id;
	}

	@Id
	@Column(name="product_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="brand",length=50)
	String brand;
	
	@Column(name="category",length=50)
	String category;
	
	@Column(name="name",length=50)
	String name;
	
	@Column(name="price")
	float price;
	
	@Column(name="rating")
	float rating;
	
	@Column(name="description",length=300)
	String description;
	
	@Column(name="vendor_id")
	int vendor_id;
	
	
	
	public Product(int id, String brand, String category, String name, float price, float rating, String description) {
		super();
		this.id = id;
		this.brand = brand;
		this.category = category;
		this.name = name;
		this.price = price;
		this.rating = rating;
		this.description = description;
	}
	
	
	public Product() {
		super();
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", brand=" + brand + ", category=" + category + ", name=" + name + ", price="
				+ price + ", rating=" + rating + ", description=" + description + ", vendor_id=" + vendor_id + "]";
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}	
		
}
