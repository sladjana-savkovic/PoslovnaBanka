alter table BANK_KLIJENT add constraint FK_BANK_KLIJENT_ON_MESTO foreign key (MESTO_ID) references BANK_MESTO(ID);
create index IDX_BANK_KLIJENT_ON_MESTO on BANK_KLIJENT (MESTO_ID);
