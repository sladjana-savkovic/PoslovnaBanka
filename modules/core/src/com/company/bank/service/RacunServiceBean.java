package com.company.bank.service;

import com.company.bank.entity.Banka;
import com.company.bank.entity.Racun;
import com.haulmont.cuba.core.global.DataManager;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.Random;

@Service(RacunService.NAME)
public class RacunServiceBean implements RacunService {

    @Inject
    private DataManager dataManager;

    @Override
    public void kreirajRacun(Racun racun) {
        Random random = new Random();
        Banka banka = dataManager.loadValue("select b from bank_Banka b", Banka.class).one();
        String brojRacuna = banka.getSifraBanke() + random.nextInt(10) + random.nextInt(10) + random.nextInt(10)
                + random.nextInt(10) + random.nextInt(10)+ random.nextInt(10)+ random.nextInt(10)
                + random.nextInt(10) + random.nextInt(10) + random.nextInt(10) + random.nextInt(10)
                + random.nextInt(10) + random.nextInt(10) + random.nextInt(10) + random.nextInt(10);

        racun.setBanka(banka);
        racun.setAktivnost(true);
        racun.setDatumOtvaranja(LocalDateTime.now());
        racun.setBrojRacuna(brojRacuna);
        
        dataManager.commit(racun);
    }
}