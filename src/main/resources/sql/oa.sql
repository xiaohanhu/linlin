-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.18-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 oa 的数据库结构
CREATE DATABASE IF NOT EXISTS `oa` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `oa`;

-- 导出  表 oa.audit 结构
CREATE TABLE IF NOT EXISTS `audit` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `operator_id` int(50) DEFAULT NULL COMMENT '操作人编号',
  `pass` int(1) DEFAULT NULL COMMENT '0：不通过 1：通过',
  `opinion` varchar(200) DEFAULT NULL COMMENT '意见',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='审核';

-- 正在导出表  oa.audit 的数据：~1 rows (大约)
DELETE FROM `audit`;
/*!40000 ALTER TABLE `audit` DISABLE KEYS */;
INSERT INTO `audit` (`id`, `operator_id`, `pass`, `opinion`) VALUES
	(1, 0, 1, '同意，请领导审查');
/*!40000 ALTER TABLE `audit` ENABLE KEYS */;

-- 导出  表 oa.file_type 结构
CREATE TABLE IF NOT EXISTS `file_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `desc` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='文件类型';

-- 正在导出表  oa.file_type 的数据：~3 rows (大约)
DELETE FROM `file_type`;
/*!40000 ALTER TABLE `file_type` DISABLE KEYS */;
INSERT INTO `file_type` (`id`, `name`, `desc`) VALUES
	(1, '发文', '内部向外部发送'),
	(2, '收文', '接收文档'),
	(3, '签报', '公司内日常行文');
/*!40000 ALTER TABLE `file_type` ENABLE KEYS */;

-- 导出  表 oa.to_draft 结构
CREATE TABLE IF NOT EXISTS `to_draft` (
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT '流水号',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `delete_time` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `type_number` int(50) DEFAULT NULL COMMENT '类型编号',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容分',
  `draft_number` int(50) DEFAULT NULL COMMENT '公文号',
  `send_time` timestamp NULL DEFAULT NULL COMMENT '发布时间',
  `operator_id` int(50) DEFAULT NULL COMMENT '操作人编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='起草';

-- 正在导出表  oa.to_draft 的数据：~1 rows (大约)
DELETE FROM `to_draft`;
/*!40000 ALTER TABLE `to_draft` DISABLE KEYS */;
INSERT INTO `to_draft` (`id`, `create_time`, `update_time`, `delete_time`, `type_number`, `title`, `content`, `draft_number`, `send_time`, `operator_id`) VALUES
	(1, '2017-12-26 15:14:03', '2017-12-26 15:14:08', '2017-12-26 15:14:10', 1, '我的第一篇发文的标题', '这是我第一篇发文的内容', 1, NULL, 0);
/*!40000 ALTER TABLE `to_draft` ENABLE KEYS */;

-- 导出  表 oa.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `delete_time` datetime DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `mobile` char(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL COMMENT '性别 1:男;2:女',
  `birthday` datetime DEFAULT NULL,
  `status` char(1) DEFAULT NULL COMMENT '状态 0;冻结;1激活;',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2346 DEFAULT CHARSET=utf8;

-- 正在导出表  oa.user 的数据：~7 rows (大约)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `create_time`, `update_time`, `delete_time`, `username`, `mobile`, `email`, `password`, `sex`, `birthday`, `status`) VALUES
	(1, '2017-12-06 00:01:30', '2017-12-05 23:50:23', NULL, NULL, '123456789', NULL, 'abcdefgddd', NULL, NULL, NULL),
	(3, '2017-12-05 23:51:25', '2017-12-05 23:51:25', NULL, NULL, '123456789', NULL, 'rtyuiofgh', NULL, NULL, NULL),
	(4, '2017-12-06 17:50:44', '2017-12-06 17:50:44', NULL, NULL, '126678986', NULL, 'fkfgkhjltyui', NULL, NULL, NULL),
	(6, '2017-12-07 22:45:19', '2017-12-07 22:45:19', NULL, NULL, '2123456000', NULL, 'yyyyyy', NULL, NULL, NULL),
	(7, '2017-12-09 16:39:32', '2017-12-09 16:39:32', NULL, NULL, '99999999', NULL, '00000000', NULL, NULL, NULL),
	(8, '2017-12-15 23:20:38', '2017-12-15 23:20:38', NULL, '888888', NULL, NULL, '00000', NULL, NULL, NULL),
	(9, '2017-12-15 23:23:01', '2017-12-15 23:23:01', NULL, '888888', NULL, NULL, '00000', NULL, NULL, NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
