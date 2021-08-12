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

            if(poslednjeDnevnoStanje.getDatumPrometa().toLocalDate().equals(nalog.getDatumPlacanja().toLocalDate()))
                return promijeniDanasnjeDnevnoStanjePoverioca(nalog, poslednjeDnevnoStanje);
            else
                return kreirajNovoDnevnoStanjePoverioca(nalog, poslednjeDnevnoStanje, novoDnevnoStanje);

        }catch (Exception e){
            //Dnevno stanje se kreira prvi put
            Racun racun = dataManager.loadValue("select r from bank_Racun r where " +
                    "r.brojRacuna = :brojRacuna ", Racun.class).parameter("brojRacuna", nalog.getRacunPoverioca()).one();

            return kreirajPrvoDnevnoStanjePoverioca(nalog, novoDnevnoStanje, racun);
        }
    }

    @Override
    public DnevnoStanje kreirajDnevnoStanjeDuznika(Nalog nalog, DnevnoStanje poslednjeDnevnoStanje) {
        DnevnoStanje novoDnevnoStanje = new DnevnoStanje();

        if(poslednjeDnevnoStanje.getDatumPrometa().toLocalDate().equals(nalog.getDatumPlacanja().toLocalDate())){
            return promijeniDanasnjeDnevnoStanjeDuznika(nalog, poslednjeDnevnoStanje);
        }else
            return kreirajNovoDnevnoStanjeDuznika(nalog, poslednjeDnevnoStanje, novoDnevnoStanje);
    }

    @Override
    public DnevnoStanje pronadjiPoslednjeDnevnoStanje(String brojRacuna) {
        List<DnevnoStanje> dnevnaStanja = dataManager.loadValue("select d from bank_DnevnoStanje d where " +
                "d.racun.brojRacuna = :racunPoverioca order by d.datumPrometa", DnevnoStanje.class)
                .parameter("racunPoverioca", brojRacuna).list();
        return dnevnaStanja.get(dnevnaStanja.size() - 1);
    }

    private DnevnoStanje promijeniDanasnjeDnevnoStanjePoverioca(Nalog nalog, DnevnoStanje poslednjeDnevnoStanje) {
        DnevnoStanje novoDnevnoStanje = new DnevnoStanje();
        novoDnevnoStanje.setDatumPrometa(nalog.getDatumPlacanja());
        novoDnevnoStanje.setPrethodnoStanje(poslednjeDnevnoStanje.getNovoStanje());
        novoDnevnoStanje.setPrometNaTeret(0.0);
        novoDnevnoStanje.setPrometUKorist(nalog.getIznos());
        novoDnevnoStanje.setRacun(poslednjeDnevnoStanje.getRacun());
        novoDnevnoStanje.setNovoStanje(novoDnevnoStanje.getPrethodnoStanje() -
                novoDnevnoStanje.getPrometNaTeret() + novoDnevnoStanje.getPrometUKorist());

        dataManager.remove(poslednjeDnevnoStanje);
        dataManager.commit(novoDnevnoStanje);
        return novoDnevnoStanje;
    }

    private DnevnoStanje kreirajNovoDnevnoStanjePoverioca(Nalog nalog, DnevnoStanje poslednjeDnevnoStanje, DnevnoStanje novoDnevnoStanje) {
        novoDnevnoStanje.setDatumPrometa(nalog.getDatumPlacanja());
        novoDnevnoStanje.setPrethodnoStanje(poslednjeDnevnoStanje.getNovoStanje());
        novoDnevnoStanje.setPrometNaTeret(0.0);
        novoDnevnoStanje.setPrometUKorist(nalog.getIznos());
        novoDnevnoStanje.setRacun(poslednjeDnevnoStanje.getRacun());
        novoDnevnoStanje.setNovoStanje(novoDnevnoStanje.getPrethodnoStanje() -
                novoDnevnoStanje.getPrometNaTeret() + novoDnevnoStanje.getPrometUKorist());

        dataManager.commit(novoDnevnoStanje);
        return novoDnevnoStanje;
    }

    private DnevnoStanje kreirajPrvoDnevnoStanjePoverioca(Nalog nalog, DnevnoStanje novoDnevnoStanje, Racun racun) {
        novoDnevnoStanje.setDatumPrometa(nalog.getDatumPlacanja());
        novoDnevnoStanje.setPrethodnoStanje(0.0);
        novoDnevnoStanje.setPrometNaTeret(0.0);
        novoDnevnoStanje.setPrometUKorist(nalog.getIznos());
        novoDnevnoStanje.setRacun(racun);
        novoDnevnoStanje.setNovoStanje(novoDnevnoStanje.getPrethodnoStanje() -
                novoDnevnoStanje.getPrometNaTeret() + novoDnevnoStanje.getPrometUKorist());

        dataManager.commit(novoDnevnoStanje);
        return novoDnevnoStanje;
    }

    private DnevnoStanje promijeniDanasnjeDnevnoStanjeDuznika(Nalog nalog, DnevnoStanje poslednjeDnevnoStanje) {
        DnevnoStanje novoDnevnoStanje = new DnevnoStanje();
        novoDnevnoStanje.setDatumPrometa(nalog.getDatumPlacanja());
        novoDnevnoStanje.setPrethodnoStanje(poslednjeDnevnoStanje.getNovoStanje());
        novoDnevnoStanje.setPrometNaTeret(nalog.getIznos());
        novoDnevnoStanje.setPrometUKorist(0.0);
        novoDnevnoStanje.setRacun(poslednjeDnevnoStanje.getRacun());
        novoDnevnoStanje.setNovoStanje(novoDnevnoStanje.getPrethodnoStanje() -
                novoDnevnoStanje.getPrometNaTeret() + novoDnevnoStanje.getPrometUKorist());

        dataManager.remove(poslednjeDnevnoStanje);
        dataManager.commit(novoDnevnoStanje);
        return novoDnevnoStanje;
    }

    private DnevnoStanje kreirajNovoDnevnoStanjeDuznika(Nalog nalog, DnevnoStanje poslednjeDnevnoStanje, DnevnoStanje novoDnevnoStanje) {
        novoDnevnoStanje.setDatumPrometa(nalog.getDatumPlacanja());
        novoDnevnoStanje.setPrethodnoStanje(poslednjeDnevnoStanje.getNovoStanje());
        novoDnevnoStanje.setPrometNaTeret(nalog.getIznos());
        novoDnevnoStanje.setPrometUKorist(0.0);
        novoDnevnoStanje.setRacun(poslednjeDnevnoStanje.getRacun());
        novoDnevnoStanje.setNovoStanje(novoDnevnoStanje.getPrethodnoStanje() -
                novoDnevnoStanje.getPrometNaTeret() + novoDnevnoStanje.getPrometUKorist());

        dataManager.commit(novoDnevnoStanje);
        return novoDnevnoStanje;
    }
}