-- update SEC_USER set JMBG = <default_value> where JMBG is null ;
alter table SEC_USER alter column JMBG set not null ;
-- update SEC_USER set BANKA_ID = <default_value> where BANKA_ID is null ;
alter table SEC_USER alter column BANKA_ID set not null ;
