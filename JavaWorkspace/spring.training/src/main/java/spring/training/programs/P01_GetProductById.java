package spring.training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import spring.training.entity.Product;
import spring.training.util.HibernateUtil;

public class P01_GetProductById {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		// session provides CRUD operations based on primary key
		Session session = factory.openSession();
		Integer id = 12;
		Product p1 = session.get(Product.class, id);
		session.close();
		factory.close();
		
		System.out.println(p1);
	}
}
