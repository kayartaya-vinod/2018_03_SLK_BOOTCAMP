package com.slk.training.assignment6.dao;

import java.util.List;

import com.slk.training.assignment6.entity.Product;
import com.slk.training.dao.DaoException;

public interface ProductDao {
	public void add(Product product) throws DaoException;

	public Product get(Integer productId) throws DaoException;

	public void update(Product product) throws DaoException;

	public void delete(Integer productId) throws DaoException;

	public Integer getProductCount() throws DaoException;

	public List<Product> getAll() throws DaoException;

	public List<Product> getByPrice(Double min, Double max) throws DaoException;

	public List<Product> getOutOfStockProducts() throws DaoException;

	public List<Product> getDiscountinuedProducts() throws DaoException;

	public List<Product> getProductsByCategory(Integer categoryId) throws DaoException;

	public List<Product> getProductsBySupplier(Integer supplierId) throws DaoException;
}
