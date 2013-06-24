/*
 * 실행시키기 전, 데이터베이스에 테이블  만들기
 * Database: Oracle
 * TABLE 명 : Fruits
 */

drop table Fruits;

CREATE TABLE Fruits (
	no NUMBER(4) primary key,
	name VARCHAR2(20) not null,
	servingSize NUMBER(10) not null,
	calories NUMBER(6,3) not null,
	carbohydrate NUMBER(6,3),
	fat NUMBER(6,3), 
	protein NUMBER(6,3)  
) 
tablespace users;

INSERT INTO Fruits (no, name, servingSize, calories, carbohydrate, fat, protein) VALUES (1,'Apples',100,52,13.81,0.17,0.26);
INSERT INTO Fruits (no, name, servingSize, calories, carbohydrate, fat, protein) VALUES (2,'Bananas',100,346,88.28,1.81,3.89);
INSERT INTO Fruits (no, name, servingSize, calories, carbohydrate, fat, protein) VALUES (3,'Grapes',100,67,16.26,0.33,0.6);
INSERT INTO Fruits (no, name, servingSize, calories, carbohydrate, fat, protein) VALUES (4,'Lemons',100,47,16,0.3,1.5);
INSERT INTO Fruits (no, name, servingSize, calories, carbohydrate, fat, protein) VALUES (5,'Strawberries',100,32,7.68,0.3,0.67);