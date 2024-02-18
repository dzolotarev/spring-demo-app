package ru.dzolotarev;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
import ru.dzolotarev.entities.Manager;
import ru.dzolotarev.services.ManagersIncomeTaxSender;
import ru.dzolotarev.services.ManagersSalaryCounter;
import ru.dzolotarev.services.ManagersSocialTaxSender;
import ru.dzolotarev.services.ResourceService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

/**
 * Accounting Managers App
 */

public class Main {

    public static void main(String[] args) throws IOException {
        // 1. Место создания по new
        // 2. Контроль жизненного цикла наших объектов
        // 3. Контроль единственности объектов

        //Можно поити паттерном Декоратор и фабричными методами, но есть Spring!
        //Spring поможет. У него есть: Application Context, Dependency Injection, Inversion of Control

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ManagersSalaryCounter managersSalaryCounter = context.getBean(ManagersSalaryCounter.class);
        List<Manager> managerList = managersSalaryCounter.increaseManagersSalary();
        for (Manager manager : managerList) {
            System.out.println(manager);
        }

        ManagersIncomeTaxSender managersIncomeTaxSender = context.getBean(ManagersIncomeTaxSender.class);
        managersIncomeTaxSender.sendManagersTaxes();

        ManagersSocialTaxSender managersSocialTaxSender = context.getBean(ManagersSocialTaxSender.class);
        managersSocialTaxSender.sendManagersSocialTaxes();
// ==================================================================================
        ResourceService bean = context.getBean(ResourceService.class);
        Resource resource = bean.loadResources();
        File file = resource.getFile();
        String text = new String(Files.readAllBytes(file.toPath()));
        System.out.println(text);
    }
}