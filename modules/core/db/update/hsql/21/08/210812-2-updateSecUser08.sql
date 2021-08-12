alter table SEC_USER alter column DTYPE rename to DTYPE__U38304 ^
alter table SEC_USER alter column BANKA_ID rename to BANKA_ID__U19836 ^
alter table SEC_USER drop constraint FK_SEC_USER_ON_BANKA ;
drop index IDX_SEC_USER_ON_BANKA ;
alter table SEC_USER alter column TELEFON rename to TELEFON__U44773 ^
alter table SEC_USER alter column JMBG rename to JMBG__U87811 ^
alter table SEC_USER alter column PREZIME rename to PREZIME__U94990 ^
alter table SEC_USER alter column PREZIME__U94990 set null ;
alter table SEC_USER alter column IME rename to IME__U13661 ^
alter table SEC_USER alter column IME__U13661 set null ;
alter table SEC_USER add column DTYPE varchar(31) ;
