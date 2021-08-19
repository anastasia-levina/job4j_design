create table product(
    id serial primary key,
    name varchar(255),
	expired_date date,
    price float,
	type_id int references type(id)
);

create table type(
    id serial primary key,
    name varchar(255)
);

insert into type(name) values ('замороженная продукция');
insert into type(name) values ('молоко');
insert into type(name) values ('сыр');
select * from type;
insert into product(name, type_id, expired_date, price)
values ('мороженое магнат', 1, '2022-08-14', 93.00);
insert into product(name, type_id, expired_date, price)
values ('смесь овощная 4 сезона', 1, '2021-12-11', 144.00);
insert into product(name, type_id, expired_date, price)
values ('сыр тильзитер', 3, '2022-03-05', 172.00);
insert into product(name, type_id, expired_date, price)
values ('молоко valio', 2, '2021-11-07', 159.00);
insert into product(name, type_id, expired_date, price)
values ('сыр ламбер', 3, '2021-12-13', 354.00);
insert into product(name, type_id, expired_date, price)
values ('вареники цезарь', 1, '2022-01-01', 215.00);
insert into product(name, type_id, expired_date, price)
values ('молоко простоквашино', 2, '2021-08-05', 82.00);
insert into product(name, type_id, expired_date, price)
values ('мороженое movenpick', 1, '2022-11-01', 444.00);

select * from product p join type t on p.type_id = t.id where t.name = 'сыр';
select * from product where name like '%мороженое%';
select * from product where current_date > expired_date;
select name, price as max_price from product where price = (select max(price) from product);
select t.name as "имя типа", count(p.name) as "количество" from product as p join type as t on p.type_id = t.id group by t.name;
select * from product p join type t on p.type_id = t.id where t.name in ('сыр', 'молоко');
select t.name as "имя типа", count(p.name) as "Количество" from product as p join type as t on p.type_id = t.id group by t.name having count(p.name) < 10;
select p.name as name, t.name as type from product p join type t on p.type_id = t.id;