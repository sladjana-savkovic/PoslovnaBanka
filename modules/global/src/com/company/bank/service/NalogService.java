package com.company.bank.service;

import com.company.bank.entity.Nalog;

public interface NalogService {
    String NAME = "bank_NalogService";

    void kreirajNalog(Nalog nalog);
}