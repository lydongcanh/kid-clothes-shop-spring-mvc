package com.group28.wwwjavafinal.infrastructure.database.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.group28.wwwjavafinal.entities.Product;

public class ProductsJdbcRepository extends BaseJdbcRepository<Product> {

	@Autowired(required = true)
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	protected String getSelectAllQuery() {
		return "Select * from Products";
	}

	@Override
	protected String getCountQuery() {
		return "Select count(*) from Products";
	}

	@Override
	protected String getAddQuery(Product obj) {
		
		return "insert into Products(Name, Description, ImageUrl, Price, Gender, ProductBrandId, ProductTypeId) values (N'"
				+obj.getName() + "', N'"
				+obj.getDescription() + "', N'"
				+obj.getImageUrl() + "', '"
				+obj.getPrice() + "', '"
				+obj.getGender() + "', '"
				+obj.getBrandId() + "', '"
				+obj.getTypeId() + "')";
	}

	@Override
	protected String getDeleteQuery(Product obj) {
		return "delete * from Products where ProductId=" +obj.getId();
	}

	@Override
	protected String getUpdateQuery(Product obj) {
		return "Update Product set "
				+"Name=N'" +obj.getName() + "',"
				+"Description=N'" +obj.getDescription() +"',"
				+"ImageUrl = N'" +obj.getImageUrl() +"',"
				+"Price=" +obj.getPrice() +","
				+"Gender='" +obj.getGender() +"',";
	}

	@Override
	protected RowMapper<Product> getRowMapperMapper() {
		return new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Product() {{
					setId(rs.getInt(1));
					setName(rs.getString(2));
					setDescription(rs.getString(3));
					setImageUrl(rs.getString(4));
					setPrice(rs.getFloat(5));
					setGender(Gender.parse(rs.getString(6)));
					setBrandId(rs.getInt(7));
					setTypeId(rs.getInt(8));
				}};
			}
		};
	}
}
