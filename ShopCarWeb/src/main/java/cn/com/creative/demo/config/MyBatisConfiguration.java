package cn.com.creative.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db.properties")
public class MyBatisConfiguration implements EnvironmentAware {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    @Override
    public void setEnvironment(Environment env) {
        this.driverClassName = env.getProperty("jdbc.driver");
        this.url =  env.getProperty("jdbc.url");
        this.username = env.getProperty("jdbc.username");
        this.password = env.getProperty("jdbc.password");
    }

    @Bean
    public DataSource createDataSource(){
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }
    @Bean("sqlSessionFactoryBean")
    @Autowired
    public SqlSessionFactoryBean createSqlSessionFactoryBean(DataSource ds){
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(ds);
        factoryBean.setTypeAliasesPackage("cn.com.creative.demo.entity");
        return factoryBean;
    }
    @Bean
    public MapperScannerConfigurer createMapperScannerConfigurer(){
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        configurer.setBasePackage("cn.com.creative.demo.dao.mapper");
        return configurer;
    }
}
