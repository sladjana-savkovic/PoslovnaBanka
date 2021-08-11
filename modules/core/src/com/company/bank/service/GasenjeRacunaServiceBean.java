package com.company.bank.service;

import com.company.bank.entity.GasenjeRacuna;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDateTime;

@Service(GasenjeRacunaService.NAME)
public class GasenjeRacunaServiceBean implements GasenjeRacunaService {

    @Inject
    private DataManager dataManager;

    @Override
    public void ugasiRacuna(GasenjeRacuna gasenjeRacuna) {
        gasenjeRacuna.setDatumKreiranja(LocalDateTime.now());
        dataManager.commit(gasenjeRacuna);

        gasenjeRacuna.getRacunZaGasenje().setAktivnost(false);
        dataManager.commit(gasenjeRacuna.getRacunZaGasenje());
    }
}