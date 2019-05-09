package com.group28.wwwjavafinal.infrastructure.database.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.group28.wwwjavafinal.controllers.HomeController;
import com.group28.wwwjavafinal.entities.ProductBrand;

public class ProductBrandJdbcRepository extends BaseJdbcRepository<ProductBrand> {

	@Autowired(required = true)
	public void setTemplate(JdbcTemplate template) {
		HomeController.logger.info("setTemplate:" + (template));
		this.template = template;
	}
	
	@Override
	protected String getSelectAllQuery() {
		return "select * from ProductBrands";
	}

	@Override
	protected String getCountQuery() {		
		return "select count(*) from ProductBrands";
	}

	@Override
	protected String getAddQuery(ProductBrand obj) {
		return "insert into ProductBrands(Name, Description, ImageUrl) values(N'"
				+ obj.getName() + "', N'"
				+ obj.getDescription() +"', N'"
				+ obj.getImageUrl() + "')";
	}

	@Override
	protected String getDeleteQuery(ProductBrand obj) {
		return "Delete * from ProductBrands where ProductBrandId =" + obj.getId();
	}

	@Override
	protected String getUpdateQuery(ProductBrand obj) {
		return "Update ProductBrands set"
				+ "Name=N'" + obj.getName() + "', "
				+ "Description=N'" + obj.getDescription() + "', " 
				+ "ImageUrl=N'" + obj.getImageUrl() +  "'";
	}

	@Override
	protected RowMapper<ProductBrand> getRowMapperMapper() {
		return new RowMapper<ProductBrand>() {

			@Override
			public ProductBrand mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new ProductBrand() {{
					setId(rs.getInt(1));
					setName(rs.getString(2));
					setDescription(rs.getString(3));
					setImageUrl(rs.getString(4));
				}};
			}
		};
	}
}
