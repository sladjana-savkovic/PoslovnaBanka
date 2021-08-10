package com.company.bank.web.screens.sifarnikdelatnosti;

import com.haulmont.cuba.gui.screen.*;
import com.company.bank.entity.SifarnikDelatnosti;

@UiController("bank_SifarnikDelatnosti.edit")
@UiDescriptor("sifarnik-delatnosti-edit.xml")
@EditedEntityContainer("sifarnikDelatnostiDc")
@LoadDataBeforeShow
public class SifarnikDelatnostiEdit extends StandardEditor<SifarnikDelatnosti> {
}