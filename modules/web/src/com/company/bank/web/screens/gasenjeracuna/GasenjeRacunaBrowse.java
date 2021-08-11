package com.company.bank.web.screens.gasenjeracuna;

import com.haulmont.cuba.gui.screen.*;
import com.company.bank.entity.GasenjeRacuna;

@UiController("bank_GasenjeRacuna.browse")
@UiDescriptor("gasenje-racuna-browse.xml")
@LookupComponent("gasenjeRacunasTable")
@LoadDataBeforeShow
public class GasenjeRacunaBrowse extends StandardLookup<GasenjeRacuna> {

}
