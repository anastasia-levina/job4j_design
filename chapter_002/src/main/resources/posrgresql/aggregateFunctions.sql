create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into people(name) values ('Aleksey');
insert into people(name) values ('Anastasia');
insert into people(name) values ('Roman');
insert into people(name) values ('Olga');
insert into people(name) values ('Nikita');

insert into devices(name, price) values ('notebook HP 14s-dq2012ur', 30349);
insert into devices(name, price) values ('Apple MacBook Air 9', 104899);
insert into devices(name, price) values ('Apple iPhone 11', 46049);
insert into devices(name, price) values ('smartphone Samsung Galaxy A52', 34999);
insert into devices(name, price) values ('smartphone DEXP G450', 3199);
insert into devices(name, price) values ('tablet Samsung GALAXY Tab A 8.0', 10499);
insert into devices(name, price) values ('Apple iPad Air', 47599);

insert into devices_people(people_id, device_id) values (1, 1);
insert into devices_people(people_id, device_id) values (1, 4);
insert into devices_people(people_id, device_id) values (1, 6);
insert into devices_people(people_id, device_id) values (2, 2);
insert into devices_people(people_id, device_id) values (2, 3);
insert into devices_people(people_id, device_id) values (2, 7);
insert into devices_people(people_id, device_id) values (3, 5);
insert into devices_people(people_id, device_id) values (4, 6);
insert into devices_people(people_id, device_id) values (4, 4);
insert into devices_people(people_id, device_id) values (5, 3);
insert into devices_people(people_id, device_id) values (5, 7);

select avg(price) from devices;

select p.name, avg(d.price) from devices_people as dp join people p on dp.people_id = p.id
join devices d on dp.device_id = d.id
group by p.name;
select p.name, avg(d.price) from devices_people as dp join people p on dp.people_id = p.id
join devices d on dp.device_id = d.id
group by p.name
having avg(d.price) > 5000;