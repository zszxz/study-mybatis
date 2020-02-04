CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `customer_name` varchar(255) DEFAULT NULL COMMENT '顾客名称',
  `gender` varchar(255) DEFAULT NULL COMMENT '性别',
  `telephone` varchar(255) DEFAULT NULL COMMENT '电话号码',
  `register_time` timestamp NULL DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='顾客表';