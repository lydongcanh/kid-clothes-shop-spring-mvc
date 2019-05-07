package com.group28.wwwjavafinal.models;

import java.util.List;

import com.group28.wwwjavafinal.entities.Product;
import com.group28.wwwjavafinal.entities.ProductBrand;
import com.group28.wwwjavafinal.entities.ProductSize;
import com.group28.wwwjavafinal.entities.ProductType;

public class ProductListModel extends PaginationModel<Product>{

	private List<ProductBrand> brands;
	private List<ProductSize> sizes;
	private List<ProductType> types;
	
	public ProductListModel(List<Product> list, int itemsPerPage, int currentPage, int totalItems) {
		super(list, itemsPerPage, currentPage, totalItems);
	}

	public List<ProductBrand> getBrands() {
		return brands;
	}

	public void setBrands(List<ProductBrand> brands) {
		this.brands = brands;
	}

	public List<ProductSize> getSizes() {
		return sizes;
	}

	public void setSizes(List<ProductSize> sizes) {
		this.sizes = sizes;
	}

	public List<ProductType> getTypes() {
		return types;
	}

	public void setTypes(List<ProductType> types) {
		this.types = types;
	}
}
