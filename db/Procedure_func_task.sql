create or replace procedure p_delete_from_products(i_id integer)
language 'plpgsql'
as $$
    BEGIN
       case 
			when (select count(1) from products) > 0 then
				delete from products p
				where p.id = i_id;
			else null;
		end case;
    END;
$$;

select* from products;
ALTER SEQUENCE products_id_seq RESTART WITH 1;

create or replace function f_delete_from_products(i_id int)
returns void
language 'plpgsql'
as
$$
    begin
		case 
			when (select count(1) from products) > 0 then
				delete from products p
				where p.id = i_id;
			else null;
		end case;
    end;
$$;

call p_delete_from_products(1);

select f_delete_from_products(3);

