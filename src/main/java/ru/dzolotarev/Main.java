package ru.dzolotarev;

import ru.dzolotarev.repository.DBConnection;
import ru.dzolotarev.repository.ManagerDAO;
import ru.dzolotarev.services.*;

/**
 * Accounting Managers App
 */

public class Main {
    public static void main(String[] args) {
        //Get All managers
//        DBConnection dbConnection = new DBConnection();
//        ManagerDAO managerDAO = new ManagerDAO(dbConnection);
//        List<Manager> allManagers = managerDAO.findAll();
//        for (Manager manager : allManagers) {
//            System.out.println(manager);
//        }
        // --------------------------------------------------------
//        ManagersIncomeTaxSender taxSender =
//                new ManagersIncomeTaxSender(
//                        new ManagersIncomeTaxCounter(
//                                new ManagersSalaryCounter(
//                                        new ManagerDAO(
//                                                new DBConnection()))));
        DBConnection dbConnection = new DBConnection();
        ManagerDAO managerDAO = new ManagerDAO(dbConnection);
        ManagersSalaryCounter managersSalaryCounter = new ManagersSalaryCounter(managerDAO);

        ManagersIncomeTaxCounter managersIncomeTaxCounter = new ManagersIncomeTaxCounter(managersSalaryCounter);
        ManagersIncomeTaxSender taxSender = new ManagersIncomeTaxSender(managersIncomeTaxCounter);
        taxSender.sendManagersTaxes();

        ManagersSocialTaxCounter managersSocialTaxCounter = new ManagersSocialTaxCounter(managersSalaryCounter);
        ManagersSocialTaxSender managersSocialTaxSender = new ManagersSocialTaxSender(managersSocialTaxCounter);
        managersSocialTaxSender.sendManagersSocialTaxes();
        // 1. Место создания по new
        // 2. Контроль жизненного цикла наших объектов
        // 3. Контроль единственности объектов

        //Можно поити паттерном Декоратор и фабричными методами, но есть Spring!
        //Spring поможет. У него есть: Application Context, Dependency Injection, Inversion of Control

    }
}