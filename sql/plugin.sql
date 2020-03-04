CREATE TABLE `order` (
  `id` int(11) NOT NULL COMMENT '订单编号',
  `order_name` varchar(255) DEFAULT NULL COMMENT '订单名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;