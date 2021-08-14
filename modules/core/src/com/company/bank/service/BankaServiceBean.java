package com.company.bank.service;

import com.company.bank.entity.Banka;
import com.haulmont.cuba.core.global.DataManager;
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

    @Override
    public boolean provjeriJedinstvenostSifreBanke(String sifraBanke) {
        try{
            dataManager.loadValue("select b from bank_Banka b where " +
                    "b.sifraBanke = :sifraBanke ", Banka.class).parameter("sifraBanke", sifraBanke).one();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean provjeriJedinstvenostSwiftKoda(String swiftKod) {
        try{
            dataManager.loadValue("select b from bank_Banka b where " +
                    "b.swiftKod = :swiftKod ", Banka.class).parameter("swiftKod", swiftKod).one();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean provjeriJedinstvenostObracunskogRacuna(String obracunskiRacun) {
        try{
            dataManager.loadValue("select b from bank_Banka b where " +
                    "b.obracunskiRacun = :obracunskiRacun ", Banka.class).parameter("obracunskiRacun", obracunskiRacun).one();
        }catch (Exception e){
            return false;
        }
        return true;
    }


}