package com.company.bank.web.screens.racun;

import com.haulmont.cuba.gui.screen.*;
import com.company.bank.entity.Racun;

@UiController("bank_Racun.edit")
@UiDescriptor("racun-edit.xml")
@EditedEntityContainer("racunDc")
@LoadDataBeforeShow
public class RacunEdit extends StandardEditor<Racun> {
}