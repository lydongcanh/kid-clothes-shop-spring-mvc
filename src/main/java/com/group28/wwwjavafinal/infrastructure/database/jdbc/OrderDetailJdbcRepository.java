package com.group28.wwwjavafinal.infrastructure.database.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.jdbc.core.RowMapper;


import com.group28.wwwjavafinal.entities.OrderDetail;

public class OrderDetailJdbcRepository extends BaseJdbcRepository<OrderDetail> {

	@Override
	protected String getSelectAllQuery() {
		return "Select * from OrderDetails";
	}

	@Override
	protected String getCountQuery() {
		
		return "Select Count(*) from OrderDetails";
	}

	@Override
	protected String getAddQuery(OrderDetail obj) {		
		throw new NotImplementedException();
	}

	@Override
	protected String getDeleteQuery(OrderDetail obj) {
		return "Delete * from OrderDetails where OrderDetailId=" + obj.getId();
	}

	@Override
	protected String getUpdateQuery(OrderDetail obj) {
		throw new NotImplementedException();
	}

	@Override
	protected RowMapper<OrderDetail> getRowMapperMapper() {
		return new RowMapper<OrderDetail>() {

			@Override
			public OrderDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new OrderDetail() {{
					setId(rs.getInt(1));
					setProductId(rs.getInt(2));
					setOrderId(rs.getInt(3));
					setQuantity(rs.getInt(4));
				}};
			}
		};
	}
}
