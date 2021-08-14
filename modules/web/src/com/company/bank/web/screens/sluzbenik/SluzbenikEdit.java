package com.company.bank.web.screens.sluzbenik;

import com.company.bank.entity.Klijent;
import com.company.bank.service.SluzbenikService;
import com.haulmont.cuba.core.app.EmailService;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.bank.entity.Sluzbenik;
import org.apache.commons.math3.stat.descriptive.moment.Skewness;

import javax.inject.Inject;
import javax.validation.ValidationException;

@UiController("bank_Sluzbenik.edit")
@UiDescriptor("sluzbenik-edit.xml")
@EditedEntityContainer("sluzbenikDc")
@LoadDataBeforeShow
public class SluzbenikEdit extends StandardEditor<Sluzbenik> {

    @Inject
    private InstanceContainer<Sluzbenik> sluzbenikDc;
    @Inject
    private SluzbenikService sluzbenikService;
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private Notifications notifications;

    @Subscribe("commitBtn")
    public void onCommitBtnClick(Button.ClickEvent event) {
        try{
            validirajSluzbenika(sluzbenikDc.getItem());
            sluzbenikService.kreirajSluzbenika(sluzbenikDc.getItem());

            getScreenData().loadAll();
            screenBuilders.lookup(Sluzbenik.class, this)
                    .withOpenMode(OpenMode.THIS_TAB)
                    .show();
        }catch (ValidationException ve){
            notifications.create().withCaption(ve.getMessage()).show();
        }
        catch (Exception e){
            notifications.create().withCaption(e.getMessage()).show();
            screenBuilders.lookup(Sluzbenik.class, this)
                    .withOpenMode(OpenMode.THIS_TAB)
                    .show();
        }
    }

    public void validirajSluzbenika(Sluzbenik sluzbenik) throws Exception {
        if (sluzbenik.getIme() == null || sluzbenik.getIme().isEmpty()) {
            throw new ValidationException("Unos imena je obavezan!");
        }
        if (sluzbenik.getPrezime() == null || sluzbenik.getPrezime().isEmpty()) {
            throw new ValidationException("Unos prezimena je obavezan!");
        }
        if (sluzbenik.getJmbg() == null || sluzbenik.getJmbg().isEmpty()) {
            throw new ValidationException("Unos JMBG-a je obavezan!");
        }
        if (sluzbenik.getBanka() == null) {
            throw new ValidationException("Odabir banke je obavezan!");
        }
    }
}