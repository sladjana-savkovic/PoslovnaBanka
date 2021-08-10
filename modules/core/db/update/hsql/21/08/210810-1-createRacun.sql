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
    BANKA_ID varchar(36) not null,
    KLIJENT_ID varchar(36) not null,
    TIP_RACUNA integer not null,
    NAMENA_RACUNA varchar(255),
    VRSTA_RACUNA integer not null,
    --
    primary key (ID)
);