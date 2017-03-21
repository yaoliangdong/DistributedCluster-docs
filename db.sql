drop database if exists base_data_db;
drop database if exists oms_db;
drop database if exists wms_db;

create database base_data_db;
create database oms_db;
create database wms_db;

use base_data_db;

drop table if exists `sys_user`;
CREATE TABLE `sys_user` (
  `id` char(32) NOT NULL COMMENT 'id',
  `name` char(32) NOT NULL COMMENT '用户名',
  `login_name` char(32) NOT NULL COMMENT '登录名',
  `pass` char(32) DEFAULT NULL COMMENT '登录密码',
  PRIMARY KEY (`id`)
) ENGINE=ndb DEFAULT CHARSET=utf8 COMMENT='系统用户表';
insert into sys_user values(REPLACE(UUID(),'-',''),'系统管理员','admin','123456');

drop table if exists `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `code` varchar(20) DEFAULT NULL COMMENT '系统编码',
  `name` varchar(200) DEFAULT NULL COMMENT '系统名字',
  `domain` varchar(200) DEFAULT NULL COMMENT '系统域名',
  `port` varchar(100) DEFAULT NULL COMMENT '系统端口号',
  `path` varchar(200) DEFAULT NULL COMMENT '系统web路径',
  `sort` int DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=ndb DEFAULT CHARSET=utf8 COMMENT='系统菜单表';

insert into sys_menu values(REPLACE(UUID(),'-',''),'base-data','基础数据系统','base-data.cluster.com','80','/base-data-web','1');
insert into sys_menu values(REPLACE(UUID(),'-',''),'oms','订单系统','oms.cluster.com','8040','/oms-web','3');
insert into sys_menu values(REPLACE(UUID(),'-',''),'wms','仓储系统','wms.cluster.com','8050','/wms-web','4');
