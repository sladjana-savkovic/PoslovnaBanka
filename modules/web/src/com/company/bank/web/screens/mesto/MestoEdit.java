package com.company.bank.web.screens.mesto;

import com.haulmont.cuba.gui.screen.*;
import com.company.bank.entity.Mesto;

@UiController("bank_Mesto.edit")
@UiDescriptor("mesto-edit.xml")
@EditedEntityContainer("mestoDc")
@LoadDataBeforeShow
public class MestoEdit extends StandardEditor<Mesto> {
}