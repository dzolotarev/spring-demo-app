package ru.dzolotarev.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagersIncomeTaxSender {

    private final ManagersIncomeTaxCounter managersIncomeTaxCounter;

    public void sendManagersTaxes() {
        String supervisorTaxes = managersIncomeTaxCounter.countAndGetManagersTaxes();
        System.out.println(supervisorTaxes);
    }
}
