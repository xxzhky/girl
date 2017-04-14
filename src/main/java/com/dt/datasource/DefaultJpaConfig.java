package com.dt.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * Created by RID on 2017/4/14.
 *
 * DO NOT HAVE TO CONFIG THIS CLASS IN THE DEFAULT CASE!
 * Also, need to EXchange primary JPA config WITH OTHER SPECIAL CLASS
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryDefault",
        transactionManagerRef="transactionManagerDefault",
        basePackages= { "com.dt.repository" }) //设置Repository所在位置
public class DefaultJpaConfig {

    @Autowired
    @Qualifier("defaultDataSource")
    private DataSource defaultDataSource;

    @Primary
    @Bean(name = "entityManagerDefault")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryDefault(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "entityManagerFactoryDefault")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryDefault (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(defaultDataSource)
                .properties(getVendorProperties(defaultDataSource))
                .packages(new String[]{"com.dt.domain"}) //设置实体类所在位置
                .persistenceUnit("defaultPersistenceUnit")
                .build();
    }

    @Autowired
    private JpaProperties jpaProperties;

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Primary
    @Bean(name = "transactionManagerDefault")
    public PlatformTransactionManager transactionManagerDefault(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryDefault(builder).getObject());
    }

}