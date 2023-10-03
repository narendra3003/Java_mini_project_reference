drop database exp_tracker;
create database Exp_Tracker;
use Exp_Tracker;

create table User(User_id int(2)primary key,Username varchar(20),Password varchar(20),Profile_info varchar(50));
insert into User values(101,'Narendra','Tejas30','Student studying in SE'),(102,'Sanchita','Sanchi41','19 year old');

create table Expense_category(Ecategory_id int(2)primary key,Ecategory_name varchar(20),user_id int (2),foreign key (user_id) references User(user_id));
insert into Expense_category values(301,'education','101'),(302,'Transportation','102');

create table transactions(transaction_id int(5),description varchar(20),transactiondate DATE,amount int(4),Ecategory_id int(2),user_id int(2),foreign key (Ecategory_id) references Expense_category(Ecategory_id),foreign key (user_id) references User(user_id));
insert into transactions values(401,'transaction details','2023-08-17',40000,301,101),(402,'transaction details','2023-08-18',20000,302,102);

create table Transaction_category(category_id int(2),categoryname varchar(20),description varchar(50), categLimit int(10));
insert into transaction_category values(201,'xyz','Online payment', 50000),(202,'abc','Offline payment', 20000);

create table Savings(saving_id int(2)primary key,description varchar(50),savingsdate DATE,category_id int(2),User_id int(2), amt int(7),foreign key(User_id) references User(User_id));
insert into savings values(101,'Details','2023-09-18',201,101, 2000),(102,'Other details','2023-09-17',202,102, 6000);

create table budget(budget_id int(2),amount int(4),Btime TIME,category_id int(2),user_id int(2));
insert into budget values(501,70000,'15:30:00',201,101),(502,75000,'56:30:00',202,102);
