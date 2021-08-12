update SEC_USER set IME = '' where IME is null ;
alter table SEC_USER alter column IME set not null ;
update SEC_USER set PREZIME = '' where PREZIME is null ;
alter table SEC_USER alter column PREZIME set not null ;
-- update SEC_USER set JMBG = <default_value> where JMBG is null ;
alter table SEC_USER alter column JMBG set not null ;
