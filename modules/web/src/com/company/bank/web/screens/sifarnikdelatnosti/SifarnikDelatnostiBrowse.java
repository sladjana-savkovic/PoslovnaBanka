package com.company.bank.web.screens.sifarnikdelatnosti;

import com.haulmont.cuba.gui.screen.*;
import com.company.bank.entity.SifarnikDelatnosti;

@UiController("bank_SifarnikDelatnosti.browse")
@UiDescriptor("sifarnik-delatnosti-browse.xml")
@LookupComponent("sifarnikDelatnostisTable")
@LoadDataBeforeShow
public class SifarnikDelatnostiBrowse extends StandardLookup<SifarnikDelatnosti> {
}