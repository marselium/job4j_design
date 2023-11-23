CREATE TABLE customers(
    id serial primary key,
    first_name text,
    last_name text,
    age int,
    country text
);

insert into customers(first_name, last_name, age, country) values
('Pavel', 'Pavlov', 20, 'Russia'), ('Mario', 'Jumpman', 30, 'Itali'),
('Sam', 'Winchester', 40, 'USA'), ('Till', 'Lindemann', 50, 'Deutchland'), ('Satoshi', 'Kurosava', 20, 'Japan');

select*from customers where age = (select min(age) from customers);

CREATE TABLE orders(
    id serial primary key,
    amount int,
    customer_id int references customers(id)
);

insert into orders(amount, customer_id) values(1, 1), (2, 2), (3, 3);

select*from customers c where c.id not in (select id from orders);