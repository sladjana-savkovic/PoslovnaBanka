package com.company.bank.web.screens.racun;

import com.company.bank.service.RacunService;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.bank.entity.Racun;

import javax.inject.Inject;

@UiController("bank_Racun.edit")
@UiDescriptor("racun-edit.xml")
@EditedEntityContainer("racunDc")
@LoadDataBeforeShow
public class RacunEdit extends StandardEditor<Racun> {

    @Inject
    private RacunService racunService;
    @Inject
    private InstanceContainer<Racun> racunDc;

    @Subscribe("commitAndCloseBtn")
    public void onCommitAndCloseBtnClick(Button.ClickEvent event) {
        racunService.kreirajRacun(racunDc.getItem());
        getScreenData().loadAll();
    }
}