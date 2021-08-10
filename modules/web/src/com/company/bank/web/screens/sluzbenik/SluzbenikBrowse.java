package com.company.bank.web.screens.sluzbenik;

import com.haulmont.cuba.gui.screen.*;
import com.company.bank.entity.Sluzbenik;

@UiController("bank_Sluzbenik.browse")
@UiDescriptor("sluzbenik-browse.xml")
@LookupComponent("sluzbeniksTable")
@LoadDataBeforeShow
public class SluzbenikBrowse extends StandardLookup<Sluzbenik> {
}