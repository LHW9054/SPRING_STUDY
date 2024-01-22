<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div id="main">
	<details>
		<summary>SQL</summary>
		<fieldset>
			<pre>
				drop table member2 purge;
drop table board4 purge;

drop sequence member2_seq;
drop sequence board4_seq;

create sequence member2_seq
    start with 1
    maxvalue 99999
    increment by 1
    nocycle
    nocache;

create sequence board4_seq
    start with 1
    maxvalue 99999
    increment by 1
    nocycle
    nocache;

create table member2(
    idx         number default  member2_seq.nextval primary key,
    userid      varchar2(100)   not null unique,
    userpw      varchar2(300)   not null,
    salt        varchar2(100)   not null,
    username    varchar2(100)   not null,
    email       varchar2(100)   not null
);

create table board4(
    idx             number default  board4_seq.nextval primary key,
    title           varchar2(100)   not null,
    member2_idx     number          not null,
    content         varchar2(4000)  not null,
    fileName        varchar2(255)  ,
    wdate           date            not null,
    viewCount       number          default 0,
    
    constraint      board4_member2_fk
    foreign key     (member2_idx)
    references      member2(idx)
);
select * from member2;
select * from board4;
commit;

				
			</pre>
		</fieldset>
	</details>
	
	<details>
		<summary>ERD</summary>
		<img width="700" height="500" src="${cpath }/resources/TABLEERD.PNG">
	</details>
</div>

</body>
</html>