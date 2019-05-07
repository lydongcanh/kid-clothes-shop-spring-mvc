package com.group28.wwwjavafinal.infrastructure.database.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.group28.wwwjavafinal.entities.Address;
import com.group28.wwwjavafinal.entities.Customer;

public class CustomerJdbcRepository extends BaseJdbcRepository<Customer>{

	@Override
	protected String getSelectAllQuery() {
		return "Select * from Customers";
	}

	@Override
	protected String getCountQuery() {
		return "Select count(*) form Customers";
	}

	@Override
	protected String getAddQuery(Customer obj) {
		return "Insert into Customers(Name, HouseNumber, Street, District, City) values('"
			+ obj.getName() + "', '"
			+ obj.getAddress().getHouseNumber() + "', '"
			+ obj.getAddress().getStreet() + "', '"
			+ obj.getAddress().getDistrict() + "', '"
			+ obj.getAddress().getCity() + "')";
	}

	@Override
	protected String getDeleteQuery(Customer obj) {
		return "Delete from Customers where CustomerId=" + obj.getId();
	}

	@Override
	protected String getUpdateQuery(Customer obj) {
		return "Update Customers set "
			+ "Name=N'" + obj.getName() + "', "
			+ "HouseNumber='" + obj.getAddress().getHouseNumber() + "', " 
			+ "Street=N'" + obj.getAddress().getStreet() + "', "
			+ "District=N'" + obj.getAddress().getDistrict() + "', "
			+ "City=N'" + obj.getAddress().getCity() + "'";
	}

	@Override
	protected RowMapper<Customer> getRowMapperMapper() {
		return new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Address address = new Address() {{
					setHouseNumber(rs.getString(3));
					setStreet(rs.getString(4));
					setDistrict(rs.getString(5));
					setCity(rs.getString(6));
				}};
				
				return new Customer() {{
					setId(rs.getInt(1));
					setName(rs.getString(2));
					setAddress(address);
				}};
			}
		};
	}

}
