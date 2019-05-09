package com.group28.wwwjavafinal.infrastructure.database.jdbc;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.group28.wwwjavafinal.infrastructure.database.IRepository;

public abstract class BaseJdbcRepository<T> implements IRepository<T> {

	@Autowired
	protected JdbcTemplate template;
	
	protected abstract String getSelectAllQuery();
	protected abstract String getCountQuery();
	protected abstract String getAddQuery(T obj);
	protected abstract String getDeleteQuery(T obj);
	protected abstract String getUpdateQuery(T obj);
	protected abstract RowMapper<T> getRowMapperMapper();
	
	@Override
	public List<T> selectAll() {
		if (template == null) {		
			return null;
		}
		
		return template.query(getSelectAllQuery(), getRowMapperMapper());
	}

	@Override
	public T select(Predicate<T> predicate) {	
		try {
			return selectAll().stream().filter(predicate).findFirst().get();
		}
		catch (Exception e) {
			return null;
		}
	}

	@Override
	public int count() {
		try {
			return template.queryForObject(getCountQuery(), Integer.class);
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public boolean add(T obj) {
		return template.update(getAddQuery(obj)) == 1;
	}

	@Override
	public boolean delete(T obj) {
		return template.update(getDeleteQuery(obj)) == 1;
	}

	@Override
	public boolean update(T obj) {
		return template.update(getUpdateQuery(obj)) == 1;
	}
}
