package com.group28.wwwjavafinal.infrastructure.database.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.group28.wwwjavafinal.entities.ProductSize;

public class ProductSizeJdbcRepository extends BaseJdbcRepository<ProductSize> {

	@Autowired(required = true)
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	protected String getSelectAllQuery() {
		return "Select * from ProductSizes";
	}

	@Override
	protected String getCountQuery() {
		return "Select count(*) from ProductSizes";
	}

	@Override
	protected String getAddQuery(ProductSize obj) {
		return "Insert into ProductSizes(Size, RecommendedHeight, RecommndedWeight) values('"
				+ obj.getSize() + "', "
				+ obj.getRecommendedHeight() + ", "
				+ obj.getRecommendedWeidht() + " )";
	}

	@Override
	protected String getDeleteQuery(ProductSize obj) {
		
		return "Delete from ProductSizes where ProductSizeId=" + obj.getId();
	}

	@Override
	protected String getUpdateQuery(ProductSize obj) {
		return "Update ProductSizes set "
				+ "Size='" + obj.getSize() + "', "
				+ "RecommendedHeight=" + obj.getRecommendedHeight() + ", " 
				+ "RecommndedWeight=" + obj.getRecommendedWeidht();
	}

	@Override
	protected RowMapper<ProductSize> getRowMapperMapper() {
		return new RowMapper<ProductSize>() {

			@Override
			public ProductSize mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new ProductSize() {{
					setId(rs.getInt(1));
					setSize(rs.getString(2));
					setRecommendedHeight(rs.getFloat(3));
					setRecommendedWeidht(rs.getFloat(4));
				}};
			}
		};
	}
}
