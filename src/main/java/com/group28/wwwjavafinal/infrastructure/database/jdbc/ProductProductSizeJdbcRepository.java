package com.group28.wwwjavafinal.infrastructure.database.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.group28.wwwjavafinal.entities.ProductProductSize;

public class ProductProductSizeJdbcRepository extends BaseJdbcRepository<ProductProductSize> {

	@Autowired(required = true)
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	protected String getSelectAllQuery() {
		return "Select * from Product_ProductSize";
	}

	@Override
	protected String getCountQuery() {
		return "Select count(*) from Product_ProductSize";
	}

	@Override
	protected String getAddQuery(ProductProductSize obj) {
		 return "Insert into Product_ProductSize(ProductId, ProductSizeId, RemainedInStock) values("
				+ obj.getProductId() + ", "
				+ obj.getProductSizeId() + ", "
				+ obj.getRemainedInStock() + ")";
	}

	@Override
	protected String getDeleteQuery(ProductProductSize obj) {
		return "Delete from Product_ProductSize where Product_ProductSizeId=" + obj.getId();
	}

	@Override
	protected String getUpdateQuery(ProductProductSize obj) {
		return "Update Product_ProductSize set "
				+ "RemainedInStock=" + obj.getRemainedInStock();
	}

	@Override
	protected RowMapper<ProductProductSize> getRowMapperMapper() {
		return new RowMapper<ProductProductSize>() {

			@Override
			public ProductProductSize mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new ProductProductSize() {{
					setId(rs.getInt(1));
					setProductId(rs.getInt(2));
					setProductSizeId(rs.getInt(3));
					setRemainedInStock(rs.getInt(4));
				}};
			}
		};
	}
}
