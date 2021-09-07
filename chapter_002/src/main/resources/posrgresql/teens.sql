create table teens(
    id serial primary key,
    name varchar(255),
    gender varchar(255)
)

insert into teens(name, gender) values ('Anya', 'female');
insert into teens(name, gender) values ('Nikita', 'male');
insert into teens(name, gender) values ('Maksim', 'male');
insert into teens(name, gender) values ('Masha', 'female');
insert into teens(name, gender) values ('Lena', 'female');

select t1.name, t1.gender, t2.name, t2.gender from teens as t1 cross join teens as t2 where t1.gender != t2.gender;