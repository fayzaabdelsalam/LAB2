package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.eclipse.persistence.config.PersistenceUnitProperties;


@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.example.demo.*")
@EnableJpaRepositories(basePackages="com.example.demo.repositories")
@EntityScan("com.example.demo.entities")
public class EclipseLinkJpaConfig extends JpaBaseConfiguration {
    protected EclipseLinkJpaConfig(DataSource ds, JpaProperties properties,
                                   ObjectProvider<JtaTransactionManager> jtm,
                                   ObjectProvider<TransactionManagerCustomizers> tmc) {
        super(ds, properties, jtm);
    }

    @Override
    protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
        return new EclipseLinkJpaVendorAdapter();
    }

    @Override
    protected Map<String, Object> getVendorProperties() {
        Map<String, Object> map = new HashMap<>();
        map.put(PersistenceUnitProperties.WEAVING, "false");
        map.put(PersistenceUnitProperties.DDL_GENERATION, "create-or-extend-tables");
        return map;
    }
    
    
}