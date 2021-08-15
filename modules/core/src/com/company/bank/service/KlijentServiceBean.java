package com.company.bank.service;

import com.company.bank.entity.Klijent;
import com.haulmont.cuba.core.global.DataManager;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import javax.inject.Inject;

@Service(KlijentService.NAME)
public class KlijentServiceBean implements KlijentService {

    @Inject
    private DataManager dataManager;
    @Inject
    private Logger log;

    @Override
    public void kreirajKlijenta(Klijent klijent) {
        dataManager.commit(klijent);
    }

    @Override
    public boolean provjeriJedinstvenostJmbg(String jmbg) {
        try{
            dataManager.loadValue("select k from bank_Klijent k where " +
                    "k.jmbg = :jmbg ", Klijent.class).parameter("jmbg", jmbg).one();
        }catch (Exception e){
            return false;
        }
        return true;
    }
}