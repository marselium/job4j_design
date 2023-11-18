create table Passport(
    id serial primary key,
    passportSerial int,
    number int
);

create table Address(
	id serial primary key,
   	AddressName varchar(255),
    ParentId int
);

create table Phonenumbers(
	id serial primary key,
   	Phone int,
    AddressId int references Address(id) unique
);

create table Client(
    id serial primary key,
    Firstname varchar(255),
	Lastname varchar(255),
	Patronymic varchar(255),
	PassportId int references Passport(id) unique,
	Snils int,
	ITN int,
	Phonenumber int references Phonenumbers(id),
	AddressId int references Address(id)
);

create table MainBank(
	id serial primary key,
   	BankName varchar(255),
    AddressId int references Address(id) unique,
	BIC int,
	Phonenumber int references Phonenumbers(id),
	Manager varchar(255)
);

create table Branch(
	id serial primary key,
    AddressId int references Address(id) unique,
	BIC int,
	MainBankId int references MainBank(id) unique,
	Phonenumber int references Phonenumbers(id),
	Manager varchar(255)
);

