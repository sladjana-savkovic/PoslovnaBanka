package com.company.bank.web.screens.banka;

import com.haulmont.cuba.gui.screen.*;
import com.company.bank.entity.Banka;

@UiController("bank_Banka.browse")
@UiDescriptor("banka-browse.xml")
@LookupComponent("bankasTable")
@LoadDataBeforeShow
public class BankaBrowse extends StandardLookup<Banka> {
}