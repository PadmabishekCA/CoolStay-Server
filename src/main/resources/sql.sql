create table games 
(
	id int auto_increment primary key, 
	description varchar(100),
	num_of_players varchar(100), 
	image longblob
)

create table slot_table 
(
	start_time date, 
	end_time date
)

create table user_table 
(
	id int auto_increment primary key, 
	name varchar(100), 
	password varchar(100), 
	rolename varchar(100)
)

create table games_booking 
(
	id int auto_increment primary key, 
	games_id int, 
	userid varchar(100), 
	slotid int, 
	update_date varchar(100), 
	description varchar(100), 
	username varchar(100), 
	saved varchar(100)
)

create table cuisine 
(
	id int auto_increment primary key, 
	name varchar(100), 
	description varchar(100), 
	image longblob, 
	user_id int,
	foreign key(user_id) references user_table(id)
)

create table itinerary 
(
	id int auto_increment primary key, 
	name varchar(100), 
	description varchar(100), 
	image longblob, 
	route varchar(100), 
	vehicle_types varchar(100), 
	max_no int, 
	user_id int,
	foreign key(user_id) references user_table(id)
)