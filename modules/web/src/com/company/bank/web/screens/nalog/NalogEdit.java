package com.company.bank.web.screens.nalog;

import com.company.bank.entity.VrstaNaloga;
import com.company.bank.service.NalogService;
import com.company.bank.service.RacunService;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.bank.entity.Nalog;

import javax.inject.Inject;
import javax.validation.ValidationException;

@UiController("bank_Nalog.edit")
@UiDescriptor("nalog-edit.xml")
@EditedEntityContainer("nalogDc")
@LoadDataBeforeShow
public class NalogEdit extends StandardEditor<Nalog> {

    @Inject
    private InstanceContainer<Nalog> nalogDc;
    @Inject
    private NalogService nalogService;
    @Inject
    private Notifications notifications;
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private RacunService racunService;

    @Subscribe("commitBtn")
    public void onCommitBtnClick(Button.ClickEvent event) {
        Nalog nalog = nalogDc.getItem();

        try{
            validirajNalog(nalog);
            if(nalog.getVrstaNaloga() == VrstaNaloga.NAPLATA || nalog.getVrstaNaloga() == VrstaNaloga.PRENOS)
                validirajNalogZaPrenosIliNaplatu(nalog);
            else if(nalog.getVrstaNaloga() == VrstaNaloga.UPLATA)
                validirajNalogZaUplatu(nalog);
            else if(nalog.getVrstaNaloga() == VrstaNaloga.ISPLATA)
                validirajNalogZaIsplatu(nalog);

            nalogService.kreirajNalog(nalog);

            getScreenData().loadAll();
            screenBuilders.lookup(Nalog.class, this)
                    .withOpenMode(OpenMode.THIS_TAB)
                    .show();
        }
        catch (ValidationException ve){
            notifications.create().withCaption(ve.getMessage()).show();
        }
        catch (Exception e){
            notifications.create().withCaption(e.getMessage()).show();
            screenBuilders.lookup(Nalog.class, this)
                    .withOpenMode(OpenMode.THIS_TAB)
                    .show();
        }
    }

    public void validirajNalog(Nalog nalog) throws Exception{
        if(nalog.getVrstaNaloga() == null){
            throw new ValidationException("Odabir vrste naloga je obavezan!");
        }
        if(nalog.getDuznik() == null || nalog.getDuznik().isEmpty()){
            throw new ValidationException("Unos duznika je obavezan!");
        }
        if(nalog.getSvrhaPlacanja() == null || nalog.getSvrhaPlacanja().isEmpty()){
            throw new ValidationException("Unos svrhe placanja je obavezan!");
        }
        if(nalog.getPoverilac() == null || nalog.getPoverilac().isEmpty()){
            throw new ValidationException("Unos poverioca je obavezan!");
        }
        if(nalog.getSifraPlacanja() == null || nalog.getSifraPlacanja().isEmpty()){
            throw new ValidationException("Unos sifre placanja je obavezan!");
        }
        if(nalog.getSifraValute() == null || nalog.getSifraValute().isEmpty()){
            throw new ValidationException("Unos sifre valute je obavezan!");
        }
        if(nalog.getIznos() == null){
            throw new ValidationException("Unos iznosa je obavezan!");
        }
        if(nalog.getIznos() <= 0){
            throw new ValidationException("Iznos mora biti pozitivan!");
        }
        if(nalog.getDatumPlacanja() == null){
            throw new ValidationException("Unos datuma placanja je obavezan!");
        }
    }

    public void validirajNalogZaPrenosIliNaplatu(Nalog nalog) throws Exception {
        validirajNalogZaUplatu(nalog);
        validirajNalogZaIsplatu(nalog);
    }

    public void validirajNalogZaUplatu(Nalog nalog) throws Exception {
        validirajPoveriocaIDuznika(nalog);

        if(nalog.getRacunPoverioca() == null || nalog.getRacunPoverioca().isEmpty()){
            throw new ValidationException("Unos racuna poverioca je obavezan!");
        }
        if(nalog.getModelOdobrenje() == null || nalog.getModelOdobrenje().isEmpty()){
            throw new ValidationException("Unos modela odobrenje je obavezan!");
        }
        if(nalog.getPozivNaBrojOdobrenje() == null || nalog.getPozivNaBrojOdobrenje().isEmpty()){
            throw new ValidationException("Unos poziva na broj odobrenje je obavezan!");
        }
        if(!racunService.provjeriIspravnostRacuna(nalog.getRacunPoverioca()))
            throw new ValidationException("Uneseni racun poverioca ne postoji!");
    }

    public void validirajNalogZaIsplatu(Nalog nalog) throws Exception {
        validirajPoveriocaIDuznika(nalog);

        if(nalog.getRacunDuznika() == null || nalog.getRacunDuznika().isEmpty()){
            throw new ValidationException("Unos racuna duznika je obavezan!");
        }
        if(nalog.getModelZaduzenje() == null || nalog.getModelZaduzenje().isEmpty()){
            throw new ValidationException("Unos modela zaduzenje je obavezan!");
        }
        if(nalog.getPozivNaBrojZaduzenje() == null || nalog.getPozivNaBrojZaduzenje().isEmpty()){
            throw new ValidationException("Unos poziva na broj zaduzenje je obavezan!");
        }
        if(!racunService.provjeriIspravnostRacuna(nalog.getRacunDuznika()))
            throw new ValidationException("Uneseni racun duznika ne postoji!");
    }

    public void validirajPoveriocaIDuznika(Nalog nalog) throws Exception{
        if(nalog.getDuznik() == null || nalog.getDuznik().isEmpty()){
            throw new ValidationException("Unos duznika je obavezan!");
        }
        if(nalog.getPoverilac() == null || nalog.getPoverilac().isEmpty()){
            throw new ValidationException("Unos poverioca je obavezan!");
        }
    }

}