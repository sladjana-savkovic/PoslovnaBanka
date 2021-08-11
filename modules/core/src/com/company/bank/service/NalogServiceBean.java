package com.company.bank.service;

import com.company.bank.entity.*;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service(NalogService.NAME)
public class NalogServiceBean implements NalogService {

    @Inject
    private DataManager dataManager;
    @Inject
    private RacunService racunService;
    @Inject
    private DnevnoStanjeService dnevnoStanjeService;

    @Override
    public void kreirajNalog(Nalog nalog) throws Exception {
        nalog.setDatumValute(LocalDateTime.now());
        nalog.setStatusNaloga(StatusNaloga.KREIRAN);
        nalog.setHitno(false);
        dataManager.commit(nalog);

        if(nalog.getVrstaNaloga() == VrstaNaloga.UPLATA)
            izvrsiUplatu(nalog);
    }

    @Override
    public void odbijNalog(Nalog nalog) {
        nalog.setStatusNaloga(StatusNaloga.ODBIJEN);
        dataManager.commit(nalog);
    }

    @Override
    public void obradiNalog(Nalog nalog, DnevnoStanje dnevnoStanje) {
        nalog.setStatusNaloga(StatusNaloga.OBRADJEN);
        nalog.setDnevnoStanje(dnevnoStanje);
        dataManager.commit(nalog);
    }

    @Override
    public void izvrsiUplatu(Nalog nalog) throws Exception {
        if(!racunService.provjeriAktivnostRacuna(nalog.getRacunPoverioca())){
            odbijNalog(nalog);
            throw new Exception("Racun poverioca je ugasen!");
        }
        DnevnoStanje dnevnoStanje = dnevnoStanjeService.kreirajDnevnoStanjePoverica(nalog);
        obradiNalog(nalog, dnevnoStanje);
    }

}