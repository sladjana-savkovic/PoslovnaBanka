package com.company.bank.service;

import com.company.bank.entity.Racun;

public interface RacunService {
    String NAME = "bank_RacunService";

    void kreirajRacun(Racun racun);
    boolean provjeriIspravnostRacuna(String brojRacuna);
}