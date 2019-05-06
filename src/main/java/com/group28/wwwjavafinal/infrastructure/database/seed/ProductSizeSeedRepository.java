package com.group28.wwwjavafinal.infrastructure.database.seed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.group28.wwwjavafinal.entities.ProductSize;
import com.group28.wwwjavafinal.infrastructure.database.IRepository;

public class ProductSizeSeedRepository implements IRepository<ProductSize> {
	private List<ProductSize> seedProductSizes;
	
	public ProductSizeSeedRepository() {
		seedProductSizes = new ArrayList<ProductSize>(Arrays.asList(
			new ProductSize("XS", 106.5f, 17.5f) {{ setId(1); }},
			new ProductSize("S", 122f, 22f) {{ setId(2); }},
			new ProductSize("M", 129.5f, 27f) {{ setId(3); }},
			new ProductSize("L", 150f, 40f) {{ setId(4); }},
			new ProductSize("XL", 165f, 52.5f) {{ setId(5); }}
		));
	}
	
	@Override
	public List<ProductSize> selectAll() {
		return seedProductSizes;
	}

	@Override
	public ProductSize select(Predicate<ProductSize> predicate) {
		return seedProductSizes
			.stream()
			.filter(predicate)
			.findFirst()
			.get();
	}

	@Override
	public boolean add(ProductSize obj) {
		return seedProductSizes.add(obj);
	}

	@Override
	public boolean delete(ProductSize obj) {
		return seedProductSizes.remove(obj);
	}

	@Override
	public boolean update(ProductSize obj) {
		// TODO: implements this later...
		return false;
	}

	@Override
	public int count() {
		return seedProductSizes.size();
	}
}
