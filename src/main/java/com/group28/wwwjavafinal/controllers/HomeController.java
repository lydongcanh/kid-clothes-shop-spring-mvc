package com.group28.wwwjavafinal.controllers;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.group28.wwwjavafinal.entities.Account;
import com.group28.wwwjavafinal.entities.Product;
import com.group28.wwwjavafinal.entities.ProductBrand;
import com.group28.wwwjavafinal.entities.ProductSize;
import com.group28.wwwjavafinal.entities.ProductType;
import com.group28.wwwjavafinal.infrastructure.database.IRepository;
import com.group28.wwwjavafinal.infrastructure.database.jdbc.AccountJdbcRepository;
import com.group28.wwwjavafinal.infrastructure.database.jdbc.ProductBrandJdbcRepository;
import com.group28.wwwjavafinal.infrastructure.database.jdbc.ProductSizeJdbcRepository;
import com.group28.wwwjavafinal.infrastructure.database.jdbc.ProductTypeJdbcRepository;
import com.group28.wwwjavafinal.infrastructure.database.jdbc.ProductsJdbcRepository;
import com.group28.wwwjavafinal.infrastructure.database.jdbc.TestRepository;
import com.group28.wwwjavafinal.infrastructure.database.seed.AccountSeedRepository;
import com.group28.wwwjavafinal.infrastructure.database.seed.ProductBrandSeedRepository;
import com.group28.wwwjavafinal.infrastructure.database.seed.ProductSeedRepository;
import com.group28.wwwjavafinal.infrastructure.database.seed.ProductSizeSeedRepository;
import com.group28.wwwjavafinal.infrastructure.database.seed.ProductTypeSeedRepository;
import com.group28.wwwjavafinal.models.CartDetail;
import com.group28.wwwjavafinal.models.CartModel;
import com.group28.wwwjavafinal.models.HeaderModel;
import com.group28.wwwjavafinal.models.HomeModel;
import com.group28.wwwjavafinal.models.LoginModel;
import com.group28.wwwjavafinal.models.PaginationModel;
import com.group28.wwwjavafinal.services.AccountServices;
import com.group28.wwwjavafinal.services.CartServices;

import junit.framework.Test;

@Controller
public class HomeController {
	
	public static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private static final int PRODUCT_PER_PAGE = 6;
	private static final int CART_DETAIL_PER_PAGE = 10;

	private AccountServices accountServices;
	private CartServices cartServices;
	
	@Autowired
	private TestRepository testRepository;
	
	@Autowired
	private AccountJdbcRepository accountRepository;
	
	@Autowired
	private ProductsJdbcRepository productRepository;
	
	@Autowired
	private ProductBrandJdbcRepository brandRepository;
	
	@Autowired
	private ProductSizeJdbcRepository sizeRepository;
	
	@Autowired
	private ProductTypeJdbcRepository typeRepository;
	
	private int currentBrandId;
	private int currentSizeId;
	private int currentTypeId;
	private int currentPageIndex;
	
	@PostConstruct
	public void initialize() {
/*		productRepository = new ProductSeedRepository();
		brandRepository = new ProductBrandJdbcRepository();
		sizeRepository = new ProductSizeJdbcRepository();
		typeRepository = new ProductTypeJdbcRepository();
		accountRepository = new AccountJdbcRepository();
		testRepository = new TestRepository();*/
		
		accountServices = new AccountServices(accountRepository);
		cartServices = new CartServices();
	}
	
	@RequestMapping(value = "/")
	public String home(HttpSession session, Model model,
		@RequestParam(value = "brandId", defaultValue = "0") int brandId,
		@RequestParam(value = "sizeId", defaultValue = "0") int sizeId,
		@RequestParam(value = "typeId", defaultValue = "0") int typeId,
		@RequestParam(value = "pageIndex", defaultValue = "0") int pageIndex) {
		
		accountServices.setSession(session);
		cartServices.setSession(session);
		
		this.currentBrandId = brandId;
		this.currentSizeId = sizeId;
		this.currentTypeId = typeId;
		this.currentPageIndex = pageIndex;

		HeaderModel headerModel = new HeaderModel(accountServices.isLoggedIn(), cartServices.getCartSize());
		PaginationModel<Product> productListModel = new PaginationModel<>
			(productRepository.selectAll(), PRODUCT_PER_PAGE, pageIndex, productRepository.count());
		HomeModel homeModel = new HomeModel
			(productListModel, headerModel, brandRepository.selectAll(), sizeRepository.selectAll(), typeRepository.selectAll());

		testRepository.test();
		
		model.addAttribute("homeModel", homeModel);
		
		return "home";
	}	
	
	@RequestMapping(value = "/login")
	public String login(HttpSession session, Model model,
			@RequestParam("email") String email, 
			@RequestParam("password") String password) {
		
		accountServices.setSession(session);
		if (accountServices.login(email, password)) {
			return home(session, model, currentBrandId, currentSizeId, currentTypeId, currentPageIndex);
		} else {
			model.addAttribute("loginModel", new LoginModel(email, password, "Email hoặc mật khẩu không đúng!!"));
			return openLoginPage(model);
		}
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session, Model model) {
		accountServices.logout();
		return home(session, model, currentBrandId, currentSizeId, currentTypeId, currentPageIndex);
	}	
	
	@RequestMapping(value = "/register")
	public String register() {
		return "home";
	}

	@RequestMapping(value = "/loginPage")
	public String openLoginPage(Model model) {
		return "loginPage";
	}

	@RequestMapping(value = "/cart")
	public String openCartPage(HttpSession session, Model model) {
		accountServices.setSession(session);
		cartServices.setSession(session);
		
		HeaderModel headerModel = new HeaderModel(accountServices.isLoggedIn(), cartServices.getCartSize());
		PaginationModel<CartDetail> cartDetails = new PaginationModel<>(cartServices.getDetails(), CART_DETAIL_PER_PAGE, 1, 1);
		CartModel cartModel = new CartModel(cartDetails, headerModel);
		model.addAttribute("cartModel", cartModel);
		return "cart";
	}
	
	@RequestMapping(value = "/addProductToCart/{productId}")
	public String addProductToCart(HttpSession session, Model model,
		@PathVariable("productId") int productId) {
		cartServices.setSession(session);
		cartServices.addProduct(productId);
		return openCartPage(session, model);
	}
	
	@RequestMapping(value = "/removeProductFromCart/{productId}")
	public String removeProductFromCart(HttpSession session, Model model,
		@PathVariable("productId") int productId) {
		cartServices.setSession(session);
		cartServices.removeProduct(productId);
		return openCartPage(session, model);
	}
	
}
