package ca.horse.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:/resources/horse.properties")
public class DBConfig {
	@Autowired private Environment env;
	
	@Bean
	public HibernateTemplate hibernateTemplate() {
		return new HibernateTemplate(this.getSessionFactory());
	}
	
	@Bean
	public SessionFactory getSessionFactory() {
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(getDataSource());
		bean.setPackagesToScan("ca.horse.core.data");
		bean.setHibernateProperties(getHibernateProperties());
		try {
			bean.afterPropertiesSet();
		}catch(IOException e){
			e.printStackTrace();
		}
		return bean.getObject();
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName(env.getProperty("database.driverClassName"));
		source.setUrl(env.getProperty("database.url"));
		source.setUsername(env.getProperty("database.username"));
		source.setPassword(env.getProperty("database.password"));
		return source;
	}
	
	@Bean
	public HibernateTransactionManager hibernateTransactionManager() {
		return new HibernateTransactionManager(this.getSessionFactory());
	}
	
	private Properties getHibernateProperties() {
		Properties props = new Properties();
		props.put(AvailableSettings.DIALECT, env.getProperty("hibernate.dialect"));
		//props.put("hibernate.id.new_generator_mappings", env.getProperty("hibernate.id.new_generator_mappings"));
		props.put(AvailableSettings.SHOW_SQL, env.getProperty("hibernate.show_sql"));
		props.put(AvailableSettings.FORMAT_SQL, env.getProperty("hibernate.format_sql"));
        return props;  
	}
}
