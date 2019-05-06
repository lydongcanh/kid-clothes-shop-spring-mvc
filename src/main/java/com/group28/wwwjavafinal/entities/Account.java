package com.group28.wwwjavafinal.entities;

public class Account extends BaseEntity {
	private String username;
	private String password;
	private boolean isActivated;
	private boolean isAdmin;
	
	public Account() {
	}
	
	public Account(String username, String password, boolean isActivated, boolean isAdmin) {
		this.username = username;
		this.password = password;
		this.isActivated = isActivated;
		this.isAdmin = isAdmin;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
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
