package com.example.campaignautomation.config;


import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.*;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = {"com.example.campaignautomation.dao.fuelAsset"},
        entityManagerFactoryRef = "fuelassetEntityManager",
        transactionManagerRef = "fuelassetTransactionManager")
public class FuelAssetDataSource {
	@Autowired
    private Environment env;
    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean fuelassetEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(fuelassetDatasource());
        em.setPackagesToScan(new String[]{"com.example.campaignautomation.model.fuelAsset"});
        em.setPersistenceUnitName("fuelassetEntityManager");
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

    @Primary
    @Bean
    public DataSource fuelassetDatasource() {

        DriverManagerDataSource dataSource
                = new DriverManagerDataSource();
        dataSource.setDriverClassName(
                env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("fuelAsset.datasource.url"));
        dataSource.setUsername(env.getProperty("fuelAsset.datasource.username"));
        dataSource.setPassword(env.getProperty("fuelAsset.datasource.password"));

        return dataSource;
    }

    @Primary
    @Bean
    public PlatformTransactionManager fuelassetTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
        		fuelassetEntityManager().getObject());
        return transactionManager;
    }
}
