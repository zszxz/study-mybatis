CREATE TABLE `course` (
  `courseName` varchar(255) DEFAULT NULL COMMENT '课程名称',
  `coursePrice` decimal(10,2) DEFAULT NULL COMMENT '课程价格',
  `courseId` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程id',
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='课程';


INSERT INTO `mybatis`.`course`(`courseName`, `coursePrice`, `courseId`) VALUES ('java基础课', 500.00, 1);
INSERT INTO `mybatis`.`course`(`courseName`, `coursePrice`, `courseId`) VALUES ('javaWeb课程', 1000.00, 2);
