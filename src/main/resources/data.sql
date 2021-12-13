insert into course_details(id, full_name, creation_date, last_updated_date)
values (1001, 'Java', sysdate(), sysdate());
insert into course_details(id, full_name, creation_date, last_updated_date)
values (1002, 'C++', sysdate(), sysdate());
insert into course_details(id, full_name, creation_date, last_updated_date)
values (1003, 'Hello', sysdate(), sysdate());

insert into passport(id, number)
values (3001, 'E123');
insert into passport(id, number)
values (3002, 'E456');
insert into passport(id, number)
values (3003, 'E456');
insert into passport(id, number)
values (3004, 'E678');

insert into student(id, name, passport_id)
values (2001, 'Madas' , 3001);
insert into student(id, name, passport_id)
values (2002, 'Sunil', 3002);
insert into student(id, name, passport_id)
values (2003, 'Deepak', 3003);
insert into student(id, name, passport_id)
values (2004, 'Anurag', 3004);



insert into review(id, rating, description)
values (4001, '5', '');
insert into review(id, rating, description)
values (4002, '4', 'Bad');
insert into review(id, rating, description)
values (4003, '3', 'Good');
