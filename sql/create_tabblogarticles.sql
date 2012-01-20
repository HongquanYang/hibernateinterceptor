-- Added by yanghongquan 2012-1-18
CREATE TABLE `blogarticles` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `subject` varchar(24) NOT NULL COMMENT '主题',
  `content` varchar(1024) NOT NULL COMMENT '内容',
  `catagory` varchar(24) NOT NULL COMMENT '类别',
  `author` varchar(24) NOT NULL COMMENT '作者',
  `time` varchar(24) NOT NULL COMMENT '发表时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='文章表';

