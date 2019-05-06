package com.group28.wwwjavafinal.models;

import java.util.List;

import com.group28.wwwjavafinal.entities.Product;

public class ProductListModel {
	private List<Product> products;
	private int productPerPage;
	private int currentPage;
	private int totalProducts;

	public ProductListModel(List<Product> products, int productPerPage, int currentPage, int totalProducts) {
		this.products = products;
		this.productPerPage = productPerPage;
		this.currentPage = currentPage;
		this.totalProducts = totalProducts;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getProductPerPage() {
		return productPerPage;
	}

	public void setProductPerPage(int productPerPage) {
		this.productPerPage = productPerPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalProducts() {
		return totalProducts;
	}

	public void setTotalProducts(int totalPages) {
		this.totalProducts = totalPages;
	}
	
	public int getTotalPages() {
		return (int)Math.ceil((double)totalProducts / productPerPage);
	}
}
