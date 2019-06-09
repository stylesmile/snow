-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.4.4-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 snow 的数据库结构
DROP DATABASE IF EXISTS `snow`;
CREATE DATABASE IF NOT EXISTS `snow` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `snow`;

-- 导出  表 snow.log_login 结构
DROP TABLE IF EXISTS `log_login`;
CREATE TABLE IF NOT EXISTS `log_login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `username` varchar(32) DEFAULT NULL,
  `ip` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT current_timestamp(),
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  snow.log_login 的数据：~3 rows (大约)
DELETE FROM `log_login`;
/*!40000 ALTER TABLE `log_login` DISABLE KEYS */;
INSERT INTO `log_login` (`id`, `name`, `user_id`, `username`, `ip`, `create_time`, `status`) VALUES
	(1, '登陆日志', 1, 'admin', '1', '2019-03-17 15:05:52', 1),
	(2, '登陆日志', 1, 'admin', '0:0:0:0:0:0:0:1', '2019-03-17 15:22:57', 1),
	(3, '登陆日志', 1, 'admin', '0:0:0:0:0:0:0:1', '2019-03-17 15:23:13', 1);
/*!40000 ALTER TABLE `log_login` ENABLE KEYS */;

-- 导出  表 snow.sys_depart 结构
DROP TABLE IF EXISTS `sys_depart`;
CREATE TABLE IF NOT EXISTS `sys_depart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `level` int(1) DEFAULT NULL COMMENT '部门级别',
  `sort` tinyint(4) DEFAULT NULL,
  `del_flag` int(1) NOT NULL DEFAULT 0 COMMENT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- 正在导出表  snow.sys_depart 的数据：~8 rows (大约)
DELETE FROM `sys_depart`;
/*!40000 ALTER TABLE `sys_depart` DISABLE KEYS */;
INSERT INTO `sys_depart` (`id`, `parent_id`, `name`, `code`, `level`, `sort`, `del_flag`) VALUES
	(1, 0, '大公司', '1', NULL, 0, 0),
	(2, 1, '营销部', '2', NULL, 0, 0),
	(3, 1, '市场部', '2', NULL, 0, 0),
	(4, 1, '财务部', '2', NULL, 0, 0),
	(5, 2, '二级部门', '2', NULL, 0, 0),
	(6, 2, '2', '2', NULL, 0, 0),
	(7, 1, '一级部门', '2', NULL, 1, 0),
	(8, NULL, '营销部', NULL, NULL, 0, 0);
/*!40000 ALTER TABLE `sys_depart` ENABLE KEYS */;

-- 导出  表 snow.sys_dict 结构
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE IF NOT EXISTS `sys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '排序',
  `pid` int(11) DEFAULT NULL COMMENT '父级字典',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `code` varchar(255) DEFAULT NULL COMMENT '值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COMMENT='字典表';

-- 正在导出表  snow.sys_dict 的数据：~10 rows (大约)
DELETE FROM `sys_dict`;
/*!40000 ALTER TABLE `sys_dict` DISABLE KEYS */;
INSERT INTO `sys_dict` (`id`, `num`, `pid`, `name`, `tips`, `code`) VALUES
	(50, 0, 0, '性别', NULL, 'sys_sex'),
	(51, 1, 50, '男', NULL, '1'),
	(52, 2, 50, '女', NULL, '2'),
	(53, 0, 0, '状态', NULL, 'sys_state'),
	(54, 1, 53, '启用', NULL, '1'),
	(55, 2, 53, '禁用', NULL, '2'),
	(56, 0, 0, '账号状态', NULL, 'account_state'),
	(57, 1, 56, '启用', NULL, '1'),
	(58, 2, 56, '冻结', NULL, '2'),
	(59, 3, 56, '已删除', NULL, '3');
/*!40000 ALTER TABLE `sys_dict` ENABLE KEYS */;

-- 导出  表 snow.sys_menu 结构
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE IF NOT EXISTS `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT 0 COMMENT '父级id',
  `name` varchar(64) DEFAULT NULL,
  `url` varchar(64) DEFAULT '',
  `code` varchar(64) DEFAULT NULL,
  `type` char(3) DEFAULT '1',
  `sort` int(3) DEFAULT 0,
  `del_flag` int(255) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- 正在导出表  snow.sys_menu 的数据：~10 rows (大约)
