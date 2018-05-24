package com.slk.training.programs;

import com.slk.training.assignment6.dao.DaoFactory;
import com.slk.training.assignment6.dao.ProductDao;
import com.slk.training.assignment6.entity.Product;
import com.slk.training.dao.DaoException;

public class P26_TestingProductDao {

	public static void main(String[] args) throws DaoException {

		ProductDao dao;

		// tight coupling
		dao = DaoFactory.getProductDao("csv");

		Product p = dao.get(11);
		System.out.println(p);
		p.setProductName(p.getProductName().toUpperCase());
		p.setUnitPrice(p.getUnitPrice() + 5 );
		dao.update(p);
		p = dao.get(11);
		System.out.println(p);

		// List<Product> list = dao.getAll();
		// for (Product p : list) {
		// System.out.println(p);
		// }

	}
}
