���ڵ��̽��׳������û�����Ʒ�������������һ�׼򵥵ı�ṹ���ύ DDL �� SQL �ļ��� Github

�������ɶ��˼��д��������ɾ����sql�����

�����������1��userinfo: �����ֶ��û�id���û�����ע�����ڣ���2��userbuy�������ֶ��û�id������id, �������ڣ���3��goodsinfo����Ʒid����Ʒ���ƣ���Ŀ���۸�

���ȴ������ݿ� create database ecommercedata;

������һ����

use ecommercedata;
create table if not exists userinfo(
  userid tinytext,
  username tinytext
  registerdate date 
) engine=InnoDB default charset=utf8;

�����ڶ�����

create table if not exist userbuy (
  userid tinytext,
  goodid tinytext,
  buydate date
) engine=InnoDB default charset=utf8;

������������

create table if not exist goodsinfo(
  goodid tinytext;
  goodname tinytext;
  category tinytext;
  price float
) engine=InnoDB default charset=utf8;


�������ݱ�
insert into userinfo (userid, username, registerdate)
values
("123343435","xiaoyaoyou", "20210913" );

��ѯ���ݱ�
select userid, username, registerdate from userinfo [where ...] [limit ...]

ɾ�����ݣ�
delete from userinfo [where ...]

���Ҫɾ�����ݱ��������²���(��ɾ����һ����)��

drop table userinfo;

ɾ�����ݿ⣺
drop database ecommercedata;









