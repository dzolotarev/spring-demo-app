package ru.dzolotarev.services;

import org.springframework.stereotype.Component;

@Component
public class ManagersIncomeTaxSender {

    private final ManagersIncomeTaxCounter managersIncomeTaxCounter;

    public ManagersIncomeTaxSender(ManagersIncomeTaxCounter managersIncomeTaxCounter) {
        this.managersIncomeTaxCounter = managersIncomeTaxCounter;
    }

    public void sendManagersTaxes() {
        String supervisorTaxes = managersIncomeTaxCounter.countAndGetManagersTaxes();
        System.out.println(supervisorTaxes);
    }
}
