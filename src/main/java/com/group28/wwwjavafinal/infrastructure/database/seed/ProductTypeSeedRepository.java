package com.group28.wwwjavafinal.infrastructure.database.seed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.group28.wwwjavafinal.entities.ProductType;
import com.group28.wwwjavafinal.infrastructure.database.IRepository;

public class ProductTypeSeedRepository implements IRepository<ProductType> {
	private List<ProductType> seedProductTypes;
	
	public ProductTypeSeedRepository() {
		seedProductTypes = new ArrayList<ProductType>(Arrays.asList( 
			new ProductType("Quần jean", "", "") {{ setId(1); }}	,
			new ProductType("Áo thun", "", "") {{ setId(2); }},
			new ProductType("Váy", "", "") {{ setId(3); }},
			new ProductType("Áo khoác", "", "") {{ setId(4); }}
		));
	}
	
	@Override
	public List<ProductType> selectAll() {
		return seedProductTypes;
	}

	@Override
	public ProductType select(Predicate<ProductType> predicate) {
		return seedProductTypes
			.stream()
			.filter(predicate)
			.findFirst()
			.get();
	}

	@Override
	public boolean add(ProductType obj) {
		return seedProductTypes.add(obj);
	}

	@Override
	public boolean delete(ProductType obj) {
		return seedProductTypes.remove(obj);
	}

	@Override
	public boolean update(ProductType obj) {
		// TODO: Implements this later...
		return false;
	}

	@Override
	public int count() {
		return seedProductTypes.size();
	}
}
