package com.group28.wwwjavafinal.models;

import java.util.List;

public class PaginationModel<T> {
	private List<T> list;
	private int itemsPerPage;
	private int currentPage;
	private int totalItems;

	public PaginationModel(List<T> list, int itemsPerPage, int currentPage, int totalItems) {
		this.list = list;
		this.itemsPerPage = itemsPerPage;
		this.currentPage = currentPage;
		this.totalItems = totalItems;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getItemsPerPage() {
		return itemsPerPage;
	}

	public void setItemsPerPage(int itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	
	public int getTotalPages() {
		return (int)Math.ceil((double)totalItems / itemsPerPage);
	}
}
