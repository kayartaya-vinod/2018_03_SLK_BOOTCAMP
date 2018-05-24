package spring.training.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import spring.training.dao.DaoException;
import spring.training.dao.ProductDao;
import spring.training.entity.Product;
import spring.training.util.HibernateUtil;

public class ProductDaoHibernateImpl implements ProductDao {

	public void add(Product product) throws DaoException {
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			try {
				session.persist(product);
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
				throw e;
			} finally {
				session.close();
				factory.close();
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public Product get(Integer productId) throws DaoException {
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
			return session.get(Product.class, productId);

		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			session.close();
			factory.close();
		}
	}

	public void update(Product product) throws DaoException {
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			try {
				session.merge(product); // session.update(product);
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
				throw e;
			} finally {
				session.close();
				factory.close();
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public void delete(Integer productId) throws DaoException {
		SessionFactory factory = null;
		Session session = null;
		try {
			Product p = get(productId);
			if(p==null) {
				throw new DaoException("Invalid id: " + productId);
			}
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
			session.beginTransaction();
			try {
				session.delete(p);
				session.getTransaction().commit();
			} catch (Exception e) {
				session.getTransaction().rollback();
			}
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			session.close();
			factory.close();
		}
	}

	public Integer getProductCount() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getAll() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getByPrice(Double min, Double max) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getOutOfStockProducts() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getDiscountinuedProducts() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getProductsByCategory(Integer categoryId) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getProductsBySupplier(Integer supplierId) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
