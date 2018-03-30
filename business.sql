create table user(

	id 		   int(11)		not null	primary key    auto_increment,
	username   varchar(50)   not null ,
	password   varchar(50)   not null,
	email	   varchar(50),
	phone	   varchar(20),
	question   varchar(100),
	answer     varchar(100),
	role       int(4)      not null,
	create_time  datetime  not null,
	update_time  datetime  not null,
	unique index  user_name_unique(username)
);

create table category(

	id   			int(11)    not null   primary key   auto_increment,
	parent_id   	int(11) ,
	name      		varchar(50),
	status    		tinyint(1)   default 1,
	sort_order  	int(4),
	create_time 	datetime,
	update_time 	datetime

);


create table product(
	id   			int(11)   	not null	primary key  	auto_increment,
	category_id		int(11)		not null,
	name 			varchar(100)	not null,
	subtitle		varchar(200),
	main_image		varchar(500),
	sub_images		text,
	detail 			text,
	price 			decimal(20,2)  not null,
	stock			int(11)			not null,
	status			int(6)		default 1,
	create_time   	datetime,
	update_time		datetime,
	foreign key(category_id) references category(id)
	on delete cascade
	on update cascade
);



create table cart(

	id   		int(11)   not null  primary key  auto_increment,
	user_id   	int(11)   not null,
	product_id 	int(11),
	quantity	int(11),
	checked		int(11),
	create_time	datetime,
	update_time datetime,
	index  user_id_unique(user_id)
);

alter table cart add constraint  product_id_foreign foreign key(product_id) references product(id);

insert into cart(user_id,product_id,quantity,checked,create_time,update_time) values (2,4,5,6,now(),now());

select id,user_id,product_id,quantity,checked,create_time,update_time from cart where user_id=? and product_id =?;



create table address(

	id           int(11)  not null  primary key   auto_increment,
	user_id		 int(11),
	receiver_name  varchar(20),
	receiver_phone varchar(20),
	receiver_mobile varchar(20),
	receiver_province varchar(20),
	receiver_city   varchar(20),
	receiver_district varchar(20),
	receiver_address   varchar(200),
	receiver_zip    varchar(6),
	create_time   datetime,
	update_time   datetime         

);



create table userOrderItem(

	uoid 				int(11)   not null   primary key  auto_increment,
	order_no   			bigint(20)    default null,
	user_id    			int(11)    default null,
	product_name 		varchar(100)  default null,
	product_image   	varchar(500)   default null,
	current_unit_price  decimal(20,2)   default null,
	payment    			decimal(20,2)  default null,
	quantity    		int(10)     default null,
	total_price  		decimal(20,2)  default  null,
	create_time   		datetime default  null,
	update_time    		datetime   default null,
	key  unique_order_no(order_no),
	key  index_userid_orderno(user_id,order_no)  
	

);

create table userOrder(

	oid 				int(11)   not null   primary key  auto_increment,     
	order_no   	bigint(20),
	user_id 	int(11),
	shipping_id	int(11),
	payment		decimal(20,2),
	payment_type int(4),
	postage		int(10),
	status		int(10),
	payment_time	int(11),
	send_time		int(6),
	end_time		datetime,
	close_time		datetime,
	create_time		datetime,
	update_time		datetime,
	unique index  order_no_unique(order_no)

);

