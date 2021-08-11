package com.company.bank.web.screens.nalog;

import com.company.bank.service.NalogService;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.bank.entity.Nalog;

import javax.inject.Inject;

@UiController("bank_Nalog.edit")
@UiDescriptor("nalog-edit.xml")
@EditedEntityContainer("nalogDc")
@LoadDataBeforeShow
public class NalogEdit extends StandardEditor<Nalog> {

    @Inject
    private InstanceContainer<Nalog> nalogDc;
    @Inject
    private NalogService nalogService;

    @Subscribe("commitAndCloseBtn")
    public void onCommitAndCloseBtnClick(Button.ClickEvent event) {
        nalogService.kreirajNalog(nalogDc.getItem());
        getScreenData().loadAll();
    }
}