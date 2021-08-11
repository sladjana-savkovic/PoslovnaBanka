package com.company.bank.web.screens.gasenjeracuna;

import com.company.bank.service.GasenjeRacunaService;
import com.company.bank.service.RacunService;
import com.haulmont.bali.events.Subscription;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.EditableChangeNotifier;
import com.haulmont.cuba.gui.components.Form;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.bank.entity.GasenjeRacuna;

import javax.inject.Inject;
import java.util.function.Consumer;

@UiController("bank_GasenjeRacuna.edit")
@UiDescriptor("gasenje-racuna-edit.xml")
@EditedEntityContainer("gasenjeRacunaDc")
@LoadDataBeforeShow
public class GasenjeRacunaEdit extends StandardEditor<GasenjeRacuna> {

    @Inject
    private GasenjeRacunaService gasenjeRacunaService;
    @Inject
    private InstanceContainer<GasenjeRacuna> gasenjeRacunaDc;

    @Subscribe("commitAndCloseBtn")
    public void onCommitAndCloseBtnClick(Button.ClickEvent event) {
        gasenjeRacunaService.ugasiRacuna(gasenjeRacunaDc.getItem());
        getScreenData().loadAll();
    }

}