package com.slk.training.assignment6.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.slk.training.assignment6.dao.ProductDao;
import com.slk.training.assignment6.entity.Product;
import com.slk.training.dao.DaoException;
import com.slk.training.util.DbUtil;

public class ProductDaoJdbcImpl implements ProductDao {

	@Override
	public void add(Product product) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Product get(Integer productId) throws DaoException {
		if(productId==null) { 
			throw new DaoException("Product Id is null");
		}
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from products where product_id = ?";
			conn = DbUtil.getConnection("northwind");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, productId);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return resultSetToProduct(rs);
			}
			
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			DbUtil.releaseResources(conn, stmt, rs);
		}
		return null;
	}

	private Product resultSetToProduct(ResultSet rs) throws SQLException {
		Product p = new Product();
		p.setProductId(rs.getInt("product_id"));
		p.setProductName(rs.getString("product_name"));
		p.setSupplierId(rs.getInt("supplier_id"));
		p.setCategoryId(rs.getInt("category_id"));
		p.setUnitPrice(rs.getDouble("unit_price"));
		p.setQuantityPerUnit(rs.getString("quantity_per_unit"));
		p.setUnitsInStock(rs.getInt("units_in_stock"));
		p.setUnitsOnOrder(rs.getInt("units_on_order"));
		p.setReorderLevel(rs.getInt("reorder_level"));
		p.setDiscontinued(rs.getInt("discontinued"));
		return p;
	}

	@Override
	public void update(Product product) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer productId) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer getProductCount() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAll() throws DaoException {
		List<Product> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from products";
			conn = DbUtil.getConnection("northwind");
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(resultSetToProduct(rs));
			}
			
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			DbUtil.releaseResources(conn, stmt, rs);
		}
		return list;
	}

	@Override
	public List<Product> getByPrice(Double min, Double max) throws DaoException {
		List<Product> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from products where unit_price between ? and ?";
			conn = DbUtil.getConnection("northwind");
			stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, min);
			stmt.setDouble(2, max);
			rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(resultSetToProduct(rs));
			}
			
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			DbUtil.releaseResources(conn, stmt, rs);
		}
		return list;
	}

	@Override
	public List<Product> getOutOfStockProducts() throws DaoException {
		List<Product> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from products where units_in_stock=0";
			conn = DbUtil.getConnection("northwind");
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(resultSetToProduct(rs));
			}
			
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			DbUtil.releaseResources(conn, stmt, rs);
		}
		return list;
	}

	@Override
	public List<Product> getDiscountinuedProducts() throws DaoException {
		List<Product> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from products where discontinued=1";
			conn = DbUtil.getConnection("northwind");
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(resultSetToProduct(rs));
			}
			
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			DbUtil.releaseResources(conn, stmt, rs);
		}
		return list;
	}

	@Override
	public List<Product> getProductsByCategory(Integer categoryId) throws DaoException {
		List<Product> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from products where category_id = ?";
			conn = DbUtil.getConnection("northwind");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, categoryId);
			rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(resultSetToProduct(rs));
			}
			
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			DbUtil.releaseResources(conn, stmt, rs);
		}
		return list;
	}

	@Override
	public List<Product> getProductsBySupplier(Integer supplierId) throws DaoException {
		List<Product> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from products where supplier_id = ?";
			conn = DbUtil.getConnection("northwind");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, supplierId);
			rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(resultSetToProduct(rs));
			}
			
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			DbUtil.releaseResources(conn, stmt, rs);
		}
		return list;
	}

}
