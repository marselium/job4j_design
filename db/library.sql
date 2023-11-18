create table library(
	id serial primary key
	,bookName varchar
	,authorName text
	,shelf int
);

insert into library(
	bookName
	,authorName 
	,shelf 
) values ('Dead Souls', 'Nikolay Gogol', '3');
select*from library;
update library set shelf = 2;

delete from library;
