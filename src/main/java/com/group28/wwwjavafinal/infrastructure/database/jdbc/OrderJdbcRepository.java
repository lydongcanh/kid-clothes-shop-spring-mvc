package com.group28.wwwjavafinal.infrastructure.database.jdbc;

import org.springframework.jdbc.core.RowMapper;

import com.group28.wwwjavafinal.entities.Order;

public class OrderJdbcRepository extends BaseJdbcRepository<Order> {

	@Override
	protected String getSelectAllQuery() {
		return "Select * from Orders";
	}

	@Override
	protected String getCountQuery() {
		return "Select count(*) from Orders";
	}

	@Override
	protected String getAddQuery(Order obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getDeleteQuery(Order obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getUpdateQuery(Order obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected RowMapper<Order> getRowMapperMapper() {
		// TODO Auto-generated method stub
		return null;
	}

}
