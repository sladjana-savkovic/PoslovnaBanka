package com.company.bank.service;

import com.company.bank.entity.DnevnoStanje;
import com.company.bank.entity.Nalog;

public interface NalogService {
    String NAME = "bank_NalogService";

    void kreirajNalog(Nalog nalog) throws Exception;
    void odbijNalog(Nalog nalog);
    void obradiNalog(Nalog nalog, DnevnoStanje dnevnoStanje);
    void izvrsiUplatu(Nalog nalog) throws Exception;
    void izvrsiIsplatu(Nalog nalog) throws Exception;
    void izvrsiInterniPrenosIliNaplatu(Nalog nalog) throws Exception;
    void kreirajNalogZaPoverioca(Nalog nalog, DnevnoStanje dnevnoStanjePoverioca);
}