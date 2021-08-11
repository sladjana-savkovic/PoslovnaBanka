alter table BANK_NALOG alter column DATUM_VALUTE rename to DATUM_VALUTE__U42244 ^
alter table BANK_NALOG alter column DATUM_PLACANJA rename to DATUM_PLACANJA__U67251 ^
alter table BANK_NALOG alter column DATUM_PLACANJA__U67251 set null ;
alter table BANK_NALOG add column DATUM_PLACANJA date ^
update BANK_NALOG set DATUM_PLACANJA = current_date where DATUM_PLACANJA is null ;
alter table BANK_NALOG alter column DATUM_PLACANJA set not null ;
alter table BANK_NALOG add column DATUM_VALUTE date ;
