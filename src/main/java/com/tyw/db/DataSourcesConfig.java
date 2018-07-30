package com.tyw.db;
/*
* @Description :
* @Date : 2018/7/24  19:33  
* */

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourcesConfig {
    @Bean(name = "master")
    @Qualifier("primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.master")
    public DataSource primaryDataSource() {
        System.out.println("========primary db built=========");
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "slave")
    @Qualifier("secondaryDataSource")
    @ConfigurationProperties(prefix="spring.datasource.slave")
    public DataSource secondaryDataSource() {
        System.out.println("========slave db built========");
        return DataSourceBuilder.create().build();
    }
}