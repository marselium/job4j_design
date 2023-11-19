create table owner(
    id serial primary key,
	ownerName varchar(255),
    seria int,
    number int
);

create table auto(
    id serial primary key,
    mark varchar(255),
	regnum varchar(10),
    owner_id int references owner(id) unique
);

insert into owner(name, seria, number) values ('Alexey', 1111, 123456);
insert into owner(name, seria, number) values ('Dmitry', 1112, 123457);
insert into owner(name, seria, number) values ('Margo', 1101, 123458);

insert into auto (mark, regnum, owner_id) values ('BMW', 'Е123КХ799', 1);
insert into auto (mark, regnum, owner_id) values ('AUDI', 'А322КХ799', 2);
insert into auto (mark, regnum, owner_id) values ('Mazda', 'Р133ОЛ199', 3);
insert into auto (mark, regnum) values ('Lada', 'Ч003АА769');
insert into auto (mark, regnum) values ('Ferrari', 'И543ФФ69');

select a.mark Марка, o.name Владелец from auto as a
inner join owner o on a.owner_id = o.id

select a.regnum Номер, o.name Владелец, o.seria ||' '||o.number Пасспорт from auto as a
inner join owner o on a.owner_id = o.id

select a.mark Марка, a.regnum Номер, o.name Владелец, o.seria ||' '||o.number Пасспорт  from auto as a
inner join owner o on a.owner_id = o.id

