package config;

import dao.MenuDao;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.MenuService;

@Configuration
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/daelim?characterEncoding=UTF-8&serverTimezone=Asia/Seoul");
        ds.setUsername("spring");
        ds.setPassword("daelimspring");
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        return ds;
    }

    @Bean
    public MenuDao menuDao() {
        return new MenuDao(dataSource());
    }

    @Bean
    public MenuService menuService() {
        return new MenuService(menuDao());
    }
}
