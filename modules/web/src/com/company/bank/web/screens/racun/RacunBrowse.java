package com.company.bank.web.screens.racun;

import com.haulmont.cuba.gui.screen.*;
import com.company.bank.entity.Racun;

@UiController("bank_Racun.browse")
@UiDescriptor("racun-browse.xml")
@LookupComponent("racunsTable")
@LoadDataBeforeShow
public class RacunBrowse extends StandardLookup<Racun> {
}