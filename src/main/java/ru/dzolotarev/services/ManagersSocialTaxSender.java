package ru.dzolotarev.services;

public class ManagersSocialTaxSender {
    private final ManagersSocialTaxCounter managersSocialTaxCounter;

    public ManagersSocialTaxSender(ManagersSocialTaxCounter managersSocialTaxCounter) {
        this.managersSocialTaxCounter = managersSocialTaxCounter;
    }

    public void sendManagersSocialTaxes() {
        String supervisorTaxes = managersSocialTaxCounter.countAndGetManagersTaxes();
        System.out.println(supervisorTaxes);
    }
}
