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
    PIB varchar(255),
    MIB varchar(255),
    NAZIV_NADLEZNOG_ORGANA varchar(255),
    VRSTA_KLIJENTA integer not null,
    DELATNOST_ID varchar(36),
    --
    primary key (ID)
);