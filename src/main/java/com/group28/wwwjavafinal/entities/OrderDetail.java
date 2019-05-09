package com.group28.wwwjavafinal.entities;

public class OrderDetail extends BaseEntity {
	private int productId;
	private int orderId;
	private int quantity;

	public OrderDetail() {
	}
	
	public OrderDetail(int productId, int orderId, int quantity) {
		this.productId = productId;
		this.orderId = orderId;
		this.quantity = quantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
