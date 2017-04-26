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
insert into sys_user values(REPLACE(UUID(),'-',''),'张三','zhangsan','123456');

drop table if exists `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `code` varchar(20) DEFAULT NULL COMMENT '系统编码',
  `name` varchar(200) DEFAULT NULL COMMENT '系统名字',
  `domain` varchar(200) DEFAULT NULL COMMENT '系统域名',
  `port` varchar(100) DEFAULT NULL COMMENT '系统端口号',
  `path` varchar(200) DEFAULT NULL COMMENT '系统web路径',
  `href` varchar(200) DEFAULT NULL COMMENT '链接',
  `sort` int DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=ndb DEFAULT CHARSET=utf8 COMMENT='系统菜单表';

insert into sys_menu values(REPLACE(UUID(),'-',''),'base-data','基础数据系统','base-data.cluster.com','80','/base-data-web','/sysUser/list.do','1');
insert into sys_menu values(REPLACE(UUID(),'-',''),'oms','订单系统','oms.cluster.com','8040','/oms-web','/order/list.do','2');
insert into sys_menu values(REPLACE(UUID(),'-',''),'wms','仓储系统','wms.cluster.com','8050','/wms-web','/commoditySku/list.do','3');

use wms_db;

drop table if exists `commodity_sku`;
CREATE TABLE `commodity_sku` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `com_code` varchar(20) DEFAULT NULL COMMENT '商品编码',
  `sku_code` varchar(40) NOT NULL COMMENT 'sku商品编码',
  `barcode` varchar(50) NOT NULL COMMENT 'sku商品条码',
  `title` varchar(50) NOT NULL COMMENT '商品标题',
  `name` varchar(200) NOT NULL COMMENT '商品名称',
  `qty` int(4) DEFAULT NULL COMMENT '商品数量',
  PRIMARY KEY (`id`)
) ENGINE=ndb DEFAULT CHARSET=utf8 COMMENT='商品sku表';

insert into commodity_sku values(REPLACE(UUID(),'-',''),'50001','SKU60001','1000001','老中医蜂蜜保湿抗皱嫩肤水 118ml/瓶','老中医蜂蜜保湿抗皱嫩肤水 118ml/瓶',100);
insert into commodity_sku values(REPLACE(UUID(),'-',''),'50002','SKU60002','1000002','晨光 新流行 中性笔 0.38mm 天蓝 AGP62403  (1支 )','晨光 新流行 中性笔 0.38mm 天蓝 AGP62403  (1支 )',100);
insert into commodity_sku values(REPLACE(UUID(),'-',''),'50003','SKU60003','1000003','洋美里东宝水壶5L','洋美里东宝水壶5L',100);
insert into commodity_sku values(REPLACE(UUID(),'-',''),'50004','SKU60004','1000004','妙洁棉质神奇拖把替换装','妙洁棉质神奇拖把替换装',100);
insert into commodity_sku values(REPLACE(UUID(),'-',''),'50005','SKU60005','1000005','盼盼蛋黄派  蛋黄味  1.08kg/箱   糕点零食','盼盼蛋黄派  蛋黄味  1.08kg/箱   糕点零食',100);

use oms_db;

drop table if exists `order`;
CREATE TABLE `order` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `com_code` varchar(20) DEFAULT NULL COMMENT '商品编码',
  `sku_code` varchar(40) NOT NULL COMMENT 'sku商品编码',
  `barcode` varchar(50) NOT NULL COMMENT 'sku商品条码',
  `title` varchar(50) NOT NULL COMMENT '商品标题',
  `name` varchar(200) NOT NULL COMMENT '商品名称',
  `qty` int(4) DEFAULT NULL COMMENT '订单数量',
  PRIMARY KEY (`id`)
) ENGINE=ndb DEFAULT CHARSET=utf8 COMMENT='订单表';

