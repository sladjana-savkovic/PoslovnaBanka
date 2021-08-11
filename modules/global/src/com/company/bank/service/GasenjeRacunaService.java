package com.company.bank.service;

import com.company.bank.entity.GasenjeRacuna;

public interface GasenjeRacunaService {
    String NAME = "bank_GasenjeRacunaService";

    void ugasiRacuna(GasenjeRacuna gasenjeRacuna);
}