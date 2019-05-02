package com.group28.wwwjavafinal.entities;

public class Product extends BaseEntity {
	private String name;
	private String description;
	private String imageUrl;
	private ProductBrand brand;
	private ProductSize size;
	private ProductType type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public ProductBrand getBrand() {
		return brand;
	}

	public void setBrand(ProductBrand brand) {
		this.brand = brand;
	}

	public ProductSize getSize() {
		return size;
	}

	public void setSize(ProductSize size) {
		this.size = size;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}	
}
