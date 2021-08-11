-- begin BANK_GASENJE_RACUNA
create table BANK_GASENJE_RACUNA (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    RACUN_ZA_GASENJE_ID varchar(36) not null,
    DATUM_KREIRANJA timestamp,
    RAZLOG_GASENJA varchar(255) not null,
    RACUN_ZA_PRENOS varchar(18) not null,
    --
    primary key (ID)
)^
-- end BANK_GASENJE_RACUNA
-- begin BANK_DNEVNO_STANJE
create table BANK_DNEVNO_STANJE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    RACUN_ID varchar(36),
    DATUM_PROMETA timestamp,
    PRETHODNO_STANJE double precision,
    PROMET_NA_TERET double precision,
    PROMET_U_KORIST double precision,
    NOVO_STANJE double precision,
    --
    primary key (ID)
)^
-- end BANK_DNEVNO_STANJE
-- begin BANK_BANKA
create table BANK_BANKA (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SIFRA_BANKE varchar(3) not null,
    NAZIV_BANKE varchar(255) not null,
    SWIFT_KOD varchar(8) not null,
    OBRACUNSKI_RACUN varchar(18) not null,
    MESTO_ID varchar(36),
    ADRESA varchar(255),
    TELEFON varchar(255),
    --
    primary key (ID)
)^
-- end BANK_BANKA
-- begin BANK_SIFARNIK_DELATNOSTI
create table BANK_SIFARNIK_DELATNOSTI (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SIFRA_DELATNOSTI integer not null,
    NAZIV_DELATNOSTI varchar(255) not null,
    --
    primary key (ID)
)^
-- end BANK_SIFARNIK_DELATNOSTI
-- begin BANK_MESTO
create table BANK_MESTO (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAZIV_MESTA varchar(255) not null,
    POSTANSKI_BROJ integer not null,
    --
    primary key (ID)
)^
-- end BANK_MESTO
-- begin BANK_KLIJENT
create table BANK_KLIJENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    IME varchar(255) not null,
    PREZIME varchar(255) not null,
    JMBG varchar(13) not null,
    MESTO_ID varchar(36),
    ADRESA varchar(255),
    TELEFON varchar(255),
    EMAIL varchar(255),
    PIB varchar(9),
    MIB varchar(8),
    NAZIV_NADLEZNOG_ORGANA varchar(255),
    VRSTA_KLIJENTA integer not null,
    DELATNOST_ID varchar(36),
    --
    primary key (ID)
)^
-- end BANK_KLIJENT

-- begin BANK_NALOG
create table BANK_NALOG (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    VRSTA_NALOGA integer not null,
    DUZNIK varchar(255),
    SVRHA_PLACANJA varchar(255),
    POVERILAC varchar(255),
    SIFRA_PLACANJA varchar(3),
    SIFRA_VALUTE varchar(3),
    IZNOS double precision not null,
    RACUN_DUZNIKA varchar(18),
    MODEL_ZADUZENJE varchar(2),
    POZIV_NA_BROJ_ZADUZENJE varchar(20),
    RACUN_POVERIOCA varchar(18),
    MODEL_ODOBRENJE varchar(2),
    POZIV_NA_BROJ_ODOBRENJE varchar(20),
    DATUM_PLACANJA timestamp not null,
    HITNO boolean,
    STATUS_NALOGA integer,
    DATUM_VALUTE timestamp,
    DNEVNO_STANJE_ID varchar(36),
    PORUKA_ID varchar(36),
    --
    primary key (ID)
)^
-- end BANK_NALOG
-- begin BANK_RACUN
create table BANK_RACUN (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    BANKA_ID varchar(36),
    KLIJENT_ID varchar(36) not null,
    BROJ_RACUNA varchar(18),
    DATUM_OTVARANJA timestamp,
    AKTIVNOST boolean,
    TIP_RACUNA integer not null,
    NAMENA_RACUNA varchar(255),
    VRSTA_RACUNA integer not null,
    --
    primary key (ID)
)^
-- end BANK_RACUN
-- begin BANK_PORUKA
create table BANK_PORUKA (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ID_PORUKE integer not null,
    VRSTA_PORUKE integer not null,
    BANKA_POVERIOCA_ID varchar(36) not null,
    BANKA_DUZNIKA_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end BANK_PORUKA
-- begin BANK_SLUZBENIK
create table BANK_SLUZBENIK (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    IME varchar(255) not null,
    PREZIME varchar(255) not null,
    JMBG varchar(13) not null,
    TELEFON varchar(255),
    EMAIL varchar(255) not null,
    BANKA_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end BANK_SLUZBENIK
