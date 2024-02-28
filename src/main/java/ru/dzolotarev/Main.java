package ru.dzolotarev;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.dzolotarev.config.AppConfig;
import ru.dzolotarev.entities.Manager;
import ru.dzolotarev.repository.ManagerRepository;
import ru.dzolotarev.services.ManagersIncomeTaxSender;
import ru.dzolotarev.services.ManagersSalaryCounter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * Accounting Managers App
 */

public class Main {

    public static void main(String[] args) throws IOException {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ManagersSalaryCounter managersSalaryCounter = context.getBean(ManagersSalaryCounter.class);
        List<Manager> managerList = managersSalaryCounter.increaseManagersSalary();
        for (Manager manager : managerList) {
            System.out.println(manager);
        }

        ManagersIncomeTaxSender managersIncomeTaxSender = context.getBean(ManagersIncomeTaxSender.class);
        managersIncomeTaxSender.sendManagersTaxes();

        ManagerRepository managerRepository = context.getBean(ManagerRepository.class);
        Manager manager = managerRepository.findById(1L);
        System.out.println(manager);

        managerRepository.save(new Manager(12L, "Иванов Иван Иваноович", "Менеджер-бездельник", 300, LocalDate.now(), 12, 31));

        Manager manager1 = managerRepository.findById(12L);
        System.out.println(manager1);
    }
}