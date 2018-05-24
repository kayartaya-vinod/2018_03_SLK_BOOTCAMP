package spring.training.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import spring.training.entity.Product;

public class HibernateUtil {
	static StandardServiceRegistry serviceRegistry;

	public static SessionFactory getSessionFactory() {
		
		Properties props = new Properties();
		props.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		props.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/northwind");
		props.setProperty("hibernate.connection.username", "root");
		props.setProperty("hibernate.connection.password", "root");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.format_sql", "true");

		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(props).build();

		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Product.class);

		return configuration.buildSessionFactory(serviceRegistry);
	}

}
