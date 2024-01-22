package ru.dzolotarev.services;

import ru.dzolotarev.entities.Manager;

import java.util.List;

public class ManagersIncomeTaxCounter {
    private final ManagersSalaryCounter managersSalaryCounter;

    public ManagersIncomeTaxCounter(ManagersSalaryCounter managersSalaryCounter) {
        this.managersSalaryCounter = managersSalaryCounter;
    }

    // Тут обычно возвращаем DTO
    public String countAndGetManagersTaxes() {
        StringBuilder result = new StringBuilder();
        List<Manager> managersSalary = managersSalaryCounter.increaseManagersSalary();
        for (Manager manager : managersSalary) {
            result.append(manager.getName()).append(" : ").append(manager.getSalary() * 0.25).append("\n");
        }
        return result.toString();
    }
}
