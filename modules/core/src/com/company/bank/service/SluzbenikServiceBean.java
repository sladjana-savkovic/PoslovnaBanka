package com.company.bank.service;

import com.company.bank.entity.Sluzbenik;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;
import javax.inject.Inject;

@Service(SluzbenikService.NAME)
public class SluzbenikServiceBean implements SluzbenikService {

    @Inject
    private DataManager dataManager;

    @Override
    public void kreirajSluzbenika(Sluzbenik sluzbenik) {
        sluzbenik.setName(sluzbenik.getEmail());
        sluzbenik.setLogin(sluzbenik.getEmail());
        dataManager.commit(sluzbenik);
    }
}