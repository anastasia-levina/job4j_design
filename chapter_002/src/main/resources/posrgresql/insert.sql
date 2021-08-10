insert into role (description) values ('Администратор');
insert into role (description) values ('Привилегированный пользователь');
insert into role (description) values ('Пользователь');

insert into users (name, role_id) values ('Александр', 1);
insert into users (name, role_id) values ('Михаил', 2);
insert into users (name, role_id) values ('Анна', 3);

insert into rules (description) values ('Создание');
insert into rules (description) values ('Чтение');
insert into rules (description) values ('Редактирование');
insert into rules (description) values ('Удаление');

insert into role_rules (role_id, rules_id) values (1, 1);
insert into role_rules (role_id, rules_id) values (1, 2);
insert into role_rules (role_id, rules_id) values (1, 3);
insert into role_rules (role_id, rules_id) values (1, 4);
insert into role_rules (role_id, rules_id) values (2, 1);
insert into role_rules (role_id, rules_id) values (2, 2);
insert into role_rules (role_id, rules_id) values (2, 3);
insert into role_rules (role_id, rules_id) values (3, 1);
insert into role_rules (role_id, rules_id) values (3, 2);

insert into state (description) values ('Заявка создана');
insert into state (description) values ('Заявка в обработке');
insert into state (description) values ('Заявка закрыта');

insert into category (description) values ('Cрочно');
insert into category (description) values ('Не срочно');

insert into item (description, users_id, category_id, state_id) values ('Заявка 1', 1, 1, 2);
insert into item (description, users_id, category_id, state_id) values ('Заявка 2', 2, 1, 1);
insert into item (description, users_id, category_id, state_id) values ('Заявка 3', 3, 2, 3);

insert into comments (description, item_id) values ('Комментарий 1', 1);
insert into comments (description, item_id) values ('Комментарий 2', 2);
insert into comments (description, item_id) values ('Комментарий 3', 3);

insert into attachs (file, item_id) values ('doc', 1);
insert into attachs (file, item_id) values ('png', 1);
insert into attachs (file, item_id) values ('txt', 2);
insert into attachs (file, item_id) values ('jpg', 3);