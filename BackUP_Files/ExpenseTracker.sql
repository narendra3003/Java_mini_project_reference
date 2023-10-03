drop database exp_tracker;
create database Exp_Tracker;
use Exp_Tracker;

create table User(User_id int(2)primary key,Username varchar(20),Password varchar(20));
insert into User values(101,'Narendra','Tejas30'),(102,'Sanchita','Sanchi41');

create table Expense_category(Ecategory_id int(2)primary key,Ecategory_name varchar(20),user_id int (2),foreign key (user_id) references User(user_id));
insert into Expense_category values(301,'Education','101'),(302,'Transportation','102');

create table transactions(transaction_id int(5),transactiondate DATE,amount int(4),transactiontype varchar(10),categoryname varchar(15),Ecategory_id int(2),user_id int(2),foreign key (Ecategory_id) references Expense_category(Ecategory_id),foreign key (user_id) references User(user_id));
insert into transactions values(401,'2023-08-17',40000,'Expense','School',301,101),(402,'2023-08-18',20000,'Expense','Food',302,102);

create table Transaction_category(category_id int(2),categoryname varchar(20),description varchar(50));
insert into transaction_category values(201,'xyz','Online payment'),(202,'abc','Offline payment');

create table borrow_lend(bor_len_id int(2)primary key,bor_len_date Date,bor_len_due_date Date,bor_len_type varchar(10),bor_len_description varchar(30),bor_len_amount int(6),user_id int(2),foreign key (user_id) references User(user_id));
insert into borrow_lend values(601,'2023-08-30','2023-09-07','Borrowed','Borrowed from John',5000,101);

create table Savings(saving_id int(2)primary key,savingsdate DATE,amount int,User_id int(2),foreign key(User_id) references User(User_id));
insert into savings values(201,'2023-09-18',4000,101),(202,'2023-09-17',3000,102);

create table budget(budget_id int(2)primary key,elimit int(4),category_id int(3),category_name varchar(15),user_id int(2),foreign key (category_id) references Expense_category(Ecategory_id),foreign key (user_id) references User(user_id));
insert into budget values(501,70000,301,'Transportation',101),(502,75000,302,'Food',102);

