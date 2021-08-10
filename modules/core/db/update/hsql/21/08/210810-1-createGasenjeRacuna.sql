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
    RAZLOG_GASENJA varchar(255) not null,
    RACUN_ZA_PRENOS varchar(18) not null,
    --
    primary key (ID)
);