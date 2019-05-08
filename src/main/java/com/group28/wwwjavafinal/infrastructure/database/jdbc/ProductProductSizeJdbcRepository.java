package com.group28.wwwjavafinal.infrastructure.database.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.group28.wwwjavafinal.entities.ProductProductSize;

public class ProductProductSizeJdbcRepository extends BaseJdbcRepository<ProductProductSize> {

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
		 return "Insert into Product_ProductSize(Product_ProductSizeId, ProductId, ProductSizeId, RemainedInStock) values("
				+ obj.getId() + ", "
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
