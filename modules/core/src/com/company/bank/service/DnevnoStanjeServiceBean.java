package com.company.bank.service;

import com.company.bank.entity.DnevnoStanje;
import com.company.bank.entity.Nalog;
import com.company.bank.entity.Racun;
import com.haulmont.cuba.core.global.DataManager;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import javax.inject.Inject;
import java.util.List;

@Service(DnevnoStanjeService.NAME)
public class DnevnoStanjeServiceBean implements DnevnoStanjeService {

    @Inject
    private DataManager dataManager;
    @Inject
    private Logger log;

    @Override
    public DnevnoStanje kreirajDnevnoStanjePoverica(Nalog nalog) {
        DnevnoStanje poslednjeDnevnoStanje;
        DnevnoStanje novoDnevnoStanje = new DnevnoStanje();

        try {
            //Postoji poslednje dnevno stanje
            poslednjeDnevnoStanje = pronadjiPoslednjeDnevnoStanje(nalog.getRacunPoverioca());

            if(poslednjeDnevnoStanje.getDatumPrometa().equals(nalog.getDatumPlacanja()))
                return promijeniDanasnjeDnevnoStanje(nalog, poslednjeDnevnoStanje);
            else
                return kreirajNovoDnevnoStanje(nalog, poslednjeDnevnoStanje, novoDnevnoStanje);

        }catch (Exception e){
            //Dnevno stanje se kreira prvi put
            Racun racun = dataManager.loadValue("select r from bank_Racun r where " +
                    "r.brojRacuna = :brojRacuna ", Racun.class).parameter("brojRacuna", nalog.getRacunPoverioca()).one();

            return kreirajPrvoDnevnoStanje(nalog, novoDnevnoStanje, racun);
        }
    }

    @Override
    public DnevnoStanje pronadjiPoslednjeDnevnoStanje(String brojRacuna) {
        List<DnevnoStanje> dnevnaStanja = dataManager.loadValue("select d from bank_DnevnoStanje d where " +
                "d.racun.brojRacuna = :racunPoverioca order by d.datumPrometa", DnevnoStanje.class)
                .parameter("racunPoverioca", brojRacuna).list();
        log.info("velicina liste " + String.valueOf(dnevnaStanja.size()));
        return dnevnaStanja.get(dnevnaStanja.size() - 1);
    }

    private DnevnoStanje promijeniDanasnjeDnevnoStanje(Nalog nalog, DnevnoStanje poslednjeDnevnoStanje) {
        poslednjeDnevnoStanje.setPrethodnoStanje(poslednjeDnevnoStanje.getNovoStanje());
        poslednjeDnevnoStanje.setPrometNaTeret(0.0);
        poslednjeDnevnoStanje.setPrometUKorist(nalog.getIznos());
        poslednjeDnevnoStanje.setNovoStanje(poslednjeDnevnoStanje.getPrethodnoStanje() -
                poslednjeDnevnoStanje.getPrometNaTeret() + poslednjeDnevnoStanje.getPrometUKorist());
        return poslednjeDnevnoStanje;
    }

    private DnevnoStanje kreirajNovoDnevnoStanje(Nalog nalog, DnevnoStanje poslednjeDnevnoStanje, DnevnoStanje novoDnevnoStanje) {
        novoDnevnoStanje.setDatumPrometa(nalog.getDatumPlacanja());
        novoDnevnoStanje.setPrethodnoStanje(poslednjeDnevnoStanje.getNovoStanje());
        novoDnevnoStanje.setPrometNaTeret(0.0);
        novoDnevnoStanje.setPrometUKorist(nalog.getIznos());
        novoDnevnoStanje.setRacun(poslednjeDnevnoStanje.getRacun());
        novoDnevnoStanje.setNovoStanje(novoDnevnoStanje.getPrethodnoStanje() -
                novoDnevnoStanje.getPrometNaTeret() + novoDnevnoStanje.getPrometUKorist());
        return novoDnevnoStanje;
    }

    private DnevnoStanje kreirajPrvoDnevnoStanje(Nalog nalog, DnevnoStanje novoDnevnoStanje, Racun racun) {
        novoDnevnoStanje.setDatumPrometa(nalog.getDatumPlacanja());
        novoDnevnoStanje.setPrethodnoStanje(0.0);
        novoDnevnoStanje.setPrometNaTeret(0.0);
        novoDnevnoStanje.setPrometUKorist(nalog.getIznos());
        novoDnevnoStanje.setNovoStanje(novoDnevnoStanje.getPrethodnoStanje() -
                novoDnevnoStanje.getPrometNaTeret() + novoDnevnoStanje.getPrometUKorist());
        novoDnevnoStanje.setRacun(racun);
        return novoDnevnoStanje;
    }
}