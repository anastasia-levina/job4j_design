create table human(
	id serial primary key,
	name text,
	age int,
	phone varchar(30)
);

insert into human(name, age, phone) values('Anastasia', '25', '+79138950041');
select * from human;
update human set phone = '+7(913)8950041';
select * from human;
delete from human;
select * from human;