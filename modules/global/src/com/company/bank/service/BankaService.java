package com.company.bank.service;

import com.company.bank.entity.Banka;

public interface BankaService {
    String NAME = "bank_BankaService";

    void kreirajBanku(Banka banka);
    boolean provjeriDaLiJeBankaKreirana();
}