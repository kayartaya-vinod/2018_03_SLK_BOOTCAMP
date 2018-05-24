package spring.training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import spring.training.entity.Product;
import spring.training.util.HibernateUtil;

public class P02_UpdateProductPrice {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		try {
			// do your stuff here
			Product p = session.get(Product.class, 12);
			// modifying the data with in a transaction will be updated to the db during commit
			p.setUnitPrice(p.getUnitPrice() + 1);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		
		session.close();
		factory.close();
		System.out.println("Done!");
	}
}
