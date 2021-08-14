package com.company.bank.web.screens.banka;

import com.company.bank.service.BankaService;
import com.haulmont.bali.events.Subscription;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.ButtonsPanel;
import com.haulmont.cuba.gui.screen.*;
import com.company.bank.entity.Banka;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;

import javax.inject.Inject;
import java.util.function.Consumer;

@UiController("bank_Banka.browse")
@UiDescriptor("banka-browse.xml")
@LookupComponent("bankasTable")
@LoadDataBeforeShow
public class BankaBrowse extends StandardLookup<Banka> {

}