alter table BANK_NALOG add constraint FK_BANK_NALOG_ON_DNEVNO_STANJE foreign key (DNEVNO_STANJE_ID) references BANK_DNEVNO_STANJE(ID);
create index IDX_BANK_NALOG_ON_DNEVNO_STANJE on BANK_NALOG (DNEVNO_STANJE_ID);
