package spring.training.programs;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.training.cfg.AppConfig3;
import spring.training.dao.ProductDao;
import spring.training.entity.Product;

public class P07_ProductDaoJdbcTemplateImplDemo {

	public static void main(String[] args) throws Exception {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig3.class);

		ProductDao dao = ctx.getBean(ProductDao.class);
		Product p = dao.get(11);
		System.out.println(p);
		double newPrice = p.getUnitPrice() + 10;
		p.setUnitPrice(newPrice);
		dao.update(p);
		System.out.println(p);
		
		System.out.println();
		
		List<Product> list = dao.getByPrice(50.0, 200.0);
		for(Product p1: list) {
			System.out.println(p1);
		}

		ctx.close();

	}
}
