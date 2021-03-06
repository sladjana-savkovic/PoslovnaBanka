package com.company.bank.service;

import com.company.bank.entity.Banka;
import com.haulmont.cuba.core.global.DataManager;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(BankaService.NAME)
public class BankaServiceBean implements BankaService {

    @Inject
    private DataManager dataManager;

    @Override
    public void kreirajBanku(Banka banka) {
        dataManager.commit(banka);
    }

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