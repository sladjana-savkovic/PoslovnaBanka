package com.company.bank.service;

import com.company.bank.entity.Klijent;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;
import javax.inject.Inject;

@Service(KlijentService.NAME)
public class KlijentServiceBean implements KlijentService {

    @Inject
    private DataManager dataManager;

    @Override
    public void kreirajKlijenta(Klijent klijent) {
        dataManager.commit(klijent);
    }
}