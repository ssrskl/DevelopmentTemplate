create database test character set 'utf8mb4';

use test;
drop table if exists test_user;
create table test_user
(
    id          bigint(0)    not null auto_increment comment '主键ID',
    username    varchar(255) not null comment '用户名',
    password    varchar(255) not null comment '密码',
    create_time datetime(0) default now() comment '创建时间',
    update_time datetime(0) default now() comment '更新时间',
    primary key (id)
) engine = innodb
  auto_increment = 1
  character set = utf8mb4
    comment = '测试用户表';
insert into test_user
values (1, '猫颜', 'ar352878987', now(), now());

drop table if exists test_blog;
create table test_blog
(
    id           bigint(0) not null auto_increment comment '主键ID',
    author       bigint(0) not null comment '作者ID',
    blog_content varchar(255) comment '博客内容',
    create_time  datetime(0) default now() comment '创建时间',
    update_time  datetime(0) default now() comment '更新时间',
    primary key (id)
) engine = innodb
  auto_increment = 1
  character set = utf8mb4
    comment = '测试博客表';
insert into test_blog
values (1, 1, '第一个博客', now(), now());
