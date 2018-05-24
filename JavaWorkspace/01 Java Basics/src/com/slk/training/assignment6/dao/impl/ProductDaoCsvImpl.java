package com.slk.training.assignment6.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.slk.training.assignment6.dao.ProductDao;
import com.slk.training.assignment6.entity.Product;
import com.slk.training.dao.DaoException;

public class ProductDaoCsvImpl implements ProductDao {

	static final String filename = "products.csv";

	@Override
	public void add(Product product) throws DaoException {
		throw new DaoException("Method not implemented yet!");
	}

	@Override
	public Product get(Integer productId) throws DaoException {
		FileReader file = null;
		BufferedReader in = null;

		try {

			file = new FileReader(filename);
			in = new BufferedReader(file);
			String line;

			in.readLine(); // skip coulmn headings

			while ((line = in.readLine()) != null) {
				Product p = csvToProduct(line);
				if (p.getProductId() == productId) {
					return p;
				}
			}
			return null;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (file != null) {
					file.close();
				}
			} catch (Exception e2) {
				throw new DaoException(e2);
			}
		}
	}

	private Product csvToProduct(String line) throws DaoException {
		try {
			Product p = new Product();
			String[] data = line.split(",");
			data = removeQuotes(data);

			p.setProductId(Integer.parseInt(data[0]));
			p.setProductName(data[1]);
			p.setSupplierId(data[2].equals("NULL") ? null : Integer.parseInt(data[2]));
			p.setCategoryId(data[3].equals("NULL") ? null : Integer.parseInt(data[3]));
			p.setQuantityPerUnit(data[4]);
			p.setUnitPrice(data[5].equals("NULL") ? null : Double.parseDouble(data[5]));
			p.setUnitsInStock(data[6].equals("NULL") ? null : Integer.parseInt(data[6]));
			p.setUnitsOnOrder(data[7].equals("NULL") ? null : Integer.parseInt(data[7]));
			p.setReorderLevel(data[8].equals("NULL") ? null : Integer.parseInt(data[8]));
			p.setDiscontinued(data[9].equals("NULL") ? null : Integer.parseInt(data[9]));
			return p;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	private String[] removeQuotes(String[] data) {
		String[] newData = new String[data.length];
		for (int i = 0; i < data.length; i++) {
			String d = data[i].trim();
			newData[i] = d.replaceAll("\"", "");
		}
		return newData;
	}

	@Override
	public void update(Product product) throws DaoException {
		try {
			Map<Integer, Product> productsMap = getProductsMap();
			Product p = productsMap.get(product.getProductId());
			if(p==null) {
				throw new DaoException("Product not found for id " + product.getProductId());
			}
			productsMap.put(product.getProductId(), product);
			writeProductsToCsv(productsMap);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	void writeProductsToCsv(Map<Integer, Product> productsMap) throws DaoException {
		try {
			FileWriter file = new FileWriter("products.csv");
			
			for(Product p: productsMap.values()) {
				String csv = productToCsv(p);
				file.write(csv);
			}
			file.close();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	String productToCsv(Product p) {
		return String.format("\"%d\",\"%s\",\"%d\",\"%d\",\"%s\",\"%f\",\"%d\",\"%d\",\"%d\",\"%d\"\n", 
				p.getProductId(),
				p.getProductName(),
				p.getSupplierId(),
				p.getCategoryId(),
				p.getQuantityPerUnit(),
				p.getUnitPrice(),
				p.getUnitsInStock(),
				p.getUnitsOnOrder(),
				p.getReorderLevel(),
				p.getDiscontinued());
	}

	Map<Integer, Product> getProductsMap() throws DaoException {
		try {
			Map<Integer, Product> map = new HashMap<>();
			FileReader file = new FileReader("products.csv");
			BufferedReader in = new BufferedReader(file);
			String line;
			in.readLine(); // skip the first line
			while((line=in.readLine())!=null) {
				Product p = csvToProduct(line);
				map.put(p.getProductId(), p);
			}
			in.close();
			file.close();
			return map;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void delete(Integer productId) throws DaoException {
		throw new DaoException("Method not implemented yet!");
	}

	@Override
	public Integer getProductCount() throws DaoException {
		throw new DaoException("Method not implemented yet!");
	}

	@Override
	public List<Product> getAll() throws DaoException {
		FileReader file = null;
		BufferedReader in = null;
		List<Product> list = new ArrayList<>();
		try {

			file = new FileReader(filename);
			in = new BufferedReader(file);
			String line;

			in.readLine(); // skip coulmn headings

			while ((line = in.readLine()) != null) {
				Product p = csvToProduct(line);
				list.add(p);
			}
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (file != null) {
					file.close();
				}
			} catch (Exception e2) {
				throw new DaoException(e2);
			}
		}
		return list;
	}

	@Override
	public List<Product> getByPrice(Double min, Double max) throws DaoException {
		throw new DaoException("Method not implemented yet!");
	}

	@Override
	public List<Product> getOutOfStockProducts() throws DaoException {
		throw new DaoException("Method not implemented yet!");
	}

	@Override
	public List<Product> getDiscountinuedProducts() throws DaoException {
		throw new DaoException("Method not implemented yet!");
	}

	@Override
	public List<Product> getProductsByCategory(Integer categoryId) throws DaoException {
		throw new DaoException("Method not implemented yet!");
	}

	@Override
	public List<Product> getProductsBySupplier(Integer supplierId) throws DaoException {
		throw new DaoException("Method not implemented yet!");
	}

}
