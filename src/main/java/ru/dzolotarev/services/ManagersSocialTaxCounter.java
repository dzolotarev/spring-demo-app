package ru.dzolotarev.services;

import ru.dzolotarev.entities.Manager;

import java.util.List;

public class ManagersSocialTaxCounter {
    private final ManagersSalaryCounter managersSalaryCounter;

    public ManagersSocialTaxCounter(ManagersSalaryCounter managersSalaryCounter) {
        this.managersSalaryCounter = managersSalaryCounter;
    }

    // Тут обычно возвращаем DTO
    public String countAndGetManagersTaxes(){
        StringBuilder result = new StringBuilder();
        List<Manager> managersSalary = managersSalaryCounter.increaseManagersSalary();
        for (Manager manager : managersSalary) {
            result.append(manager.getName()).append(" : ").append(manager.getSalary() * 0.1).append("\n");
        }
        return result.toString();
    }
}
