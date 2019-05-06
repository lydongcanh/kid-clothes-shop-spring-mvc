package com.group28.wwwjavafinal.infrastructure.database;

import java.util.List;
import java.util.function.Predicate;

public interface IRepository<T> {
	List<T> selectAll();
	T select(Predicate<T> predicate);
	int count();
	boolean add(T obj);
	boolean delete(T obj);
	boolean update(T obj);
}
