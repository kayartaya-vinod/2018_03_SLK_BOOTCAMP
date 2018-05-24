package spring.training.programs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import spring.training.entity.Product;
import spring.training.util.HibernateUtil;

public class P03_GetProductsByPriceRange {
	
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		String hql = "from Product where unitPrice between :MIN and :MAX";
		// Internally, hibernate creates a PreparedStatement using an SQL
		// corresponding to the HQL given
		Query<Product> qry = session.createQuery(hql, Product.class);
		qry.setParameter("MIN", 50.0);
		qry.setParameter("MAX", 200.0);
		
		List<Product> list = qry.list();
		
		session.close();
		factory.close();
		
		for(Product p: list) {
			System.out.println(p);
		}
	}

}
