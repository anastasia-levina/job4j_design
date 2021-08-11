create table human(
    id serial primary key,
    name varchar(255),
	city varchar(255)
 );

 create table phoneNumbers(
    id serial primary key,
    number text,
	human_id int references human(id)
 );

 insert into human(name, city) values ('Anna', 'Krasnoyarsk');
 insert into human(name, city) values ('Ivan', 'Novosibirsk');
 insert into human(name, city) values ('Elena', 'Moscow');

 insert into phoneNumbers(number, human_id) values ('+79865433321', 1);
 insert into phoneNumbers(number, human_id) values ('+79185624326', 2);
 insert into phoneNumbers(number, human_id) values ('+79125674355', 3);

select * from phoneNumber join human h on phoneNumber.human_id = h.id;
select p.number, h.name, h.city from phoneNumbers as p join human as h on p.human_id = h.id;
select p.number as Номер, h.name as Имя, h.city as Город from phoneNumbers as p join human as h on p.human_id = h.id;