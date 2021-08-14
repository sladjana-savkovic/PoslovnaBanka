package com.company.bank.web.screens.klijent;

import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.screen.*;
import com.company.bank.entity.Klijent;
import com.haulmont.cuba.gui.screen.LookupComponent;
import com.haulmont.reports.gui.actions.list.ListPrintFormAction;
import com.haulmont.reports.gui.actions.list.RunReportAction;

import javax.inject.Inject;

@UiController("bank_Klijent.browse")
@UiDescriptor("klijent-browse.xml")
@LookupComponent("klijentsTable")
@LoadDataBeforeShow
public class KlijentBrowse extends StandardLookup<Klijent> {

}