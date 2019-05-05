package com.group28.wwwjavafinal.infrastructure.database;

import java.util.List;
import java.util.function.Predicate;

public interface IRepository<T> {
	List<T> selectAll();
	T select(Predicate<T> predicate);
	boolean Add(T obj);
	boolean Delete(T obj);
	boolean Update(T obj);
}
