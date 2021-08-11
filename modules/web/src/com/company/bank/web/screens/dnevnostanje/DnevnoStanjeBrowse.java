package com.company.bank.web.screens.dnevnostanje;

import com.haulmont.cuba.gui.screen.*;
import com.company.bank.entity.DnevnoStanje;

@UiController("bank_DnevnoStanje.browse")
@UiDescriptor("dnevno-stanje-browse.xml")
@LookupComponent("dnevnoStanjesTable")
@LoadDataBeforeShow
public class DnevnoStanjeBrowse extends StandardLookup<DnevnoStanje> {
}