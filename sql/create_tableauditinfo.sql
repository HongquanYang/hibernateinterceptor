-- Added by yanghongquan 2012-1-18
CREATE TABLE `auditinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `author` varchar(32) NOT NULL COMMENT '创建者',
  `updatedby` varchar(32) NOT NULL COMMENT '修改者',
  `createdtime` varchar(32) NOT NULL COMMENT '创建时间',
  `lastupdated` varchar(32) NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='文章操作记录表';