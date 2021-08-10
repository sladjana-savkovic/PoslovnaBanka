package com.company.bank.web.screens.mesto;

import com.haulmont.cuba.gui.screen.*;
import com.company.bank.entity.Mesto;

@UiController("bank_Mesto.browse")
@UiDescriptor("mesto-browse.xml")
@LookupComponent("mestoesTable")
@LoadDataBeforeShow
public class MestoBrowse extends StandardLookup<Mesto> {
}