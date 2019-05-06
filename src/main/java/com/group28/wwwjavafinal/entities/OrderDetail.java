package com.group28.wwwjavafinal.entities;

public class OrderDetail extends BaseEntity {
	private String productId;
	private String orderId;
	private int quantity;

	public OrderDetail() {
	}
	
	public OrderDetail(String productId, String orderId, int quantity) {
		this.productId = productId;
		this.orderId = orderId;
		this.quantity = quantity;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
