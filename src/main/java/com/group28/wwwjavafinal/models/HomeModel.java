package com.group28.wwwjavafinal.models;

import java.util.List;

import com.group28.wwwjavafinal.entities.Product;
import com.group28.wwwjavafinal.entities.ProductBrand;
import com.group28.wwwjavafinal.entities.ProductSize;
import com.group28.wwwjavafinal.entities.ProductType;

public class HomeModel {
	private PaginationModel<Product> productList;
	private HeaderModel headerModel;
	private List<ProductBrand> brands;
	private List<ProductSize> sizes;
	private List<ProductType> types;

	public HomeModel(PaginationModel<Product> productList, HeaderModel headerModel, List<ProductBrand> brands,
			List<ProductSize> sizes, List<ProductType> types) {
		this.productList = productList;
		this.headerModel = headerModel;
		this.brands = brands;
		this.sizes = sizes;
		this.types = types;
	}

	public PaginationModel<Product> getProductList() {
		return productList;
	}

	public void setProductList(PaginationModel<Product> productList) {
		this.productList = productList;
	}

	public HeaderModel getHeaderModel() {
		return headerModel;
	}

	public void setHeaderModel(HeaderModel headerModel) {
		this.headerModel = headerModel;
	}

	public List<ProductBrand> getBrands() {
		return brands;
	}

	public void setBrands(List<ProductBrand> brands) {
		this.brands = brands;
	}

	public List<ProductSize> getSizes() {
		return sizes;
	}

	public void setSizes(List<ProductSize> sizes) {
		this.sizes = sizes;
	}

	public List<ProductType> getTypes() {
		return types;
	}

	public void setTypes(List<ProductType> types) {
		this.types = types;
	}
}
