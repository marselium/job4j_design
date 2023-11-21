create view select_cars_insides as select c.id, c.name as car_name, cb.name as body_name
	   ,ce.name as engine_name, ct.name as transmission_name
from cars c left join car_bodies cb on c.body_id = cb.id
	left join car_engines ce 
		on c.engine_id = ce.id
	left join car_transmissions ct
		on c.transmission_id = ct.id
		
		select*from select_cars_insides