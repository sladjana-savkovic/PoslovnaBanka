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
);