alter table BANK_PORUKA add constraint FK_BANK_PORUKA_ON_BANKA_POVERIOCA foreign key (BANKA_POVERIOCA_ID) references BANK_BANKA(ID);
create index IDX_BANK_PORUKA_ON_BANKA_POVERIOCA on BANK_PORUKA (BANKA_POVERIOCA_ID);
