package com.group28.wwwjavafinal.models;

public class CartModel {
	private PaginationModel<CartDetail> cartDetails;
	private HeaderModel headerModel;

	public CartModel(PaginationModel<CartDetail> cartDetails, HeaderModel headerModel) {
		this.cartDetails = cartDetails;
		this.headerModel = headerModel;
	}

	public PaginationModel<CartDetail> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(PaginationModel<CartDetail> cartDetails) {
		this.cartDetails = cartDetails;
	}

	public HeaderModel getHeaderModel() {
		return headerModel;
	}

	public void setHeaderModel(HeaderModel headerModel) {
		this.headerModel = headerModel;
	}
}
