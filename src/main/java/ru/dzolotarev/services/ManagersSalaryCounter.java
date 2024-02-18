package ru.dzolotarev.services;

import org.springframework.stereotype.Component;
import ru.dzolotarev.entities.Manager;
import ru.dzolotarev.repository.ManagerDAO;

import java.util.List;
import java.util.Objects;

@Component
public class ManagersSalaryCounter {

    private final ManagerDAO managerDAO;
    private List<Manager> managers;

    public ManagersSalaryCounter(ManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

    public List<Manager> increaseManagersSalary() {
        if (Objects.isNull(managers)) {
            managers = managerDAO.findAll();
            for (Manager manager : managers) {
                manager.setSalary((int) (manager.getSalary() * 1.2));
            }
        }
        return managers;
    }
}
