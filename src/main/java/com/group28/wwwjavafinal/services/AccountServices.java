package com.group28.wwwjavafinal.services;

import java.util.function.Predicate;

import javax.servlet.http.HttpSession;

import com.group28.wwwjavafinal.controllers.HomeController;
import com.group28.wwwjavafinal.entities.Account;
import com.group28.wwwjavafinal.infrastructure.database.IRepository;

public class AccountServices {
	private static final String LOGGED_IN_SESSION_KEY = "isLoggedIn";
	
	private IRepository<Account> accountRepository;
	private HttpSession session;
	
	public AccountServices(IRepository<Account> accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public boolean isLoggedIn() {
		if (session == null)
			return false;
		
		return session.getAttribute(LOGGED_IN_SESSION_KEY) != null;
	}
	
	public boolean isExistAccount(String email) {
		return accountRepository.select(a -> a.getEmail() == email) != null;
	}
	
	public boolean login(String email, String password) {
		if (email == null || password == null)
			return false;
		
		Predicate<Account> predicate = a -> a.getEmail().equals(email) && a.getPassword().equals(password);
		Account account = accountRepository.select(predicate);
		HomeController.logger.info("login: " + (email + ", " + password));
		if (account == null)
			return false;

		if (session != null)
			session.setAttribute(LOGGED_IN_SESSION_KEY, true);
		
		return true;
	}
	
	public void logout() {
		session.setAttribute(LOGGED_IN_SESSION_KEY, null);
	}
	
	public boolean createNewAccount(String email, String password, boolean isActivated, boolean isAdmin) {
		if (isExistAccount(email)) {
			return false;
		}
		
		Account account = new Account(email, password, isActivated, isAdmin);
		return accountRepository.add(account);
	}
	
	public void setSession(HttpSession session) {
		this.session = session;
	}
}
