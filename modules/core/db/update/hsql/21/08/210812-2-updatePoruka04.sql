alter table BANK_PORUKA add constraint FK_BANK_PORUKA_ON_BANKA_DUZNIKA foreign key (BANKA_DUZNIKA_ID) references BANK_BANKA(ID);
create index IDX_BANK_PORUKA_ON_BANKA_DUZNIKA on BANK_PORUKA (BANKA_DUZNIKA_ID);
