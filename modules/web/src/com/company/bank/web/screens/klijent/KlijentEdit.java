package com.company.bank.web.screens.klijent;

import com.haulmont.cuba.gui.screen.*;
import com.company.bank.entity.Klijent;

@UiController("bank_Klijent.edit")
@UiDescriptor("klijent-edit.xml")
@EditedEntityContainer("klijentDc")
@LoadDataBeforeShow
public class KlijentEdit extends StandardEditor<Klijent> {
}