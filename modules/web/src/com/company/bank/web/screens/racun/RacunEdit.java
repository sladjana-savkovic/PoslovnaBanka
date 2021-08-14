package com.company.bank.web.screens.racun;

import com.company.bank.service.RacunService;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.bank.entity.Racun;

import javax.inject.Inject;
import javax.validation.ValidationException;

@UiController("bank_Racun.edit")
@UiDescriptor("racun-edit.xml")
@EditedEntityContainer("racunDc")
@LoadDataBeforeShow
public class RacunEdit extends StandardEditor<Racun> {

    @Inject
    private RacunService racunService;
    @Inject
    private InstanceContainer<Racun> racunDc;
    @Inject
    private Notifications notifications;

    @Subscribe("commitAndCloseBtn")
    public void onCommitAndCloseBtnClick(Button.ClickEvent event) {
        try{
            validirajRacun(racunDc.getItem());
            racunService.kreirajRacun(racunDc.getItem());
            getScreenData().loadAll();
        }catch (ValidationException ve){
            notifications.create().withCaption(ve.getMessage()).show();
        }
    }

    public void validirajRacun(Racun racun) throws ValidationException{
        if(racun.getKlijent() == null){
            throw new ValidationException("Odabir klijenta je obavezan!");
        }
        if(racun.getTipRacuna() == null){
            throw new ValidationException("Odabir tipa racuna je obavezan!");
        }
        if(racun.getVrstaRacuna() == null){
            throw new ValidationException("Odabir tipa racuna je obavezan!");
        }
    }
}