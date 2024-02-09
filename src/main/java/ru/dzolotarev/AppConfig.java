package ru.dzolotarev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.dzolotarev.repository.DBConnection;
import ru.dzolotarev.repository.ManagerDAO;

@Configuration
@ComponentScan("ru.dzolotarev.services")
public class AppConfig {

    @Bean
    public DBConnection getDataSource() {
        DBConnection dbConnection = new DBConnection();
        return dbConnection;
    }

    @Bean
    public ManagerDAO getManagerDAO() {
        return new ManagerDAO(getDataSource());
    }
}
