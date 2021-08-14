package com.company.bank.web.screens.banka;

import com.company.bank.entity.Klijent;
import com.company.bank.service.BankaService;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.bank.entity.Banka;

import javax.inject.Inject;
import javax.validation.ValidationException;

@UiController("bank_Banka.edit")
@UiDescriptor("banka-edit.xml")
@EditedEntityContainer("bankaDc")
@LoadDataBeforeShow
public class BankaEdit extends StandardEditor<Banka> {

    @Inject
    private InstanceContainer<Banka> bankaDc;
    @Inject
    private BankaService bankaService;
    @Inject
    private Notifications notifications;
    @Inject
    private ScreenBuilders screenBuilders;

    @Subscribe("commitBtn")
    public void onCommitBtnClick(Button.ClickEvent event) {
        try{
            validirajBanku(bankaDc.getItem());
            provjeriDaLiJeBankaKreirana();
            provjeriPodatkeOBanci(bankaDc.getItem());
            bankaService.kreirajBanku(bankaDc.getItem());

            getScreenData().loadAll();
            screenBuilders.lookup(Klijent.class, this)
                    .withOpenMode(OpenMode.THIS_TAB)
                    .show();
        }catch (ValidationException ve){
            notifications.create().withCaption(ve.getMessage()).show();
        }catch (Exception e){
            notifications.create().withCaption(e.getMessage()).show();
        }
    }

    public void validirajBanku(Banka banka) throws ValidationException{
        if(banka.getSifraBanke() == null || banka.getSifraBanke().isEmpty()){
            throw new ValidationException("Unos sifre je obavezan!");
        }
        if(banka.getSifraBanke().length() != 3){
            throw new ValidationException("Sifra mora imati 3 karaktera!");
        }
        if(banka.getNazivBanke() == null || banka.getNazivBanke().isEmpty()){
            throw new ValidationException("Unos naziva je obavezan!");
        }
        if(banka.getSwiftKod() == null || banka.getSwiftKod().isEmpty()){
            throw new ValidationException("Unos swift koda je obavezan!");
        }
        if(banka.getSwiftKod().length() != 8){
            throw new ValidationException("Swift kod mora imati 8 karaktera!");
        }
        if(banka.getObracunskiRacun() == null || banka.getObracunskiRacun().isEmpty()){
            throw new ValidationException("Unos obracunskog racuna je obavezan!");
        }
        if(banka.getObracunskiRacun().length() != 18){
            throw new ValidationException("Obracunski racun mora imati 8 karaktera!");
        }
    }

    public void provjeriDaLiJeBankaKreirana() throws Exception{
        if(bankaService.provjeriDaLiJeBankaKreirana())
            throw new Exception("U bazi podataka vec postoji jedna banka. Ako zelite da kreirate novu," +
                    "obrisite trenutnu banku.");
    }

    public void provjeriPodatkeOBanci(Banka banka) throws Exception{
        if(bankaService.provjeriJedinstvenostSifreBanke(banka.getSifraBanke()))
            throw new Exception("Sifra je vec bila unesena.");
        if(bankaService.provjeriJedinstvenostSwiftKoda(banka.getSwiftKod()))
            throw new Exception("Swift kod je vec bio unesen.");
        if(bankaService.provjeriJedinstvenostObracunskogRacuna(banka.getObracunskiRacun()))
            throw new Exception("Obracunski racun je vec bio unesen.");
    }
}