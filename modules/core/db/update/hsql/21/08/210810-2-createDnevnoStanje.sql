alter table BANK_DNEVNO_STANJE add constraint FK_BANK_DNEVNO_STANJE_ON_RACUN foreign key (RACUN_ID) references BANK_RACUN(ID);
create index IDX_BANK_DNEVNO_STANJE_ON_RACUN on BANK_DNEVNO_STANJE (RACUN_ID);
