package spring.training.cfg;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import spring.training.dao.ProductDao;
import spring.training.dao.impl.ProductDaoJdbcTemplateImpl;

@Configuration
public class AppConfig3 {

	@Bean(autowire = Autowire.BY_TYPE)
	public ProductDao dao() {
		return new ProductDaoJdbcTemplateImpl();
	}

	@Bean(autowire = Autowire.BY_NAME)
	public JdbcTemplate jt() {
		return new JdbcTemplate();
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl("jdbc:mysql://localhost/northwind");
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		return ds;
	}
}
