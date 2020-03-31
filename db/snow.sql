/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.233.130_3306
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : 192.168.233.130:3306
 Source Schema         : snow

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 31/03/2020 20:41:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for log_login
-- ----------------------------
DROP TABLE IF EXISTS `log_login`;
CREATE TABLE `log_login`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(0) NULL DEFAULT NULL,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `status` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log_login
-- ----------------------------
INSERT INTO `log_login` VALUES (1, '登陆日志', 1, 'admin', '1', '2019-03-17 15:05:52', 1);
INSERT INTO `log_login` VALUES (2, '登陆日志', 1, 'admin', '0:0:0:0:0:0:0:1', '2019-03-17 15:22:57', 1);
INSERT INTO `log_login` VALUES (3, '登陆日志', 1, 'admin', '0:0:0:0:0:0:0:1', '2019-03-17 15:23:13', 1);

-- ----------------------------
-- Table structure for sys_depart
-- ----------------------------
DROP TABLE IF EXISTS `sys_depart`;
CREATE TABLE `sys_depart`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `parent_id` int(0) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `level` int(0) NULL DEFAULT NULL COMMENT '部门级别',
  `sort` tinyint(0) NULL DEFAULT NULL,
  `del_flag` int(0) NOT NULL DEFAULT 0 COMMENT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_depart
-- ----------------------------
INSERT INTO `sys_depart` VALUES (1, 0, '大公司', '1', NULL, 0, 0);
INSERT INTO `sys_depart` VALUES (2, 1, '营销部', '2', NULL, 0, 0);
INSERT INTO `sys_depart` VALUES (3, 1, '市场部', '2', NULL, 0, 0);
INSERT INTO `sys_depart` VALUES (4, 1, '财务部', '2', NULL, 0, 0);
INSERT INTO `sys_depart` VALUES (5, 2, '二级部门', '2', NULL, 0, 0);
INSERT INTO `sys_depart` VALUES (6, 2, '2', '2', NULL, 0, 0);
INSERT INTO `sys_depart` VALUES (7, 1, '一级部门', '2', NULL, 1, 0);
INSERT INTO `sys_depart` VALUES (8, NULL, '营销部', NULL, NULL, 0, 0);

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(0) NULL DEFAULT NULL COMMENT '排序',
  `pid` int(0) NULL DEFAULT NULL COMMENT '父级字典',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `tips` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '提示',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 69 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES (50, 0, 0, '性别', NULL, 'sys_sex');
INSERT INTO `sys_dict` VALUES (51, 1, 50, '男', NULL, '1');
INSERT INTO `sys_dict` VALUES (52, 2, 50, '女', NULL, '2');
INSERT INTO `sys_dict` VALUES (53, 0, 0, '状态', NULL, 'sys_state');
INSERT INTO `sys_dict` VALUES (54, 1, 53, '启用', NULL, '1');
INSERT INTO `sys_dict` VALUES (55, 2, 53, '禁用', NULL, '2');
INSERT INTO `sys_dict` VALUES (56, 0, 0, '账号状态', NULL, 'account_state');
INSERT INTO `sys_dict` VALUES (57, 1, 56, '启用', NULL, '1');
INSERT INTO `sys_dict` VALUES (58, 2, 56, '冻结', NULL, '2');
INSERT INTO `sys_dict` VALUES (59, 3, 56, '已删除', NULL, '3');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `parent_id` int(0) NULL DEFAULT 0 COMMENT '父级id',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1',
  `sort` int(0) NULL DEFAULT 0,
  `del_flag` int(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '系统管理', '1', 'sysManage', '1', 1, 0);
INSERT INTO `sys_menu` VALUES (2, 1, '菜单管理', '/menu/index.html', 'menuManage', '1', 3, 0);
INSERT INTO `sys_menu` VALUES (3, 0, '基础管理', '11', '1', '1', 2, 0);
INSERT INTO `sys_menu` VALUES (4, 3, 'test', '11', 'test', '1', 0, 0);
INSERT INTO `sys_menu` VALUES (5, 1, '用户管理', '/user/index.html', 'userManage', '1', 1, 0);
INSERT INTO `sys_menu` VALUES (6, 1, '角色管理', '/role/index.html', 'roleManage', '1', 2, 0);
INSERT INTO `sys_menu` VALUES (7, 1, '部门管理', '/depart/index.html', 'departManage', '1', 4, 0);
INSERT INTO `sys_menu` VALUES (8, 2, '1', '1', '1', '1', 0, 0);
INSERT INTO `sys_menu` VALUES (9, 1, '字典数据管理', '', NULL, '1', 5, 0);
INSERT INTO `sys_menu` VALUES (10, 1, '用户部门', '/userDepart/index.html', '1', '1', 6, 0);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sort` int(0) NOT NULL DEFAULT 0,
  `del_flag` int(0) NOT NULL DEFAULT 0 COMMENT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', 'supperAdmin', 1, 0);
INSERT INTO `sys_role` VALUES (2, '2', '4', 1, 0);
INSERT INTO `sys_role` VALUES (3, '2', '4', 1, 0);
INSERT INTO `sys_role` VALUES (4, '2', '4', 1, 0);
INSERT INTO `sys_role` VALUES (5, '2', '4', 1, 0);
INSERT INTO `sys_role` VALUES (6, '2', '4', 1, 0);
INSERT INTO `sys_role` VALUES (7, '2', '4', 1, 0);
INSERT INTO `sys_role` VALUES (8, '2', '4', 1, 0);
INSERT INTO `sys_role` VALUES (9, '2', '4', 1, 0);
INSERT INTO `sys_role` VALUES (10, '21', '41', 11, 1);
INSERT INTO `sys_role` VALUES (11, '12', '11', 1, 0);
INSERT INTO `sys_role` VALUES (12, '1', '1', 1, 0);
INSERT INTO `sys_role` VALUES (13, '12', '12', 12, 0);
INSERT INTO `sys_role` VALUES (14, '13', '13', 13, 0);
INSERT INTO `sys_role` VALUES (15, '12', '12', 12, 1);
INSERT INTO `sys_role` VALUES (16, '16', '16', 16, 1);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `role_id` int(0) NOT NULL,
  `menu_id` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1, 1);
INSERT INTO `sys_role_menu` VALUES (2, 1, 2);
INSERT INTO `sys_role_menu` VALUES (5, 1, 5);
INSERT INTO `sys_role_menu` VALUES (6, 1, 6);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nickname` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `del_flag` int(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '管理员', '123456', '1abc11', '1abc', 0);
INSERT INTO `sys_user` VALUES (2, 'test2', '测试2', '123456', NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (3, 'zhangsan', '张三', '123456', NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (4, '4', '4', '123456', NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (5, '5', '4', '123456', NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (6, '6', '4', '123456', NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (7, '7', '4', '123456', NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (8, '8', '4', '123456', NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (9, '9', '4', '123456', NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (10, '10', '411', '123456', '111', NULL, 0);
INSERT INTO `sys_user` VALUES (11, '11', '4', '123456', NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (12, '12', '4', '123456', NULL, NULL, 0);

-- ----------------------------
-- Table structure for sys_user_depart
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_depart`;
CREATE TABLE `sys_user_depart`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NOT NULL,
  `depart_id` int(0) NOT NULL,
  PRIMARY KEY (`id`, `user_id`, `depart_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_depart
-- ----------------------------
INSERT INTO `sys_user_depart` VALUES (1, 1, 1);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NOT NULL,
  `role_id` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, 1);
INSERT INTO `sys_user_role` VALUES (2, 1, 10);

SET FOREIGN_KEY_CHECKS = 1;
