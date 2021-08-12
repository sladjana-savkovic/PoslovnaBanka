alter table BANK_BANKA add constraint FK_BANK_BANKA_ON_MESTO foreign key (MESTO_ID) references BANK_MESTO(ID);
create index IDX_BANK_BANKA_ON_MESTO on BANK_BANKA (MESTO_ID);
