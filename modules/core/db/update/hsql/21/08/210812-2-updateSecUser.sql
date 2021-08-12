-- alter table SEC_USER add column JMBG varchar(13) ^
-- update SEC_USER set JMBG = <default_value> ;
-- alter table SEC_USER alter column JMBG set not null ;
alter table SEC_USER add column JMBG varchar(13) ;
alter table SEC_USER add column IME varchar(255) ^
update SEC_USER set IME = '' where IME is null ;
alter table SEC_USER alter column IME set not null ;
alter table SEC_USER add column TELEFON varchar(255) ;
-- alter table SEC_USER add column BANKA_ID varchar(36) ^
-- update SEC_USER set BANKA_ID = <default_value> ;
-- alter table SEC_USER alter column BANKA_ID set not null ;
alter table SEC_USER add column BANKA_ID varchar(36) not null ;
alter table SEC_USER add column DTYPE varchar(31) ;
alter table SEC_USER add column PREZIME varchar(255) ^
update SEC_USER set PREZIME = '' where PREZIME is null ;
alter table SEC_USER alter column PREZIME set not null ;
