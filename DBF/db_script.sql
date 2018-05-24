use slk_training;

drop table if exists categories;

-- creating table for categories
-- CATEGORIES (id, name, description, picture)

create table categories(
	id int primary key auto_increment,
	name varchar(255) not null,
	description varchar(255),
	picture blob
);

insert into categories (name, description) values
	('Smartphones', 'Ultra modern phones for everyone'),
	('Bands', 'Electronc wrist bands, with digital clock, step counter and more'),
	('Bluetooth speaker', null);

show tables;
select * from categories;

