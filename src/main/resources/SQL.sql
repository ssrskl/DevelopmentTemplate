drop database if exists test;
create database test character set utf8mb4;
use test;

# 创建用户表
drop table if exists test_user;
create table test_user
(
    user_id  bigint(255)  not null auto_increment comment '用户ID',
    username varchar(255) not null unique comment '用户名',
    password varchar(255) not null comment '',
    email    varchar(255) not null unique comment '',
    status   bit(1) comment '',
    avater   varchar(255) comment '',
    primary key (user_id)
) engine = innodb
  auto_increment = 1
  character set = utf8mb4
    comment = '用户表';

# 创建角色表
drop table if exists test_role;
create table test_role
(
    role_id   bigint(255)  not null auto_increment comment '角色ID',
    role_name varchar(255) not null unique comment '角色名',
    status    bit(1) comment '',
    primary key (role_id)
) engine = innodb
  auto_increment = 1
  character set = utf8mb4
    comment = '角色表';

# 创建用户角色表
drop table if exists test_user_role;
create table test_user_role
(
    user_id bigint(255) not null comment '用户ID',
    role_id bigint(255) not null comment '角色ID',
    primary key (user_id, role_id)
) engine = innodb
  auto_increment = 1
  character set = utf8mb4
    comment = '用户角色表';


# 输入测试数据
# 用户测试数据
insert into test_user (user_id, username, password, email, status, avater)
values (1, '猫颜', 'f180b420d0d522714e566b2befb08342', '1071352028@qq.com', 1, 'http');
insert into test_user (user_id, username, password, email, status, avater)
values (2, '达芬奇', 'f180b420d0d522714e566b2befb08342', 'oimaoyanio@gamil.com', 1, 'http');
insert into test_user (user_id, username, password, email, status, avater)
values (3, '猫颜2', 'f180b420d0d522714e566b2befb08342', '820244680@qq.com', 1, 'http');
# 角色测试数据
insert into test_role (role_id, role_name, status)
values (1, '管理员', 1);
insert into test_role (role_id, role_name, status)
values (2, '普通用户', 1);
# 用户角色测试数据
insert into test_user_role (user_id, role_id)
values (1, 1);
insert into test_user_role (user_id, role_id)
values (1, 2);
insert into test_user_role (user_id, role_id)
values (2, 2);
insert into test_user_role (user_id, role_id)
values (3, 2);

