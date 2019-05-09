package com.group28.wwwjavafinal.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.group28.wwwjavafinal.models.Cart;
import com.group28.wwwjavafinal.models.CartDetail;

public class CartServices {
	
	private static final String CART_SESSION_KEY = "CART_SESSION_KEY";
	
	private HttpSession session;
	
	public int getCartSize() {
		return getDetails().size();
	}
	
	public List<CartDetail> getDetails() {
		Object cartObj = session.getAttribute(CART_SESSION_KEY);
		return cartObj != null ? ((Cart)cartObj).getDetails() : new ArrayList<>();
	}
	
	public void addProduct(int productId) {
		Object cartObj = session.getAttribute(CART_SESSION_KEY);
		Cart cart = cartObj != null ? (Cart)cartObj : new Cart();
		cart.addProduct(productId);
		session.setAttribute(CART_SESSION_KEY, cart);
	}
	
	public void removeProduct(int productId) {
		Object cartObj = session.getAttribute(CART_SESSION_KEY);
		Cart cart = cartObj != null ? (Cart)cartObj : new Cart();
		cart.removeProduct(productId);
		session.setAttribute(CART_SESSION_KEY, cart);
	}
	
	public boolean updateQuantity(int productId, int quantity) {
		Object cartObj = session.getAttribute(CART_SESSION_KEY);
		Cart cart = cartObj != null ? (Cart)cartObj : new Cart();
		boolean result = cart.updateQuantity(productId, quantity);
		session.setAttribute(CART_SESSION_KEY, cart);
		return result;
	}
	
	public void setSession(HttpSession session) {
		this.session = session;
	}
}
