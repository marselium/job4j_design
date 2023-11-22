select*from products
	
create or replace function tax_increment()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.18
       	where id = (select id from inserted);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_increment_trigger
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure tax_increment();

insert into products (name, producer, count, price) VALUES ('product_4', 'producer_4', 8, 225);

alter table products disable trigger tax_increment_trigger;
	
create or replace function tax_increment_row()
    returns trigger as
$$
    BEGIN
        NEW.price = NEW.price + NEW.price * 0.18;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_trigger
    before insert
    on products
    for each row
    execute procedure tax_increment_row();
	
insert into products (name, producer, count, price) VALUES ('product_5', 'producer_5', 8, 325);

select * from information_schema.triggers

create table history_of_price (
    id serial primary key,
    name varchar(50),
    price integer,
    date timestamp
);
	
create or replace function insert_from_products()
	returns trigger as
$$
	BEGIN
		insert into history_of_price(name, price, date)
		values (NEW.name, NEW.price, NOW());
		return NEW;
	END;
$$
LANGUAGE 'plpgsql';

create trigger insert_from_products_trigger
	after insert on products
	for each row
	execute procedure insert_from_products();
	
select*from history_of_price;

	
insert into products (name, producer, count, price) VALUES ('product_6', 'producer_6', 8, 325);