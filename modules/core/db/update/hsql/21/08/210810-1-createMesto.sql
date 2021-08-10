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
);