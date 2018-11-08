package com.example.campaignautomation.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
@EnableJpaRepositories(basePackages = {"com.example.campaignautomation.dao.voyager"},
						entityManagerFactoryRef = "voyagerEntityManager",
						transactionManagerRef = "voyagerTransactionManager")
public class VoyagerDataSource {
	@Autowired
    private Environment env;
    @Bean
    public LocalContainerEntityManagerFactoryBean voyagerEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(voyagerDatasource());
        em.setPackagesToScan(new String[]{"com.example.campaignautomation.model.voyager"});
        em.setPersistenceUnitName("voyagerEntityManager");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap properties = new HashMap<>();
        properties.put("hibernate.dialect",
                env.getProperty("spring.hibernate.dialect"));
        properties.put("hibernate.show-sql",
                env.getProperty("spring.show-sql"));
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean
    public DataSource voyagerDatasource() {

        DriverManagerDataSource dataSource
                = new DriverManagerDataSource();
        dataSource.setDriverClassName(
                env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("voyager.datasource.url"));
        dataSource.setUsername(env.getProperty("voyager.datasource.username"));
        dataSource.setPassword(env.getProperty("voyager.datasource.password"));

        return dataSource;
    }

    @Primary
    @Bean
    public PlatformTransactionManager voyagerTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
        		voyagerEntityManager().getObject());
        return transactionManager;
    }
}
