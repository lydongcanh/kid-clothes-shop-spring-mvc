package com.group28.wwwjavafinal.infrastructure.database.seed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import com.group28.wwwjavafinal.entities.Account;
import com.group28.wwwjavafinal.infrastructure.database.IRepository;

public class AccountSeedRepository implements IRepository<Account> {

	private static List<Account> accounts;
	
	public AccountSeedRepository() {
		if (accounts == null) {
			accounts = new ArrayList<>(Arrays.asList(
				new Account("lydongcanh@gmail.com", "1", false, true) {{ setId(1); }},
				new Account("admin123@gmail.com", "1", true, true) {{ setId(2); }}
			));
		}
	}
	
	@Override
	public List<Account> selectAll() {
		return accounts;
	}

	@Override
	public Account select(Predicate<Account> predicate) {
		try {
			return accounts
				.stream()
				.filter(predicate)
				.findFirst()
				.get();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public int count() {
		return accounts.size();
	}

	@Override
	public boolean add(Account obj) {
		return accounts.add(obj);
	}

	@Override
	public boolean delete(Account obj) {
		return accounts.remove(obj);
	}

	@Override
	public boolean update(Account obj) {
		// TODO: Implements later...
		return false;
	}
}
