create table type(
    id serial primary key,
    name varchar(255)
);

create table product(
    id serial primary key,
    name varchar(255),
	type_id int references type(id),
	expired_date date,
    price float
);

insert into type(name) values('мясо');
insert into type(name) values('рыба');
insert into type(name) values('сырок');
insert into type(name) values('сырники');
insert into type(name) values('сыр');
insert into type(name) values('молоко');
insert into type(name) values('сосиски');

insert into product(name, type_id, expired_date, price)
values('мясное мясо из мяса коровы(честно)', 1, '2025-11-20', '10');
insert into product(name, type_id, expired_date, price)
values('рыба фугу', 2, '2025-10-20', '1000');
insert into product(name, type_id, expired_date, price)
values('сырок глазированный не из мяса', 3, '2025-11-20', '50');
insert into product(name, type_id, expired_date, price)
values('сырники творожные замороженные', 4, '2023-11-23', '200');
insert into product(name, type_id, expired_date, price)
values('молоко козье', 6, '2023-11-26', '300');
insert into product(name, type_id, expired_date, price)
values('молоко коровье', 6, '2023-11-26', '340');
insert into product(name, type_id, expired_date, price)
values('сосиски молочные', 7, '2023-12-26', '400');
insert into product(name, type_id, expired_date, price)
values('мясо свинина', 1, '2023-09-22', '400');
insert into product(name, type_id, expired_date, price)
values('сырок бю Александровъ', 3, '2023-12-26', '1500');
insert into product(name, type_id, expired_date, price)
values('сосиски немолочные', 7, '2023-12-30', '300');
insert into product(name, type_id, expired_date, price)
values('сыр сыр', 5, '2024-01-26', '1200');
insert into product(name, type_id, expired_date, price)
values('мороженое холодное', 6, '2024-01-26', '100');

select*from product where name like '%сыр%';

select*from product where name like '%мороженое%';

select*from product where expired_date < NOW();

select name, price from product
where price = (select max(price) from product);

select type.name as "имя типа", count(p.type_id) as количество from type 
inner join product as p on type.id = p.type_id
group by type.name;

select * from product where type_id = 5 or type_id = 6;

select type.name as "имя типа", count(p.type_id) as количество
from type 
inner join product as p 
on type.id = p.type_id
group by type.name 
having count(p.type_id) < 10;

select pr.name, tp.name from product pr
inner join type tp
on tp.id = pr.type_id;