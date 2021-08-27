-- title
insert into title values(1,'사장');
insert into title values(2,'부장');
update title set tname = "과장" where tno =2;
delete from title where tno =2;


select * from title;
-- department
insert into department values(1,'기획',10);


-- employee
insert into employee values(4377, '이성래', 1,45000000, null, 1);


select tno,tname from title;
select tno,tname from title where tno = 2;
select dptno,dptname,floor from department d;
select empno,empname,title,manager,salary,dno from employee e;

desc title;
