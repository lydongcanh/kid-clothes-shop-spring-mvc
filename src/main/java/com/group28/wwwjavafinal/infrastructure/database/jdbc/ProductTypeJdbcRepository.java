package com.group28.wwwjavafinal.infrastructure.database.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.group28.wwwjavafinal.entities.ProductType;

public class ProductTypeJdbcRepository extends BaseJdbcRepository<ProductType> {

	@Autowired(required = true)
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	protected String getSelectAllQuery() {
		return "Select * from ProductTypes";
	}

	@Override
	protected String getCountQuery() {
		return "Select count(*) form ProductTypes";
	}

	@Override
	protected String getAddQuery(ProductType obj) {
		return "Insert into ProductTypes(Name, Description, ImageUrl) values(N'"
			+ obj.getName() + "', N'"
			+ obj.getDescription() + "', N'"
			+ obj.getImageUrl() +  "')";
	}

	@Override
	protected String getDeleteQuery(ProductType obj) {
		return "Delete from ProductTypes where ProductTypeId=" + obj.getId();
	}

	@Override
	protected String getUpdateQuery(ProductType obj) {
		return "Update ProductTypes set "
				+ "ProductTypeId=" + obj.getId() + ", '"
				+ "Name=N'" + obj.getName() + "', " 
				+ "Description=N'" + obj.getDescription() + "', "
				+ "ImageUrl=N'" + obj.getImageUrl() + "'";
	}

	@Override
	protected RowMapper<ProductType> getRowMapperMapper() {
		return new RowMapper<ProductType>() {

			@Override
			public ProductType mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new ProductType() {{
					setId(rs.getInt(1));
					setName(rs.getString(2));
					setDescription(rs.getString(3));
					setImageUrl(rs.getString(4));
				}};
			}
		};
	}
}
