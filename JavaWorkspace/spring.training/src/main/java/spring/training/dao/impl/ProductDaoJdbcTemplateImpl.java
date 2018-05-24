package spring.training.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.training.dao.DaoException;
import spring.training.dao.ProductDao;
import spring.training.entity.Product;

public class ProductDaoJdbcTemplateImpl implements ProductDao {
	
	private JdbcTemplate template;
	
	public ProductDaoJdbcTemplateImpl() {
	}

	
	public ProductDaoJdbcTemplateImpl(JdbcTemplate template) {
		this.template = template;
	}

	// writable property called "template" of type "JdbcTemplate"
	// spring can use this for auto or manual wiring
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public void add(Product p) throws DaoException {
		try {
			template.update(
					"insert into products values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
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
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Product get(Integer productId) throws DaoException {
		try {
			String sql = "select * from products where product_id = ?";
			return template.queryForObject(sql, new ProductRowMapper(), productId);
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void update(Product p) throws DaoException {
		try {
			template.update(
					"update products set product_name=?, supplier_id=?, category_id=?,"
					+ "quantity_per_unit=?, unit_price=?, units_in_stock=?,"
					+ "units_on_order=?, reorder_level=?, discontinued=? where "
					+ "product_id = ?",
					p.getProductName(),
					p.getSupplierId(),
					p.getCategoryId(),
					p.getQuantityPerUnit(),
					p.getUnitPrice(),
					p.getUnitsInStock(),
					p.getUnitsOnOrder(),
					p.getReorderLevel(),
					p.getDiscontinued(),
					p.getProductId());
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}

	}

	@Override
	public void delete(Integer productId) throws DaoException {
		try {
			String sql = "delete from products where product_id = ?";
			int count = template.update(sql, productId);
			if(count==0) {
				throw new DaoException("Invalid product id supplied: " + productId);
			}
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Integer getProductCount() throws DaoException {
		try {
			String sql = "select count(*) from products";
			return template.queryForObject(sql, Integer.class);
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Product> getAll() throws DaoException {
		try {
			String sql = "select * from products";
			return template.query(sql, new ProductRowMapper());
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Product> getByPrice(Double min, Double max) throws DaoException {
		try {
			String sql = "select * from products where unit_price between ? and ? order by unit_price";
			return template.query(sql, new ProductRowMapper(), min, max);
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Product> getOutOfStockProducts() throws DaoException {
		try {
			String sql = "select * from products where units_in_stock=0";
			return template.query(sql, new ProductRowMapper());
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Product> getDiscountinuedProducts() throws DaoException {
		try {
			String sql = "select * from products where discontinued=1";
			return template.query(sql, new ProductRowMapper());
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Product> getProductsByCategory(Integer categoryId) throws DaoException {
		try {
			String sql = "select * from products where category_id = ?";
			return template.query(sql, new ProductRowMapper(), categoryId);
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Product> getProductsBySupplier(Integer supplierId) throws DaoException {
		try {
			String sql = "select * from products where supplier_id = ?";
			return template.query(sql, new ProductRowMapper(), supplierId);
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}
	
	class ProductRowMapper implements RowMapper<Product> {
		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
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
	}
}
