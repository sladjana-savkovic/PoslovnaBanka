alter table BANK_RACUN add constraint FK_BANK_RACUN_ON_BANKA foreign key (BANKA_ID) references BANK_BANKA(ID);
create index IDX_BANK_RACUN_ON_BANKA on BANK_RACUN (BANKA_ID);
