CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '学生姓名',
  `number` int(11) DEFAULT NULL COMMENT '学生编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `mybatis`.`student`(`id`, `name`, `number`) VALUES (1, '知识追寻者', 1327);
INSERT INTO `mybatis`.`student`(`id`, `name`, `number`) VALUES (2, 'youku1327', 555);
