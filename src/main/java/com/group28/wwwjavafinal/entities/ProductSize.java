package com.group28.wwwjavafinal.entities;

public class ProductSize extends BaseEntity {
	private String size;
	private float recommendedHeight;
	private float recommendedWeidht;
	
	public ProductSize() {	
	}

	public ProductSize(String size, float recommendedHeight, float recommendedWeidht) {
		this.size = size;
		this.recommendedHeight = recommendedHeight;
		this.recommendedWeidht = recommendedWeidht;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String name) {
		this.size = name;
	}

	public float getRecommendedHeight() {
		return recommendedHeight;
	}

	public void setRecommendedHeight(float recommendedHeight) {
		this.recommendedHeight = recommendedHeight;
	}

	public float getRecommendedWeidht() {
		return recommendedWeidht;
	}

	public void setRecommendedWeidht(float recommendedWeidht) {
		this.recommendedWeidht = recommendedWeidht;
	}
}
