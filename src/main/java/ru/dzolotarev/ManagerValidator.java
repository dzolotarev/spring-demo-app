package ru.dzolotarev;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.dzolotarev.entities.Manager;

/**
 * Created by Denis Zolotarev on 09.02.2024
 */
public class ManagerValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Manager.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "login", "Empty login!");
        Manager manager = (Manager) target;

        if (manager.getSalary() < 0) {
            errors.rejectValue("salary", "Salary: negative value!");
        } else if (manager.getSalary() > 150_000) {
            errors.rejectValue("salary", "Salary: value is to big!");
        }
    }
}
