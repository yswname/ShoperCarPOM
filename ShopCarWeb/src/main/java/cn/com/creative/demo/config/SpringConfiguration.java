package cn.com.creative.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@Import(value={MyBatisConfiguration.class})
@ComponentScan(basePackages = "cn.com.creative.demo.service.impl")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class SpringConfiguration {
    @Bean
    @Autowired
     public DataSourceTransactionManager createDataSourceTransactionManager(DataSource ds){
         DataSourceTransactionManager manager = new DataSourceTransactionManager();
         manager.setDataSource(ds);
         return manager;
     }
}
