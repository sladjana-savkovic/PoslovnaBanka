package com.company.bank.web.screens.klijent;

import com.company.bank.entity.VrstaKlijenta;
import com.company.bank.service.KlijentService;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.bank.entity.Klijent;
import javax.inject.Inject;
import javax.validation.ValidationException;

@UiController("bank_Klijent.edit")
@UiDescriptor("klijent-edit.xml")
@EditedEntityContainer("klijentDc")
@LoadDataBeforeShow
public class KlijentEdit extends StandardEditor<Klijent> {

    @Inject
    private InstanceContainer<Klijent> klijentDc;
    @Inject
    private Notifications notifications;
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private KlijentService klijentService;

    @Subscribe("commitBtn")
    public void onCommitBtnClick(Button.ClickEvent event) {
        Klijent klijent = klijentDc.getItem();

        try{
            if(klijent.getVrstaKlijenta() == VrstaKlijenta.PRAVNO_LICE)
                validirajPravnoLice(klijent);

            klijentService.kreirajKlijenta(klijent);

            getScreenData().loadAll();
            screenBuilders.lookup(Klijent.class, this)
                    .withOpenMode(OpenMode.THIS_TAB)
                    .show();
        }catch (ValidationException ve){
            notifications.create().withCaption(ve.getMessage()).show();
        }
        catch (Exception e){
            notifications.create().withCaption(e.getMessage()).show();
            screenBuilders.lookup(Klijent.class, this)
                    .withOpenMode(OpenMode.THIS_TAB)
                    .show();
        }
    }

    public void validirajPravnoLice(Klijent klijent) throws Exception {
        if(klijent.getPib() == null || klijent.getPib().isEmpty()){
            throw new ValidationException("Unos PIB-a je obavezan!");
        }
        if(klijent.getMib() == null || klijent.getMib().isEmpty()){
            throw new ValidationException("Unos MIB-a je obavezan!");
        }
        if(klijent.getNazivNadleznogOrgana() == null || klijent.getNazivNadleznogOrgana().isEmpty()){
            throw new ValidationException("Unos nadleznog organa je obavezan!");
        }
        if(klijent.getDelatnost() == null){
            throw new ValidationException("Unos delatnosti je obavezan!");
        }
    }
}