DELETE FROM `sys_menu`;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` (`id`, `parent_id`, `name`, `url`, `code`, `type`, `sort`, `del_flag`) VALUES
	(1, 0, '系统管理', '1', 'sysManage', '1', 1, 0),
	(2, 1, '菜单管理', '/menu/index.html', 'menuManage', '1', 3, 0),
	(3, 0, '基础管理', '11', '1', '1', 2, 0),
	(4, 3, 'test', '11', 'test', '1', 0, 0),
	(5, 1, '用户管理', '/user/index.html', 'userManage', '1', 1, 0),
	(6, 1, '角色管理', '/role/index.html', 'roleManage', '1', 2, 0),
	(7, 1, '部门管理', '/depart/index.html', 'departManage', '1', 4, 0),
	(8, 2, '1', '1', '1', '1', 0, 0),
	(9, 1, '字典数据管理', '', NULL, '1', 5, 0),
	(10, 1, '用户部门', '/userDepart/index.html', '1', '1', 6, 0);
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;

-- 导出  表 snow.sys_role 结构
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE IF NOT EXISTS `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `code` varchar(32) NOT NULL,
  `sort` int(3) NOT NULL DEFAULT 0,
  `del_flag` int(1) NOT NULL DEFAULT 0 COMMENT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- 正在导出表  snow.sys_role 的数据：~16 rows (大约)
DELETE FROM `sys_role`;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` (`id`, `name`, `code`, `sort`, `del_flag`) VALUES
	(1, '超级管理员', 'supperAdmin', 1, 0),
	(2, '2', '4', 1, 0),
	(3, '2', '4', 1, 0),
	(4, '2', '4', 1, 0),
	(5, '2', '4', 1, 0),
	(6, '2', '4', 1, 0),
	(7, '2', '4', 1, 0),
	(8, '2', '4', 1, 0),
	(9, '2', '4', 1, 0),
	(10, '21', '41', 11, 1),
	(11, '12', '11', 1, 0),
	(12, '1', '1', 1, 0),
	(13, '12', '12', 12, 0),
	(14, '13', '13', 13, 0),
	(15, '12', '12', 12, 1),
	(16, '16', '16', 16, 1);
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;

-- 导出  表 snow.sys_role_menu 结构
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE IF NOT EXISTS `sys_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- 正在导出表  snow.sys_role_menu 的数据：~4 rows (大约)
DELETE FROM `sys_role_menu`;
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` (`id`, `role_id`, `menu_id`) VALUES
	(1, 1, 1),
	(2, 1, 2),
	(5, 1, 5),
	(6, 1, 6);
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;

-- 导出  表 snow.sys_user 结构
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE IF NOT EXISTS `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL,
  `nickname` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `del_flag` int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- 正在导出表  snow.sys_user 的数据：~12 rows (大约)
DELETE FROM `sys_user`;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`id`, `username`, `nickname`, `password`, `phone`, `email`, `del_flag`) VALUES
	(1, 'admin', '1111c111', '123456', '1abc11', '1abc', 0),
	(2, '2', '11', '123456', NULL, NULL, 0),
	(3, 'zhangsan', '张三', '123456', NULL, NULL, 0),
	(4, '4', '4', '123456', NULL, NULL, 0),
	(5, '5', '4', '123456', NULL, NULL, 0),
	(6, '6', '4', '123456', NULL, NULL, 0),
	(7, '7', '4', '123456', NULL, NULL, 0),
	(8, '8', '4', '123456', NULL, NULL, 0),
	(9, '9', '4', '123456', NULL, NULL, 0),
	(10, '10', '411', '123456', '111', NULL, 0),
	(11, '11', '4', '123456', NULL, NULL, 0),
	(12, '12', '4', '123456', NULL, NULL, 0);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;

-- 导出  表 snow.sys_user_depart 结构
DROP TABLE IF EXISTS `sys_user_depart`;
CREATE TABLE IF NOT EXISTS `sys_user_depart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `depart_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`user_id`,`depart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  snow.sys_user_depart 的数据：~0 rows (大约)
DELETE FROM `sys_user_depart`;
/*!40000 ALTER TABLE `sys_user_depart` DISABLE KEYS */;
INSERT INTO `sys_user_depart` (`id`, `user_id`, `depart_id`) VALUES
	(1, 1, 1);
/*!40000 ALTER TABLE `sys_user_depart` ENABLE KEYS */;

-- 导出  表 snow.sys_user_role 结构
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  snow.sys_user_role 的数据：~2 rows (大约)
DELETE FROM `sys_user_role`;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` (`id`, `user_id`, `role_id`) VALUES
	(1, 1, 1),
	(2, 1, 10);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
