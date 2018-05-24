package com.slk.training.assignment6.dao;

import com.slk.training.assignment6.dao.impl.ProductDaoCsvImpl;
import com.slk.training.assignment6.dao.impl.ProductDaoJdbcImpl;
import com.slk.training.dao.DaoException;

public final class DaoFactory {
	private DaoFactory() {
	}
	
	public static ProductDao getProductDao() throws DaoException {
		return getProductDao("jdbc");
	}

	public static ProductDao getProductDao(String type) throws DaoException {
		switch (type.toLowerCase()) {
		case "jdbc":
			return new ProductDaoJdbcImpl();
		case "csv":
			return new ProductDaoCsvImpl();
		default:
			throw new DaoException("Unknown type for ProductDao: " + type);
		}
	}
}
