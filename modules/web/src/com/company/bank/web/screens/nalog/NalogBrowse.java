package com.company.bank.web.screens.nalog;

import com.haulmont.cuba.gui.screen.*;
import com.company.bank.entity.Nalog;

@UiController("bank_Nalog.browse")
@UiDescriptor("nalog-browse.xml")
@LookupComponent("nalogsTable")
@LoadDataBeforeShow
public class NalogBrowse extends StandardLookup<Nalog> {
}