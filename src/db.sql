drop database if exists demo;
create database demo default character set utf8;
use demo;
drop table if exists product;
drop table if exists category;

create table category
(
	c_id 			   int not null auto_increment,
	c_name 			   varchar(20),
	primary key (c_id)
);

create table product
(
   pro_id                  int not null auto_increment,
   pro_name                varchar(20),
   pro_price               decimal(8,2),
   pro_remark              longtext,
   pro_date                timestamp default CURRENT_TIMESTAMP,
   c_id					   int,
   primary key (pro_id)
);

insert into category (c_name) values ('手机');
insert into category (c_name) values ('服装');
insert into category (c_name) values ('电器');

/* 商品测试用例 */
insert into product (pro_name,pro_price,pro_remark,c_id) values ('圣得西服',3000.00,'这里是简单介绍',2);
insert into product (pro_name,pro_price,pro_remark,c_id) values ('衫衫西服',3000.00,'这里是简单介绍',2);
insert into product (pro_name,pro_price,pro_remark,c_id) values ('Iphone6',6000.00,'这里是简单介绍',1);

select * from product;
select * from category;