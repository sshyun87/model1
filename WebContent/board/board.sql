drop table board;

create table board (
	no number primary key, 
	poster    varchar2(20), 
	subject   varchar2(100),
	contents  varchar2(2000), 
	lastpost  date, 
	views     number(5)
	);
	


insert into board (1, 'aa', 'aaa', 'aaaa',sysdate, 11111);


