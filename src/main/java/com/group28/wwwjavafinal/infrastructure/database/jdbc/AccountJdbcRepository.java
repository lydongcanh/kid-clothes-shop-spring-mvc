package com.group28.wwwjavafinal.infrastructure.database.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.group28.wwwjavafinal.entities.Account;

@Repository
public class AccountJdbcRepository extends BaseJdbcRepository<Account> {

	@Override
	protected String getSelectAllQuery() {
		return "select * from Accounts";
	}

	@Override
	protected String getCountQuery() {
		return "select count(*) from Accounts";
	}

	@Override
	protected String getAddQuery(Account obj) {
		return "Insert into Accounts(UserName, Password, IsActivated, IsAdmin) values('"
			+ obj.getUsername() + "', '"
			+ obj.getPassword() + "', "
			+ obj.isActivated() + ", "
			+ obj.isAdmin() + ")";
	}

	@Override
	protected String getDeleteQuery(Account obj) {
		return "Delete from Accounts where AccountId=" + obj.getId();
	}

	@Override
	protected String getUpdateQuery(Account obj) {
		return "Update Accounts set "
			+ "UserName='" + obj.getUsername() + "', "
			+ "Password='" + obj.getPassword() + "', "
			+ "IsActivated=" + (obj.isActivated() ? 1 : 0) + ", "
			+ "IsAdmin=" + (obj.isAdmin() ? 1 : 0)
			+ " where AccountId=" + obj.getId();
	}

	@Override
	protected RowMapper<Account> getRowMapperMapper() {
		return new RowMapper<Account>() {
			
			@Override
			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Account() {{
					setId(rs.getInt(1));
					setUsername(rs.getString(2));
					setPassword(rs.getString(3));
					setActivated(rs.getBoolean(4));
					setAdmin(rs.getBoolean(5));
				}};
			}
		};
	}
}
