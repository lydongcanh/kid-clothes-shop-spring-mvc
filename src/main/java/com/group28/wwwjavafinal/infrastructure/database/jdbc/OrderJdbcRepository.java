package com.group28.wwwjavafinal.infrastructure.database.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.group28.wwwjavafinal.entities.Address;
import com.group28.wwwjavafinal.entities.Order;

public class OrderJdbcRepository extends BaseJdbcRepository<Order>{

	@Autowired(required = true)
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	protected String getSelectAllQuery() {
		return "Select * from Orders";
	}

	@Override
	protected String getCountQuery() {
		return "Select Count(*) from Orders";
	}

	@Override
	protected String getAddQuery(Order obj) {
		return "Insert into Orders(HouseNumber, Street, District, City, Status, CustomerId) values('"
				+ obj.getShipAddress().getHouseNumber() +"', N'"
				+ obj.getShipAddress().getStreet() +"', N'"
				+ obj.getShipAddress().getDistrict()+ "', N'"
				+ obj.getShipAddress().getCity() + "', N'"
				+ obj.getStatus() + "',"
				+ obj.getCustomerId() +
				")";
	}

	@Override
	protected String getDeleteQuery(Order obj) {
		
		return "delete from Orders where OrderId =" + obj.getId();
	}

	@Override
	protected String getUpdateQuery(Order obj) {
		
		return "Update Orders set"
				+ "HouseNumber ='" +obj.getShipAddress().getHouseNumber() +  "', N" 
				+ "Street ='" +obj.getShipAddress().getStreet() + "', N"
				+ "District ='" +obj.getShipAddress().getDistrict() + "', N"
				+ "City ='" +obj.getShipAddress().getCity() + "', N"
				+ "Status ='" +obj.getStatus();			
	}

	@Override
	protected RowMapper<Order> getRowMapperMapper() {
		return new RowMapper<Order>() {

			@Override
			public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
				Address address = new Address() {{
					setHouseNumber(rs.getString(2));
					setStreet(rs.getString(3));
					setDistrict(rs.getString(4));
					setCity(rs.getString(5));
				}};
				
				return new Order() {{
					setId(rs.getInt(1));
					setShipAddress(address);
					setStatus(Status.parse(rs.getString(6)));
					setCustomerId(rs.getInt(7));
				}};
			}
		};
	}}