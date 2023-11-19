create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date)
values ('fishes', 10001, '11.11.1111');
insert into fauna(name, avg_age, discovery_date)
values ('dogs', 2323, '11.11.0003');
insert into fauna(name, avg_age, discovery_date)
values ('armadillo', 101, null);
insert into fauna(name, avg_age, discovery_date)
values ('lions', 20001, '11.11.1980');
insert into fauna(name, avg_age, discovery_date)
values ('squirrel', 13003, '11.11.2000');

select*from fauna where name like '%fish%'
select*from fauna where avg_age > 10000 and avg_age < 21000
select*from fauna where discovery_date is null
select*from fauna where discovery_date < '01.01.1950'

