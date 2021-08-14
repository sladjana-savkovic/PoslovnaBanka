alter table BANK_NALOG alter column VRSTA_NALOGA rename to VRSTA_NALOGA__U36115 ^
alter table BANK_NALOG alter column VRSTA_NALOGA__U36115 set null ;
alter table BANK_NALOG add column VRSTA_NALOGA varchar(50) ^
update BANK_NALOG set VRSTA_NALOGA = 'uplata' where VRSTA_NALOGA is null ;
alter table BANK_NALOG alter column VRSTA_NALOGA set not null ;
