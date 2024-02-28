package ru.dzolotarev.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.dzolotarev.entities.Manager;
import ru.dzolotarev.repository.ManagerRepository;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ManagersSalaryCounter {

    private final ManagerRepository managerRepository;
    private List<Manager> managers;

    public List<Manager> increaseManagersSalary() {
        if (Objects.isNull(managers)) {
            managers = managerRepository.findAll();
            for (Manager manager : managers) {
                manager.setSalary((int) (manager.getSalary() * 1.2));
            }
        }
        return managers;
    }
}
