package com.company.bank.service;

import com.company.bank.entity.*;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
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
        else if(nalog.getVrstaNaloga() == VrstaNaloga.ISPLATA)
            izvrsiIsplatu(nalog);
        else
            izvrsiInterniPrenosIliNaplatu(nalog);
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
            throw new Exception("Transakcija odbijena; racun poverioca je ugasen.");
        }
        DnevnoStanje dnevnoStanje = dnevnoStanjeService.kreirajDnevnoStanjePoverica(nalog);
        obradiNalog(nalog, dnevnoStanje);
    }

    @Override
    public void izvrsiIsplatu(Nalog nalog) throws Exception {
        if(!racunService.provjeriAktivnostRacuna(nalog.getRacunDuznika())){
            odbijNalog(nalog);
            throw new Exception("Transakcija odbijena; racun duznika je ugasen.");
        }
        try{
            DnevnoStanje poslednjeDnevnoStanje = dnevnoStanjeService.pronadjiPoslednjeDnevnoStanje(nalog.getRacunDuznika());
            if(poslednjeDnevnoStanje.getNovoStanje() < nalog.getIznos())
                throw new Exception();

            DnevnoStanje dnevnoStanje = dnevnoStanjeService.kreirajDnevnoStanjeDuznika(nalog, poslednjeDnevnoStanje);
            obradiNalog(nalog, dnevnoStanje);
        }catch (Exception e){
            odbijNalog(nalog);
            throw new Exception("Transakcija odbijena; duznik nema dovoljno sredstava na racunu.");
        }
    }

    @Override
    public void izvrsiInterniPrenosIliNaplatu(Nalog nalog) throws Exception {
        if(!racunService.provjeriAktivnostRacuna(nalog.getRacunPoverioca())){
            odbijNalog(nalog);
            throw new Exception("Transakcija odbijena; racun poverioca je ugasen.");
        }
        if(!racunService.provjeriAktivnostRacuna(nalog.getRacunDuznika())){
            odbijNalog(nalog);
            throw new Exception("Transakcija odbijena; racun duznika je ugasen.");
        }
        try{
            DnevnoStanje poslednjeDnevnoStanje = dnevnoStanjeService.pronadjiPoslednjeDnevnoStanje(nalog.getRacunDuznika());
            if(poslednjeDnevnoStanje.getNovoStanje() < nalog.getIznos())
                throw new Exception();

            DnevnoStanje dnevnoStanjeDuznika = dnevnoStanjeService.kreirajDnevnoStanjeDuznika(nalog, poslednjeDnevnoStanje);
            obradiNalog(nalog, dnevnoStanjeDuznika);

            DnevnoStanje dnevnoStanjePoverioca = dnevnoStanjeService.kreirajDnevnoStanjePoverica(nalog);
            kreirajNalogZaPoverioca(nalog, dnevnoStanjePoverioca);
        }catch (Exception e){
            odbijNalog(nalog);
            throw new Exception("Transakcija odbijena; duznik nema dovoljno sredstava na racunu.");
        }
    }

    @Override
    public void kreirajNalogZaPoverioca(Nalog nalog, DnevnoStanje dnevnoStanjePoverioca) {
        Nalog noviNalog = new Nalog();
        noviNalog.setIznos(nalog.getIznos());
        noviNalog.setDuznik(nalog.getDuznik());
        noviNalog.setPoverilac(nalog.getPoverilac());
        noviNalog.setRacunDuznika(nalog.getRacunDuznika());
        noviNalog.setRacunPoverioca(nalog.getRacunPoverioca());
        noviNalog.setHitno(nalog.getHitno());
        noviNalog.setModelZaduzenje(nalog.getModelZaduzenje());
        noviNalog.setPozivNaBrojZaduzenje(nalog.getPozivNaBrojZaduzenje());
        noviNalog.setModelOdobrenje(nalog.getModelOdobrenje());
        noviNalog.setPozivNaBrojOdobrenje(nalog.getPozivNaBrojOdobrenje());
        noviNalog.setSvrhaPlacanja(nalog.getSvrhaPlacanja());
        noviNalog.setDatumPlacanja(nalog.getDatumPlacanja());
        noviNalog.setDatumValute(nalog.getDatumValute());
        noviNalog.setVrstaNaloga(nalog.getVrstaNaloga());
        noviNalog.setSifraPlacanja(nalog.getSifraPlacanja());
        noviNalog.setSifraValute(nalog.getSifraValute());
        noviNalog.setStatusNaloga(StatusNaloga.OBRADJEN);
        noviNalog.setDnevnoStanje(dnevnoStanjePoverioca);
        dataManager.commit(noviNalog);
    }

}