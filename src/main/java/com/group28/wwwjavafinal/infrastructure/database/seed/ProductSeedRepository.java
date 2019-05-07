package com.group28.wwwjavafinal.infrastructure.database.seed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.group28.wwwjavafinal.entities.Product;
import com.group28.wwwjavafinal.infrastructure.database.IRepository;

public class ProductSeedRepository implements IRepository<Product> {
	private List<Product> seedProducts;
	
	private static final String url1 = "http://lh4.googleusercontent.com/-CBVSjqo5Osk/UbgB-xb5l2I/AAAAAAAAA7Y/xnic44Ns13g/s1600/ao_thun_be_trai_gapkids_viet_nam_xuat_khau_mau_xanh_trang.jpg";
	private static final String url2 = "https://dtpmhvbsmffsz.cloudfront.net/posts/2015/01/01/54a62a174a581e5fa5108f1c/m_54a62a1b4a581e5fa5108f33.jpg";
	
	public ProductSeedRepository() {		
		seedProducts = new ArrayList<Product>(Arrays.asList(  
			new Product("Áo thun 01", "", url1, Product.Gender.Boy, 1, 1){{ setId(1); }},
			new Product("Áo khoác 01", "", url2, Product.Gender.Girl, 2, 4){{ setId(2); }},
			
			new Product("Áo thun 01", "", url1, Product.Gender.Boy, 1, 1){{ setId(3); }},
			new Product("Áo khoác 01", "", url2, Product.Gender.Girl, 2, 4){{ setId(4); }},
			new Product("Áo thun 01", "", url1, Product.Gender.Boy, 1, 1){{ setId(5); }},
			new Product("Áo khoác 01", "", url2, Product.Gender.Girl, 2, 4){{ setId(6); }},
			new Product("Áo thun 01", "", url1, Product.Gender.Boy, 1, 1){{ setId(7); }},
			new Product("Áo khoác 01", "", url2, Product.Gender.Girl, 2, 4){{ setId(8); }},
			new Product("Áo thun 01", "", url1, Product.Gender.Boy, 1, 1){{ setId(9); }},
			new Product("Áo khoác 01", "", url2, Product.Gender.Girl, 2, 4){{ setId(10); }},
			new Product("Áo thun 01", "", url1, Product.Gender.Boy, 1, 1){{ setId(11); }},
			new Product("Áo khoác 01", "", url2, Product.Gender.Girl, 2, 4){{ setId(12); }}
		));
	}
	
	@Override
	public List<Product> selectAll() {
		return seedProducts;
	}

	@Override
	public Product select(Predicate<Product> predicate) {
		return seedProducts
			.stream()
			.filter(predicate)
			.findFirst()
			.get();
	}

	@Override
	public boolean add(Product obj) {
		return seedProducts.add(obj);
	}

	@Override
	public boolean delete(Product obj) {
		return seedProducts.remove(obj);
	}

	@Override
	public boolean update(Product obj) {
		// TODO: Implements this later...
		return false;
	}

	@Override
	public int count() {
		return seedProducts.size();
	}
}
