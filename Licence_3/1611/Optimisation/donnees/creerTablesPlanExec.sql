

/* creation de la table services */

DROP TABLE services purge;
CREATE TABLE services
(     	idService NUMBER(3),
	DNAME VARCHAR2(14),
	LOC VARCHAR2(13)
);
INSERT INTO services VALUES
	(1,'SERVICE1','NEW YORK');
INSERT INTO services VALUES 
	(2,'SERVICE2','DALLAS');
INSERT INTO services VALUES
	(3,'SERVICE3','CHICAGO');
INSERT INTO services VALUES
	(4,'SERVICE4','BOSTON');
INSERT INTO services VALUES
	(5,'SERVICE5','NEW YORK');
INSERT INTO services VALUES 
	(6,'SERVICE6','DALLAS');
INSERT INTO services VALUES
	(7,'SERVICE7','CHICAGO');
INSERT INTO services VALUES
	(8,'SERVICE8','BOSTON');
INSERT INTO services VALUES
	(9,'SERVICE9','CHICAGO');
INSERT INTO services VALUES
	(10,'SERVICE10','BOSTON');
COMMIT ;

/* creation de la table salaries (idSalarie, ename, job, sal, idService) et unicité sur idSalarie*/

DROP TABLE salaries0 purge;
CREATE TABLE salaries0
(     	idSalarie NUMBER(4), 
	ENAME VARCHAR2(10),
	JOB VARCHAR2(9),
	MGR NUMBER(4),
	HIREDATE DATE,
	SAL NUMBER(7,2),
	COMM NUMBER(7,2),
	idService NUMBER(2)
);

INSERT INTO salaries0 VALUES
(7369,'SMITH','CLERK',7902,to_date('17-12-1980','dd-mm-yyyy'),800,NULL,2);
INSERT INTO salaries0 VALUES
(7499,'ALLEN','SALESMAN',7698,to_date('20-2-1981','dd-mm-yyyy'),1600,300,3);
INSERT INTO salaries0 VALUES
(7521,'WARD','SALESMAN',7698,to_date('22-2-1981','dd-mm-yyyy'),1250,500,3);
INSERT INTO salaries0 VALUES
(7566,'JONES','MANAGER',7839,to_date('2-4-1981','dd-mm-yyyy'),2975,NULL,4);
INSERT INTO salaries0 VALUES
(7654,'MARTIN','SALESMAN',7698,to_date('28-9-1981','dd-mm-yyyy'),1250,1400,5);
INSERT INTO salaries0 VALUES
(7698,'BLAKE','MANAGER',7839,to_date('1-5-1981','dd-mm-yyyy'),2850,NULL,6);
INSERT INTO salaries0 VALUES
(7782,'CLARK','MANAGER',7839,to_date('9-6-1981','dd-mm-yyyy'),2450,NULL,7);
INSERT INTO salaries0 VALUES
(7788,'SCOTT','ANALYST',7566,to_date('13-7-87','dd-mm-yy')-85,3000,NULL,8);
INSERT INTO salaries0 VALUES
(7839,'KING','PRESIDENT',NULL,to_date('17-11-1981','dd-mm-yyyy'),5000,NULL,10);
INSERT INTO salaries0 VALUES
(7844,'TURNER','SALESMAN',7698,to_date('8-9-1981','dd-mm-yyyy'),1500,0,8);
INSERT INTO salaries0 VALUES
(7876,'ADAMS','CLERK',7788,to_date('13-7-87', 'dd-mm-yy')-51,1100,NULL,9);
INSERT INTO salaries0 VALUES
(7900,'JAMES','CLERK',7698,to_date('3-12-1981','dd-mm-yyyy'),950,NULL,9);
INSERT INTO salaries0 VALUES
(7902,'FORD','ANALYST',7566,to_date('3-12-1981','dd-mm-yyyy'),3000,NULL,8);
INSERT INTO salaries0 VALUES
(7934,'MILLER','CLERK',7782,to_date('23-1-1982','dd-mm-yyyy'),1300,NULL,1);
COMMIT ;

DROP TABLE salaries1 purge ;
create table salaries1 as select ename, job, sal, idService from salaries0 ;
insert into salaries1 select * from salaries1 ;
insert into salaries1 select * from salaries1 ;
insert into salaries1 select * from salaries1 ;
insert into salaries1 select * from salaries1 ;
insert into salaries1 select * from salaries1 ;
insert into salaries1 select * from salaries1 ;
insert into salaries1 select * from salaries1 ;
insert into salaries1 select * from salaries1 ;
insert into salaries1 select * from salaries1 ;
insert into salaries1 select * from salaries1 ;
insert into salaries1 select * from salaries1 ;
commit;

DROP TABLE salaries purge;
CREATE TABLE salaries
(       idSalarie NUMBER,
        ENAME VARCHAR2(10),
        JOB VARCHAR2(9),
        SAL NUMBER(7,2),
        idService NUMBER(2)
);


CREATE OR REPLACE PROCEDURE procGenere_idSalarie AS
/* La table salaries1 doit etre prealablement creee */
/* La table salaries doit etre prealablement creee */

BEGIN
DECLARE 
CURSOR cursSalaries IS
SELECT * FROM salaries1 ;
TYPE typeSalarie IS RECORD
(
ename salaries1.ename%TYPE,
job salaries1.job%TYPE,
sal salaries1.sal%TYPE,
idService salaries1.idService%TYPE
) ;
tuple typeSalarie ;

cle INTEGER ;

BEGIN

cle := 0 ;
FOR tuple IN cursSalaries LOOP
cle := cle+1 ;
INSERT INTO salaries(idSalarie, ename, job, sal, idService)
VALUES (cle, tuple.ename, tuple.job, tuple.sal, tuple.idService);
END LOOP ;

COMMIT ;


END ;
END ;
/
execute procGenere_idSalarie ;

DROP TABLE salaries1 ;
DROP TABLE salaries0 ;



