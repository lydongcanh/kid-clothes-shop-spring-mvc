package com.group28.wwwjavafinal.services;

import java.util.function.Consumer;
import java.util.function.Predicate;

import javax.servlet.http.HttpSession;

import com.group28.wwwjavafinal.entities.Account;
import com.group28.wwwjavafinal.infrastructure.database.IRepository;

public class AccountServices {
	private static final String LOGGED_IN_SESSION_KEY = "isLoggedIn";
	
	private IRepository<Account> accountRepository;
	private HttpSession session;
	
	public AccountServices(IRepository<Account> accountRepository, HttpSession session) {
		this.accountRepository = accountRepository;
		this.session = session;
	}
	
	public boolean isLoggedIn() {
		return session.getAttribute(LOGGED_IN_SESSION_KEY) != null;
	}
	
	public boolean isExistAccount(String email) {
		return accountRepository.select(a -> a.getEmail() == email) != null;
	}
	
	public void login(String email, String password,
		Consumer<Account> onSuccess, Consumer<String> onFailed) {
		try {
			Predicate<Account> predicate = a -> a.getEmail() == email && a.getPassword() == password;
			Account account = accountRepository.select(predicate);
			
			if (account == null) {
				onFailed.accept("Tài khoản hoặc mật khẩu không đúng.");
				return;
			}
			
			onSuccess.accept(account);
			session.setAttribute(LOGGED_IN_SESSION_KEY, true);
		} catch (Exception e) {
			onFailed.accept(e.getMessage());
		}
	}
	
	public void logout(Runnable onSuccess) {
		session.setAttribute(LOGGED_IN_SESSION_KEY, null);
		onSuccess.run();
	}
	
	public void createNewAccount(String email, String password, boolean isActivated, boolean isAdmin,
		Consumer<Account> onSuccess, Consumer<String> onFailed) {
		if (isExistAccount(email)) {
			onFailed.accept("Email đã được sử dụng để đăng kí tài khoản khác.");
			return;
		}
		
		Account account = new Account(email, password, isActivated, isAdmin);
		if (accountRepository.add(account)) {
			onSuccess.accept(account);
		}
	}
}
