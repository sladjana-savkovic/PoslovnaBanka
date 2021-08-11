alter table BANK_GASENJE_RACUNA add column DATUM_KREIRANJA timestamp ^
update BANK_GASENJE_RACUNA set DATUM_KREIRANJA = current_timestamp where DATUM_KREIRANJA is null ;
alter table BANK_GASENJE_RACUNA alter column DATUM_KREIRANJA set not null ;
