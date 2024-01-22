package ru.dzolotarev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.dzolotarev.repository.DBConnection;
import ru.dzolotarev.repository.ManagerDAO;
import ru.dzolotarev.services.*;

@Configuration
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

    @Bean
    public ManagersSalaryCounter getManagersSalaryCounter() {
        return new ManagersSalaryCounter(getManagerDAO());
    }

    @Bean
    public ManagersIncomeTaxCounter getManagersIncomeTaxCounter() {
        return new ManagersIncomeTaxCounter(getManagersSalaryCounter());
    }

    @Bean
    public ManagersIncomeTaxSender getManagersIncomeTaxSender() {
        return new ManagersIncomeTaxSender(getManagersIncomeTaxCounter());
    }

    @Bean
    public ManagersSocialTaxCounter getManagersSocialTaxCounter() {
        return new ManagersSocialTaxCounter(getManagersSalaryCounter());
    }

    @Bean
    public ManagersSocialTaxSender getManagersSocialTaxSender() {
        return new ManagersSocialTaxSender(getManagersSocialTaxCounter());
    }
}
