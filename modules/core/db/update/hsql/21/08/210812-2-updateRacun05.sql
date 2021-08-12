alter table BANK_RACUN add constraint FK_BANK_RACUN_ON_KLIJENT foreign key (KLIJENT_ID) references BANK_KLIJENT(ID);
create index IDX_BANK_RACUN_ON_KLIJENT on BANK_RACUN (KLIJENT_ID);
