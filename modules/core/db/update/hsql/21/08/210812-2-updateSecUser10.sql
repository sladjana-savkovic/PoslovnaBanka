alter table SEC_USER add constraint FK_SEC_USER_ON_BANKA foreign key (BANKA_ID) references BANK_BANKA(ID);
create index IDX_SEC_USER_ON_BANKA on SEC_USER (BANKA_ID);
