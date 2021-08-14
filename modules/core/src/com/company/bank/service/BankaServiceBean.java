package com.company.bank.service;

import com.company.bank.entity.Banka;
import com.company.bank.entity.Racun;
import com.haulmont.cuba.core.global.DataManager;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(BankaService.NAME)
public class BankaServiceBean implements BankaService {

    @Inject
    private DataManager dataManager;
    @Inject
    private Logger log;

    @Override
    public boolean provjeriDaLiJeBankaKreirana() {
        try{
            dataManager.loadValue("select b from bank_Banka b", Banka.class).one();
        }catch (Exception e){
            return false;
        }
        return true;
    }
}