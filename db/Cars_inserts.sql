insert into car_bodies(name) values('ВАЗ-2101');
insert into car_bodies(name) values('ВАЗ-2106');
insert into car_bodies(name) values('ВАЗ-2104');
insert into car_bodies(name) values('ВАЗ-2114');
insert into car_bodies(name) values('ВАЗ-2115');

insert into car_engines(name) values('Двигатель от газонокосилки');
insert into car_engines(name) values('Двигатель от электробритвы');
insert into car_engines(name) values('Chrysler V10');
insert into car_engines(name) values('Mitsubishi 4G63T');
insert into car_engines(name) values('Двигатель V8');

insert into car_transmissions(name) values('Механическая');
insert into car_transmissions(name) values('Автоматическая');
insert into car_transmissions(name) values('Роботизированная');
insert into car_transmissions(name) values('Вариативная');
insert into car_transmissions(name) values('фиговая');

insert into cars(name, body_id, engine_id, transmission_id) 
values('Мощь', 1, 1, 1);
insert into cars(name, body_id, engine_id, transmission_id) 
values('Лютый', 1, 2, 2);
insert into cars(name, body_id, engine_id, transmission_id) 
values('Монстр', 3, 4, 3);
insert into cars(name, body_id, engine_id, transmission_id) 
values('Корыто', 4, 4, 5);
insert into cars(name, body_id, engine_id, transmission_id) 
values('Развалюха', 5, 5, 5);
insert into cars(name, body_id, engine_id, transmission_id) 
values('Порш', null, null, null);
