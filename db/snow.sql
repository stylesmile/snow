/*
Navicat MySQL Data Transfer

Source Server         : 192.168.141.128_3309
Source Server Version : 80013
Source Host           : 192.168.141.128:3309
Source Database       : snow

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-01-30 22:42:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_depart
-- ----------------------------
DROP TABLE IF EXISTS `sys_depart`;
CREATE TABLE `sys_depart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `sort` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_depart
-- ----------------------------
INSERT INTO `sys_depart` VALUES ('1', null, '1', '1', null);

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '排序',
  `pid` int(11) DEFAULT NULL COMMENT '父级字典',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `code` varchar(255) DEFAULT NULL COMMENT '值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='字典表';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('50', '0', '0', '性别', null, 'sys_sex');
INSERT INTO `sys_dict` VALUES ('51', '1', '50', '男', null, '1');
INSERT INTO `sys_dict` VALUES ('52', '2', '50', '女', null, '2');
INSERT INTO `sys_dict` VALUES ('53', '0', '0', '状态', null, 'sys_state');
INSERT INTO `sys_dict` VALUES ('54', '1', '53', '启用', null, '1');
INSERT INTO `sys_dict` VALUES ('55', '2', '53', '禁用', null, '2');
INSERT INTO `sys_dict` VALUES ('56', '0', '0', '账号状态', null, 'account_state');
INSERT INTO `sys_dict` VALUES ('57', '1', '56', '启用', null, '1');
INSERT INTO `sys_dict` VALUES ('58', '2', '56', '冻结', null, '2');
INSERT INTO `sys_dict` VALUES ('59', '3', '56', '已删除', null, '3');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL COMMENT '父级id',
  `name` varchar(64) DEFAULT NULL,
  `url` varchar(64) DEFAULT NULL,
  `code` varchar(64) DEFAULT NULL,
  `parent_code` varchar(64) DEFAULT NULL,
  `type` int(3) DEFAULT NULL,
  `sort` int(3) DEFAULT NULL,
  `del_flag` int(255) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '系统管理', null, '11', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('2', '1', '菜单管理', null, '1', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('3', '0', '基础管理', null, null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('4', '3', 'test', null, 'test', null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('5', '1', '1', '1', '1', null, null, '1', '0');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sort` int(3) DEFAULT NULL,
  `del_flag` int(1) NOT NULL DEFAULT '0' COMMENT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', 'supperAdmin', '1', '0');
INSERT INTO `sys_role` VALUES ('10', '21', '41', '11', '1');
INSERT INTO `sys_role` VALUES ('11', '12', '11', '1', '0');
INSERT INTO `sys_role` VALUES ('12', '1', '1', '1', '0');
INSERT INTO `sys_role` VALUES ('13', '12', '12', '12', '0');
INSERT INTO `sys_role` VALUES ('14', '13', '13', '13', '0');
INSERT INTO `sys_role` VALUES ('15', '12', '12', '12', '1');
INSERT INTO `sys_role` VALUES ('16', '16', '16', '16', '1');
INSERT INTO `sys_role` VALUES ('2', '2', '4', '1', '0');
INSERT INTO `sys_role` VALUES ('3', '2', '4', '1', '0');
INSERT INTO `sys_role` VALUES ('4', '2', '4', '1', '0');
INSERT INTO `sys_role` VALUES ('5', '2', '4', '1', '0');
INSERT INTO `sys_role` VALUES ('6', '2', '4', '1', '0');
INSERT INTO `sys_role` VALUES ('7', '2', '4', '1', '0');
INSERT INTO `sys_role` VALUES ('8', '2', '4', '1', '0');
INSERT INTO `sys_role` VALUES ('9', '2', '4', '1', '0');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(255) DEFAULT NULL,
  `menu_id` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '1', '1');
INSERT INTO `sys_role_menu` VALUES ('2', '1', '2');
INSERT INTO `sys_role_menu` VALUES ('3', '1', '3');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(64) NOT NULL,
  `nickname` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `del_flag` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '1', '1111c111', '123456', '1abc11', '1abc', '1');
INSERT INTO `sys_user` VALUES ('10', '10', '411', '123456', '111', null, '0');
INSERT INTO `sys_user` VALUES ('11', '11', '4', '123456', null, null, '0');
INSERT INTO `sys_user` VALUES ('12', '12', '4', '123456', null, null, '1');
INSERT INTO `sys_user` VALUES ('2', '2', '11', '123456', null, null, '0');
INSERT INTO `sys_user` VALUES ('3', 'zhangsan', '张三', '123456', null, null, '0');
INSERT INTO `sys_user` VALUES ('4', '4', '4', '123456', null, null, '0');
INSERT INTO `sys_user` VALUES ('5', '5', '4', '123456', null, null, '0');
INSERT INTO `sys_user` VALUES ('6', '6', '4', '123456', null, null, '0');
INSERT INTO `sys_user` VALUES ('7', '7', '4', '123456', null, null, '0');
INSERT INTO `sys_user` VALUES ('8', '8', '4', '123456', null, null, '0');
INSERT INTO `sys_user` VALUES ('9', '9', '4', '123456', null, null, '0');

-- ----------------------------
-- Table structure for sys_user_depart
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_depart`;
CREATE TABLE `sys_user_depart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) NOT NULL,
  `depart_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`,`user_id`,`depart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_depart
-- ----------------------------
INSERT INTO `sys_user_depart` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` char(32) NOT NULL,
  `user_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `role_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('787dfd0dfe2649a08033a6042b524c9c', '1', '10');
INSERT INTO `sys_user_role` VALUES ('dfebd0ff8b984d8dbf91a925735b39a7', '1', '1');
