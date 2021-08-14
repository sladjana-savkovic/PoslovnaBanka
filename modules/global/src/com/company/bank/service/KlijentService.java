package com.company.bank.service;

import com.company.bank.entity.Klijent;

public interface KlijentService {
    String NAME = "bank_KlijentService";

    void kreirajKlijenta(Klijent klijent);
}