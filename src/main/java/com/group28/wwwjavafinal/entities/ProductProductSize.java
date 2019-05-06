package com.group28.wwwjavafinal.entities;

public class ProductProductSize extends BaseEntity {
	private int productId;
	private int productSizeId;
	private int remainedInStock;
	
	public ProductProductSize() {
	}
	
	public ProductProductSize(int productId, int productSizeId, int remainedInStock) {
		this.productId = productId;
		this.productSizeId = productSizeId;
		this.remainedInStock = remainedInStock;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductSizeId() {
		return productSizeId;
	}
	public void setProductSizeId(int productSizeId) {
		this.productSizeId = productSizeId;
	}
	public int getRemainedInStock() {
		return remainedInStock;
	}
	public void setRemainedInStock(int remainedInStock) {
		this.remainedInStock = remainedInStock;
	}
}
