基于电商交易场景（用户、商品、订单），设计一套简单的表结构，提交 DDL 的 SQL 文件到 Github

这个题是啥意思？写几个创建删除的sql语句吗？

设计三个表，表1，userinfo: 包含字段用户id，用户名，注册日期；表2，userbuy：包含字段用户id，订单id, 购买日期；表3，goodsinfo：商品id，商品名称，类目，价格。

首先创建数据库 create database ecommercedata;

创建第一个表：

use ecommercedata;
create table if not exists userinfo(
  userid tinytext,
  username tinytext
  registerdate date 
) engine=InnoDB default charset=utf8;

创建第二个表：

create table if not exist userbuy (
  userid tinytext,
  goodid tinytext,
  buydate date
) engine=InnoDB default charset=utf8;

创建第三个表：

create table if not exist goodsinfo(
  goodid tinytext;
  goodname tinytext;
  category tinytext;
  price float
) engine=InnoDB default charset=utf8;


插入数据表：
insert into userinfo (userid, username, registerdate)
values
("123343435","xiaoyaoyou", "20210913" );

查询数据表：
select userid, username, registerdate from userinfo [where ...] [limit ...]

删除数据：
delete from userinfo [where ...]

如果要删除数据表，可以如下操作(如删除第一个表)：

drop table userinfo;

删除数据库：
drop database ecommercedata;









