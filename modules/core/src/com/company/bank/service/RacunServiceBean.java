package com.company.bank.service;

import com.company.bank.entity.Banka;
import com.company.bank.entity.Racun;
import com.haulmont.cuba.core.global.DataManager;
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

    @Override
    public boolean provjeriIspravnostRacuna(String brojRacuna) {
        try {
            dataManager.loadValue("select r from bank_Racun r where " +
                    "r.brojRacuna = :brojRacuna ", Racun.class).parameter("brojRacuna", brojRacuna).one();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean provjeriAktivnostRacuna(String brojRacuna) {
        Racun racun = dataManager.loadValue("select r from bank_Racun r where " +
                "r.brojRacuna = :brojRacuna ", Racun.class).parameter("brojRacuna", brojRacuna).one();
        return racun.getAktivnost();
    }

}