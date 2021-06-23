package com.db.table.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:/application.yml")
public class DBConfiguration {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig(){
        return new HikariConfig();
    }

    @Bean
    @ConfigurationProperties(prefix = "mybatis.configuration")
    public org.apache.ibatis.session.Configuration mybatisConfg(){
        return new org.apache.ibatis.session.Configuration();
    }

    @Bean
    public DataSource dataSource(){
        DataSource dataSource = new HikariDataSource(hikariConfig());
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlFactoryBean = new SqlSessionFactoryBean();
        sqlFactoryBean.setDataSource(dataSource);
        sqlFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/*.xml"));

        sqlFactoryBean.setTypeAliasesPackage("com.db.table.domain");
        sqlFactoryBean.setConfiguration(mybatisConfg());
        return sqlFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
