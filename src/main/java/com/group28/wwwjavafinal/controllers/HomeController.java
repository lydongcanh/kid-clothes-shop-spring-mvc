package com.group28.wwwjavafinal.controllers;

import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.group28.wwwjavafinal.entities.Product;
import com.group28.wwwjavafinal.entities.ProductBrand;
import com.group28.wwwjavafinal.entities.ProductSize;
import com.group28.wwwjavafinal.entities.ProductType;
import com.group28.wwwjavafinal.infrastructure.database.IRepository;
import com.group28.wwwjavafinal.infrastructure.database.seed.ProductBrandSeedRepository;
import com.group28.wwwjavafinal.infrastructure.database.seed.ProductSeedRepository;
import com.group28.wwwjavafinal.infrastructure.database.seed.ProductSizeSeedRepository;
import com.group28.wwwjavafinal.infrastructure.database.seed.ProductTypeSeedRepository;
import com.group28.wwwjavafinal.models.ProductListModel;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// TODO: refactor this...
	private static final int PRODUCT_PER_PAGE = 10;
	
	private IRepository<Product> productRepository = new ProductSeedRepository();
	private IRepository<ProductBrand> brandRepository = new ProductBrandSeedRepository();
	private IRepository<ProductSize> sizeRepository = new ProductSizeSeedRepository();
	private IRepository<ProductType> typesRepository = new ProductTypeSeedRepository();
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, 
		@RequestParam(value = "brandId", defaultValue = "0") int brandId,
		@RequestParam(value = "sizeId", defaultValue = "0") int sizeId,
		@RequestParam(value = "typeId", defaultValue = "0") int typeId,
		@RequestParam(value = "pageIndex", defaultValue = "0") int pageIndex) {
		
		ProductListModel productListModel = new ProductListModel(
			productRepository.selectAll(),
			PRODUCT_PER_PAGE,
			pageIndex,
			productRepository.count()
		);
		
		model.addAttribute("productListModel", productListModel);
		return "home";
	}
	
}
