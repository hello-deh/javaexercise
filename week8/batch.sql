use shardingdb;
insert into t_order(user_id, status) values(1, 'ok'),(1, 'fail');
insert into t_order(user_id, status) values(2, 'ok'),(2, 'fail');

select * from t_order;
