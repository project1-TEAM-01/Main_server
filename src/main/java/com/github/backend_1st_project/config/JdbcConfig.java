package com.github.backend_1st_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {

    @Bean
    @Primary
    public DataSource dataSource1(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("12341234");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/backend1st?useUnicode=true&characterEncoding=UTF-8");
        return dataSource;
    }


    @Bean
    public JdbcTemplate jdbcTemplate(){return new JdbcTemplate(dataSource1());}



    @Bean(name = "tm")
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource1());
    }
}