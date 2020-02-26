package com.oded.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
	    basePackages = "com.oded", 
	    entityManagerFactoryRef = "addem", 
	    transactionManagerRef = "txadd"
	)
public class AddressConfig {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.two")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name ="txadd")
	public PlatformTransactionManager productTransactionManager() {

		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(db22EntityManager().getObject());
		return transactionManager;
	}

	@Bean(name="addem")
	public LocalContainerEntityManagerFactoryBean db22EntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(primaryDataSource());
		//em.setPersistenceUnitName("db2EntityManager");
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap properties = new HashMap<>();
		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.put("hibernate.show-sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "create");
		em.setJpaPropertyMap(properties);
		em.setPackagesToScan("com.oded");
		//em.setPersistenceUnitName("Address");
		return em;
	}

}
