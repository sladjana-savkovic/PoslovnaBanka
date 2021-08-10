package com.company.bank.web.screens.klijent;

import com.haulmont.cuba.gui.screen.*;
import com.company.bank.entity.Klijent;

@UiController("bank_Klijent.browse")
@UiDescriptor("klijent-browse.xml")
@LookupComponent("klijentsTable")
@LoadDataBeforeShow
public class KlijentBrowse extends StandardLookup<Klijent> {
}