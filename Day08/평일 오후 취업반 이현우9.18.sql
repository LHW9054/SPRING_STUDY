select * from member2;
desc member2;

select * from member2;

create sequence member2_seq
    start with 1
    maxvalue 99999
    increment by 1
    nocycle
    nocache;

create table member2(
    idx         number          default member2_seq.nextval primary key,
    userid      varchar2(100)   not null unique,
    userpw      varchar2(500)   not null,
    salt        varchar2(50)    not null,
    username    varchar2(100)   not null,
    email       varchar2(100)   not null unique
);

select * from member2;
commit;





