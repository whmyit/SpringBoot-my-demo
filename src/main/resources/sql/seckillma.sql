-- -- 创建数据库
-- CREATE DATABASE seckill;

-- 使用数据库
USE seckill;

--  创建秒杀表
create table seckill(
seckill_id bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
name VARCHAR(120) NOT NULL COMMENT '商品名称',
number int NOT null COMMENT '库存量',
start_time timestamp NOT NULL COMMENT '秒杀开始时间',
end_time timestamp NOT NULL COMMENT  '秒杀结束时间',
create_time timestamp NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
primary KEY(seckill_id),
key idx_start_time(start_time),
key idx_end_time(end_time),
key idx_create_time(create_time)

)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=UTF8 COMMENT='秒杀库存表'


-- 初始化数据

insert into seckill
(name,number,start_time,end_time) 
values
('1元秒杀苹果7个',999,'2017-05-01 00:00:00','2017-05-25 00:00:00'),
('1000元秒杀苹果6s',999,'2017-05-01 00:00:00','2017-05-25 00:00:00'),
('100元秒杀苹果4s',999,'2017-05-01 00:00:00','2017-05-25 00:00:00'),
('10元秒杀苹果100个',999,'2017-05-01 00:00:00','2017-05-25 00:00:00'),
('5元秒杀罗技键盘',999,'2017-05-01 00:00:00','2017-05-12 00:00:00'),
('50元秒杀达尔优pro600键盘',999,'2017-05-01 00:00:00','2017-05-11 00:00:00');


-- 秒杀成功明细表
-- 用户登录认证相关信息
create table success_seckill(
seckill_id BIGINT not null comment '秒杀商品id',
user_phone  bigint not null COMMENT '用户手机号',
stat TINYINT not null default -1 comment '状态 -1 无效  0成功 1已付款 2已发货',
create_time timestamp not null default CURRENT_TIMESTAMP COMMENT '创建时间',
primary key (seckill_id,user_phone),
key idx_create_time(create_time)
)ENGINE=InnoDB  DEFAULT CHARSET=UTF8 COMMENT='秒杀成功明细'





