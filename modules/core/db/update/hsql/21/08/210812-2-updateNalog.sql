alter table BANK_NALOG alter column DATUM_VALUTE rename to DATUM_VALUTE__U96055 ^
alter table BANK_NALOG alter column DATUM_PLACANJA rename to DATUM_PLACANJA__U41593 ^
alter table BANK_NALOG alter column DATUM_PLACANJA__U41593 set null ;
alter table BANK_NALOG add column DATUM_PLACANJA timestamp ^
update BANK_NALOG set DATUM_PLACANJA = current_timestamp where DATUM_PLACANJA is null ;
alter table BANK_NALOG alter column DATUM_PLACANJA set not null ;
alter table BANK_NALOG add column DATUM_VALUTE timestamp ;
