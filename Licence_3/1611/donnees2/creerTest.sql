drop table test purge ;
create table test 
(
empno NUMBER (4),
ename VARCHAR2 (10),
job VARCHAR2 (9),
mgr NUMBER (4),
hiredate DATE,
sal NUMBER (7,2),
comm NUMBER (7,2),
deptno NUMBER (2)
);

CREATE TABLE test1 AS(
    SELECT * 
    FROM test 
    WHERE ename = 'ADAMS'
);