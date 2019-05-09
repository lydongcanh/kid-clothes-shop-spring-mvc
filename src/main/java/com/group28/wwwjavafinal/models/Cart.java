package com.group28.wwwjavafinal.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<CartDetail> details;
	
	public Cart() {
		details = new ArrayList<>();
	}
	
	public void addProduct(int productId) {
		if(updateQuantity(productId, 1))
			return;
		
		details.add(new CartDetail(productId, 1));
	}
	
	public void removeProduct(int productId) {
		for(CartDetail detail : details) {
			if (detail.getProductId() == productId) {
				details.remove(detail);
				return;
			}
		}
	}
	
	public boolean updateQuantity(int productId, int quantity) {
		for(CartDetail detail : details) {
			if (detail.getProductId() == productId) {
				detail.setQuantity(detail.getQuantity() + quantity);
				return true;
			}
		}
		
		return false;
	}
	
	public List<CartDetail> getDetails() {
		return details;
	}
}
