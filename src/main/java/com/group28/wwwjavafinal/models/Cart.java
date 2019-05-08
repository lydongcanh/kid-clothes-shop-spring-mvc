package com.group28.wwwjavafinal.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<CartDetail> details;
	
	public Cart() {
		details = new ArrayList<>();
	}
	
	public void addDetail(CartDetail detail) {
		if (detail == null)
			return;
		
		if(updateQuantity(detail.getProductId(), detail.getQuantity()))
			return;
		
		details.add(detail);
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
}
