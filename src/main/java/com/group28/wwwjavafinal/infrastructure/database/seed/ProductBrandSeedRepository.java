package com.group28.wwwjavafinal.infrastructure.database.seed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.group28.wwwjavafinal.entities.ProductBrand;
import com.group28.wwwjavafinal.infrastructure.database.IRepository;

public class ProductBrandSeedRepository implements IRepository<ProductBrand> {
	private List<ProductBrand> seedProductBrands;
	
	public ProductBrandSeedRepository() {
		seedProductBrands = new ArrayList<ProductBrand>(Arrays.asList(
			new ProductBrand("Gapkids", "", "") {{ setId(1); }},
			new ProductBrand("Zara Kids", "", "") {{ setId(2); }},
			new ProductBrand("H&M Kids", "", "") {{ setId(3); }},
			new ProductBrand("Jadiny", "", "") {{ setId(4); }},
			new ProductBrand("Kids Plaza", "", "") {{ setId(5); }},
			new ProductBrand("Paul and Paula", "", "") {{ setId(6); }}
		));
	}
	
	@Override
	public List<ProductBrand> selectAll() {
		return seedProductBrands;
	}

	@Override
	public ProductBrand select(Predicate<ProductBrand> predicate) {
		return seedProductBrands
				.stream()
				.filter(predicate)
				.findFirst()
				.get();
	}

	@Override
	public boolean add(ProductBrand obj) {
		return seedProductBrands.add(obj);
	}

	@Override
	public boolean delete(ProductBrand obj) {
		return seedProductBrands.remove(obj);
	}

	@Override
	public boolean update(ProductBrand obj) {
		// TODO: implements this later.
		return false;
	}

	@Override
	public int count() {
		return seedProductBrands.size();
	}
}
