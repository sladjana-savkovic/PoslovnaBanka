-- update BANK_SLUZBENIK set EMAIL = <default_value> where EMAIL is null ;
alter table BANK_SLUZBENIK alter column EMAIL set not null ;
