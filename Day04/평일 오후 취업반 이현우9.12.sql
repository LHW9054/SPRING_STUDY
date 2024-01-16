select banner from v$version;
select sysdate from dual;
select tname from tab;
select * from artist;
select * from album;
select * from music;

desc artist;

select * from member;

select * from member
    where
            userid = 'test'
            and
            userpw = '1234';
desc artist;            

