package com.group28.wwwjavafinal.models;

public class HeaderModel {
	private boolean isLoggedIn;
	private int productInCart;

	public HeaderModel(boolean isLoggedIn, int productInCart) {
		this.isLoggedIn = isLoggedIn;
		this.productInCart = productInCart;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public int getProductInCart() {
		return productInCart;
	}

	public void setProductInCart(int productInCart) {
		this.productInCart = productInCart;
	}
}
