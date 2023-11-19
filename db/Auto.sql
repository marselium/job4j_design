Create table Auto(
	id serial primary key,
	RegNum varchar(10),
	Mark varchar(100),
	Color varchar(100),
	ownerId int references Man(id)
	);