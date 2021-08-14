alter table BANK_NALOG add constraint FK_BANK_NALOG_ON_PORUKA foreign key (PORUKA_ID) references BANK_PORUKA(ID);
create index IDX_BANK_NALOG_ON_PORUKA on BANK_NALOG (PORUKA_ID);
