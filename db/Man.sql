create table Man(
	id serial primary key,
	firstName varchar(255),
	lastName varchar(255),
	patronimyc varchar(255),
	passport int,
	phonenum int,
	addressId int references Address(id)
	);