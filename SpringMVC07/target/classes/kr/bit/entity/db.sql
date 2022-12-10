-- tblBoard --
create table tblBoard(
	idx int not null,
	memID varchar(20) not null,  
	title varchar(100) not null,
	content varchar(2000) not null,
	writer varchar(30) not null,
	indate datetime default now(),
	count int default 0,
	boardGroup int,
	boardSequence int,
	boardLevel int,
	boardAvailable int,
	primary key(idx)
);

select max(idx) from tblBoard; --NULL -> 1
select IFNULL(max(idx)+1,1) from tblBoard;
select IFNULL(max(boardGroup)+1,0) from tblBoard;

insert into tblBoard
select IFNULL(max(idx)+1, 1),'bit01','�Խ��ǿ���','�Խ��ǿ���','������',now(),0,IFNULL(max(boardGroup)+1,0),0, 0, 1 from tblBoard; 

select * from tblBoard;

insert into tblBoard
select IFNULL(max(idx)+1, 1),'bit02','�Խ��ǿ���','�Խ��ǿ���','�輺��',now(),0,IFNULL(max(boardGroup)+1,0),0, 0, 1 from tblBoard; 

select * from tblBoard;

insert into tblBoard
select IFNULL(max(idx)+1, 1),'bit03','�Խ��ǿ���','�Խ��ǿ���','ȫ�浿',now(),0,IFNULL(max(boardGroup)+1,0),0, 0, 1 from tblBoard; 

select * from tblBoard;

create table tblMember(
	memID varchar(50) not null, -- ȸ��ID
  	memPwd varchar(50) not null, -- ȸ�����
 	memName varchar(50) not null, -- ȸ���̸�
  	memPhone varchar(50) not null, -- ȸ����ȭ��ȣ
  	memAddr varchar(100), -- ȸ���ּ�
  	latitude decimal(13,10), -- ������ġ����
  	longitude decimal(13,10), -- ������ġ�浵
 	primary key(memID)
);

insert into tblMember(memID, memPwd, memName, memPhone)
values('bit01','bit01','������','010-1111-1111');
insert into tblMember(memID, memPwd, memName, memPhone)
values('bit02','bit02','�輺��','010-2222-2222');
insert into tblMember(memID, memPwd, memName, memPhone)
values('bit03','bit03','ȫ�浿','010-3333-3333');

select * from tblMember;