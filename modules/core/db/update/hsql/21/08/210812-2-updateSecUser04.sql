alter table SEC_USER add column BANKA_ID varchar(36) ;
alter table SEC_USER add column DTYPE varchar(31) ;
-- update SEC_USER set JMBG = <default_value> where JMBG is null ;
alter table SEC_USER alter column JMBG set not null ;
