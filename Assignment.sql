create database employee;
use employee;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(80) DEFAULT NULL,
  `lastname` varchar(20) DEFAULT NULL,
  `empid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `line1` varchar(80) DEFAULT NULL,
  `line2` varchar(20) DEFAULT NULL,
  `line3` varchar(80) DEFAULT NULL,
  `city` varchar(80) DEFAULT NULL,
  `state` varchar(80) DEFAULT NULL,
  `zip` varchar(80) DEFAULT NULL,
  `country` varchar(80) DEFAULT NULL,
  `type` varchar(80) DEFAULT NULL,
  `empid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `empid` (`empid`)
);

CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) DEFAULT NULL,
  `empid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `empid` (`empid`)
);
create table Employee_Address(
   empid int(10)  references employee(id),
   addid int(10) references address(id)

 );
 create table EmployeeDepartment(
  empid int(10) references employee(id),
  depid int(10) references department(id)
 );

insert into employee(id,firstname,lastname,empid) values (1,'Paranji Muralikumar','Jyothika','123456'),
(2,'M','Sai','122550');


insert into address(id,line1,line2,line3,city,state,zip,country,type,empid)
 values(1,'8/112','Eswaramma Colony','Nehru bazzar','Madanapalli','AndhraPradesh','517325','India','Home','123456'),
(2,'5/12','Gandhi Colony','Guntur','AndhraPradesh','554821','India','Temporary','122550');


insert into department(id,name,empid) values(1,'MDU','123456'),(2,'EAS','122550');


insert into Employee_Address(empid,addid) values('123456','1'),
 ('122550','2');
 
 
 insert into EmployeeDepartment(empid,depid) values('123456','1'),('122550','2');
 
 
select e.empid,e.firstname,e.lastname,a.line1,a.line2,a.line3,a.city,a.state,a.zip,a.country,
a.type,d.name from ((employee e
inner join address a on e.empid=a.empid)
inner join department d on d.empid=e.empid)
where firstname = 'Paranji Muralikumar';

