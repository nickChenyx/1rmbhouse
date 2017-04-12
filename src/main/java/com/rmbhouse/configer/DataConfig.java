package com.rmbhouse.configer;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

/**
 * 1. 先配置一个数据源 dataSource
 * 2. 为 SqlSessionFactory 注入 dataSource 作为参数实例化
 * 3. 不直接使用 SqlSessionFactory 而是使用 Spring 的 SqlSessionTemplate
 * 4. 设置事务管理 DataSourceTransactionManager
 *
 * Created by nickChenyx on 2017/4/11.
 */
@org.springframework.context.annotation.Configuration
@MapperScan(basePackages = "com.rmbhouse.dao")
public class DataConfig {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Bean
    public DataSource dataSource() {
        logger.debug("dataSource()");
        DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:mysql://localhost:3306/rent?useUnicode=true&characterEncoding=utf8",
                "root","chenyuxiong123");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        logger.debug("transactionManager()");
        return new DataSourceTransactionManager(dataSource());
    }

    public SqlSessionFactory sqlSessionFactory() throws Exception {
        logger.debug("sqlSessionFactory()");
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        /**
         * 这里可以设置 mybatis 的配置
         * 设置开启驼峰
         */
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        //configuration.setUseGeneratedKeys(true);
        sessionFactoryBean.setConfiguration(configuration);
        //sessionFactoryBean.setTypeAliasesPackage("com.rmbhouse.entity");
        SqlSessionFactory sqlSessionFactory = sessionFactoryBean.getObject();
        return sqlSessionFactory;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate()throws Exception{

        logger.debug("sqlSessionTemplate()");
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
        return sqlSessionTemplate;
    }

}
