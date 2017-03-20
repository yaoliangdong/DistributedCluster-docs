
create database base_data_db;
create database cms_db;
create database oms_db;
create database wms_db;

use base_data_db;
CREATE TABLE `user` (
  `id` char(32) NOT NULL COMMENT 'id',
  `name` char(32) NOT NULL COMMENT '用户名',
  `login_name` char(32) NOT NULL COMMENT '登录名',
  `pass` char(32) DEFAULT NULL COMMENT '登录密码',
  PRIMARY KEY (`id`)
) ENGINE=ndb DEFAULT CHARSET=utf8 COMMENT='用户表';