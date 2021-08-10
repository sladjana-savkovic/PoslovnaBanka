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
);