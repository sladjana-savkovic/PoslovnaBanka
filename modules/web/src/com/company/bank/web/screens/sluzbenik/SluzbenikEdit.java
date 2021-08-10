package com.company.bank.web.screens.sluzbenik;

import com.haulmont.cuba.gui.screen.*;
import com.company.bank.entity.Sluzbenik;

@UiController("bank_Sluzbenik.edit")
@UiDescriptor("sluzbenik-edit.xml")
@EditedEntityContainer("sluzbenikDc")
@LoadDataBeforeShow
public class SluzbenikEdit extends StandardEditor<Sluzbenik> {
}