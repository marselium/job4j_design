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

insert into devices(name, price) values('Iphone', '140000');
insert into devices(name, price) values('Galaxy S23', '80000');
insert into devices(name, price) values('nokia 3310', '6000');
insert into devices(name, price) values('samsung watches', '30000');
insert into devices(name, price) values('apple wathes', '60000');
insert into devices(name, price) values('MacBook', '200000');
insert into devices(name, price) values('xiaomi pad', '20000');

insert into people(name) values('Elena');
insert into people(name) values('Artyom');
insert into people(name) values('Irina');
insert into people(name) values('Mikhail');


insert into devices_people(device_id, people_id) values(1, 3);
insert into devices_people(device_id, people_id) values(2, 2);
insert into devices_people(device_id, people_id) values(3, 1);
insert into devices_people(device_id, people_id) values(4, 2);
insert into devices_people(device_id, people_id) values(5, 3);
insert into devices_people(device_id, people_id) values(4, 2);
insert into devices_people(device_id, people_id) values(6, 2);
insert into devices_people(device_id, people_id) values(7, 4);

select avg(price) from devices;

select p.name, avg(d.price) from devices d 
inner join devices_people dp 
on d.id = dp.device_id  
inner join people p
on p.id = dp.people_id
group by p.name;

select p.name, avg(d.price) from devices d 
inner join devices_people dp 
on d.id = dp.device_id  
inner join people p
on p.id = dp.people_id
group by p.name
having  avg(d.price) > 50000
