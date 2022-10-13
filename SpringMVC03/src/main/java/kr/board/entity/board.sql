create table myboard(
	idx int not null auto_increment,
	title varchar(100) not null,
	content varchar(2000) not null,
	writer varchar(30) not null,
	indate datetime default now(),
	count int default 0,
	primary key(idx)
);

insert into myboard(title,content,writer)
values('게시판 연습','게시판 연습','관리자');

insert into myboard(title,content,writer)
values('게시판 연습','게시판 연습','박매일');

insert into myboard(title,content,writer)
values('게시판 연습','게시판 연습','선생님');

select * from myboard order by idx desc;

create table mem_tb1(
	memIdx int auto_increment, //회원번호
	memID varchar(20) not null, //회원아이디
	memPassword varchar(20) not null, //비밀번호
	memName varchar(20) not null, //이름
	memAge int, //나이
	memGender varchar(20), //성별
	memEmail varchar(50), //이메일주소
	memProfile varchar(50), //프로필사진
	primary key(memIdx) // memIdx를 primary key로 지정
);