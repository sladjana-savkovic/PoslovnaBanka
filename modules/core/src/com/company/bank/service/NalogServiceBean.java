package com.company.bank.service;

import com.company.bank.entity.Nalog;
import com.company.bank.entity.StatusNaloga;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDate;

@Service(NalogService.NAME)
public class NalogServiceBean implements NalogService {

    @Inject
    private DataManager dataManager;

    @Override
    public void kreirajNalog(Nalog nalog) {
        nalog.setDatumValute(LocalDate.now());
        nalog.setStatusNaloga(StatusNaloga.KREIRAN);
        nalog.setHitno(false);
        dataManager.commit(nalog);
    }
}