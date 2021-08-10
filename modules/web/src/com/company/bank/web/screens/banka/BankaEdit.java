package com.company.bank.web.screens.banka;

import com.haulmont.cuba.gui.screen.*;
import com.company.bank.entity.Banka;

@UiController("bank_Banka.edit")
@UiDescriptor("banka-edit.xml")
@EditedEntityContainer("bankaDc")
@LoadDataBeforeShow
public class BankaEdit extends StandardEditor<Banka> {
}