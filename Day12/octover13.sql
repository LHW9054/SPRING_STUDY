select * from tab;

create table member6(
    userid          varchar(100)        primary key,
    userpw          varchar(255)        not null,
    username        varchar(255)        not null,
    gender          varchar(255)            check(gender in ('남성', '여성'))
);