package club.ityuchao.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author yuchao
 * @description 直接使用@ConfigurationProperties(prefix="")来配置bean
 * @date 2019/11/26
 */
@Configuration
public class JdbcConfig3 {

    @Bean
    @ConfigurationProperties(prefix = "jdbc")
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }

}
