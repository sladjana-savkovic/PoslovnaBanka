package com.company.bank.service;

import com.company.bank.entity.DnevnoStanje;
import com.company.bank.entity.Nalog;

public interface DnevnoStanjeService {
    String NAME = "bank_DnevnoStanjeService";

    DnevnoStanje kreirajDnevnoStanjePoverica(Nalog nalog);
    DnevnoStanje kreirajDnevnoStanjeDuznika(Nalog nalog, DnevnoStanje poslednjeDnevnoStanje);
    DnevnoStanje pronadjiPoslednjeDnevnoStanje(String brojRacuna);
}