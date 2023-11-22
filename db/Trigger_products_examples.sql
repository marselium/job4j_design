create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

create or replace function discount()
    returns trigger as
$$
    BEGIN
        update products
        set price = price - price * 0.2
        where count <= 5 AND id = new.id;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger discount_trigger
    after insert
    on products
    for each row
    execute procedure discount();
	
alter table products disable trigger discount_trigger;	

	insert into products (name, producer, count, price) VALUES ('product_3', 'producer_3', 8, 115);
	insert into products (name, producer, count, price) VALUES ('product_2', 'producer_2', 4, 105);
	insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 50);
	insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 50);
	insert into products (name, producer, count, price) VALUES ('product_2', 'producer_2', 3, 105);
	insert into products (name, producer, count, price) VALUES ('product_2', 'producer_2', 8, 105);
	
alter table products disable trigger discount_trigger;
	
create or replace function tax()
    returns trigger as
$$
    BEGIN
        update products
        set price = price - price * 0.2
        where id = (select id from inserted) and count <= 5;
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_trigger
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure tax();
	
alter table products disable trigger tax_trigger;

select *
from information_schema.triggers