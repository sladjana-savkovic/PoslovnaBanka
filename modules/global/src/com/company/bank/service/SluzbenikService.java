package com.company.bank.service;

import com.company.bank.entity.Sluzbenik;

public interface SluzbenikService {
    String NAME = "bank_SluzbenikService";

    void kreirajSluzbenika(Sluzbenik sluzbenik);
}