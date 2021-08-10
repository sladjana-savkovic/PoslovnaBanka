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
    RACUN_ID varchar(36) not null,
    DATUM_PROMETA timestamp not null,
    PRETHODNO_STANJE double precision not null,
    PROMET_NA_TERET double precision not null,
    PROMET_U_KORIST double precision not null,
    NOVO_STANJE double precision not null,
    --
    primary key (ID)
);