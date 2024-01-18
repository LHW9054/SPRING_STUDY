create sequence board3_seq
    start with 1
    maxvalue 99999
    increment by 1
    nocycle
    nocache;

create table board3(
    idx         number          default board3_seq.nextval primary key,
    title       varchar(100)    not null,
    writer      varchar(100)    not null,
    content     clob            not null,
    wdate       date            default sysdate,
    pw          varchar2(100)   not null
);
desc board3;
select * from board3;
select * from upload;
drop table upload purge;
create table upload1 (
    idx         number generated as identity primary key,
    title       varchar2(100)                   not null,
    fileName    varchar2(500)                   not null
);
select * from upload1;

commit;
