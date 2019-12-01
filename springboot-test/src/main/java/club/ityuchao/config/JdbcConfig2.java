package club.ityuchao.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author yuchao
 * @description 使用@ConfigurationProperties进行属性注入
 * @date 2019/11/26
 */
//@Configuration
//@EnableConfigurationProperties(JdbcProperties.class)
public class JdbcConfig2 {

//    @Bean
//    public DataSource dateSource(JdbcProperties jdbc){
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(jdbc.getDriverClassName());
//        dataSource.setUrl(jdbc.getUrl());
//        dataSource.setUsername(jdbc.getUsername());
//        dataSource.setPassword(jdbc.getPassword());
//        return dataSource;
//    }

}
