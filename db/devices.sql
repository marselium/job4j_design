create table departaments(
	id serial primary key,
	name varchar(255)
);
create table employees(
	id serial primary key,
	name varchar(255),
	departaments_id int references departaments(id)
);
insert into departaments(name) values('Dep 1');
insert into departaments(name) values('Dep 2');
insert into departaments(name) values('Dep 3');
insert into departaments(name) values('Dep 4');
insert into employees(name, departaments_id) values('Вася', 1);
insert into employees(name, departaments_id) values('Петя', 2);
insert into employees(name, departaments_id) values('Лёша', 3);

select * from employees e left join departaments d on e.departaments_id = d.id;

select * from employees e right join departaments d on e.departaments_id = d.id;

select * from employees e full join departaments d on e.departaments_id = d.id;

select * from employees  cross join departaments d;

select e.name, d.name from
departaments d left join employees e on d.id = e.departaments_id
where e.name is null;

select * from employees e left join departaments d
on e.departaments_id = d.id;

select * from employees e right join departaments d
on e.departaments_id = d.id where e.name is not null;

create table teens(
	id serial primary key,
	name varchar(255),
	gender varchar(255)
);
insert into teens(name, gender) values('Лёша', 'Мужчина');
insert into teens(name, gender) values('Петя', 'Женщина');
insert into teens(name, gender) values('Женя', 'Трансформер');
insert into teens(name, gender) values('Стася', 'Андрогин');
insert into teens(name, gender) values('Буратино', 'Боевой вертолёт');
insert into teens(name, gender) values('Маша', 'Мужчина');
insert into teens(name, gender) values('Чебурашка', 'Женщина');
insert into teens(name, gender) values('Гриша', 'Мужчина');
insert into teens(name, gender) values('Федя', 'Женщина');
insert into teens(name, gender) values('Антон', 'Трансформатор');

select t1.id, t1.name, t1.gender, t2.id, t2.name, t2.gender from teens 
t1 cross join teens t2 where t1.gender != t2.gender and t2.id > t1.id;