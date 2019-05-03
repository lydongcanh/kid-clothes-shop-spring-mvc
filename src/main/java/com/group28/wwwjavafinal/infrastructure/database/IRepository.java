package com.group28.wwwjavafinal.infrastructure.database;

import java.util.List;

public interface IRepository<T> {
	List<T> selectAll();
	T selectById(int id);
	boolean Add(T obj);
	boolean Delete(T obj);
	boolean Update(T obj);
}
