package com.group28.wwwjavafinal.models;

public class LoginModel {
	private String email;
	private String password;
	private String errorMessage;

	public LoginModel(String email, String password, String errorMessage) {
		this.email = email;
		this.password = password;
		this.errorMessage = errorMessage;
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

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
