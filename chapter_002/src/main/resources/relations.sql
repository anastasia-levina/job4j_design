/*many-to-one*/

create table nameHuman(
    id serial primary key,
    name varchar(255)
);

create table people(
    id serial primary key,
    name varchar(255),
    nameHuman_id int references nameHuman(id)
);

/*one-to-one*/

create table pensionersID(
    id serial primary key,
    number int,
	name varchar(255)
);

create table passport(
    id serial primary key,
    seria int,
    number int,
	pensionersID_id int references pensionersID(id) unique
);

/*many-to-many*/

create table people(
     id serial primary key,
     name varchar(255)
 );

 create table films(
     id serial primary key,
     name varchar(255)
 );

 create table people_films(
     id serial primary key,
     people_id int references people(id),
     films_id int references films(id)
 );