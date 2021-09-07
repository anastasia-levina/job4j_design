create table departments(
id serial primary key,
    name varchar(255)
)

create table employees(
id serial primary key,
    name varchar(255),
    department_id int references departments(id)
)

insert into departments(name) values ('department1');
insert into departments(name) values ('department2');
insert into departments(name) values ('department3');

insert into employees(name, department_id) values ('Aleksey', 3);
insert into employees(name, department_id) values ('Dmitriy', 2);
insert into employees(name, department_id) values ('Aleksandr', 2);
insert into employees(name, department_id) values ('Kirill', 3);
insert into employees(name, department_id) values ('Anna', 3);
insert into employees(name, department_id) values ('Elena', 2);

-- департаменты, где нет работников
select * from departments d left join employees e on e.department_id = d.id where e.name is null;

-- одинаковая работа запросов (левое и правое соединения)
select * from employees e left join departments d on e.department_id = d.id;

select * from departments d right join employees e on e.department_id = d.id;

-- full join
select * from departments d full join employees e on e.department_id = d.id;

-- cross join
select * from departments d cross join employees e;