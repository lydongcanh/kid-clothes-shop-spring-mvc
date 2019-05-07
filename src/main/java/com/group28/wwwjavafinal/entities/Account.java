package com.group28.wwwjavafinal.entities;

public class Account extends BaseEntity {
	private String email;
	private String password;
	private boolean isActivated;
	private boolean isAdmin;
	
	public Account() {
	}
	
	public Account(String email, String password, boolean isActivated, boolean isAdmin) {
		this.email = email;
		this.password = password;
		this.isActivated = isActivated;
		this.isAdmin = isAdmin;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String username) {
		this.email = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActivated() {
		return isActivated;
	}

	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
