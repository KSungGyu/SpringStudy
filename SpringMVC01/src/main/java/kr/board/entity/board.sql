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
values('�Խ��� ����','�Խ��� ����','������');

insert into myboard(title,content,writer)
values('�Խ��� ����','�Խ��� ����','�ڸ���');

insert into myboard(title,content,writer)
values('�Խ��� ����','�Խ��� ����','������');

select * from myboard order by idx desc;