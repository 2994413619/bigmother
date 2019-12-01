package club.ityuchao.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yuchao
 * @description 使用@ConfigurationProperties进行属性注入
 * @date 2019/11/26
 */
//@ConfigurationProperties(prefix = "jdbc")
public class JdbcProperties {

    private String driverClassName;

    private String url;

    private String username;

    private String password;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
