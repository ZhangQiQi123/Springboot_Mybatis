/*
Navicat MySQL Data Transfer

Source Server         : springboot
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : mytest

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2019-01-08 16:47:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `resource_id` varchar(64) NOT NULL,
  `resource_name` varchar(100) DEFAULT NULL,
  `resource_type_id` int(11) DEFAULT NULL,
  `parmater_id` varchar(64) DEFAULT NULL,
  `resource_url` varchar(100) DEFAULT NULL,
  `icons` varchar(100) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------

-- ----------------------------
-- Table structure for resource_type
-- ----------------------------
DROP TABLE IF EXISTS `resource_type`;
CREATE TABLE `resource_type` (
  `resource_type_id` int(11) NOT NULL,
  `resource_type_name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`resource_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource_type
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(64) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '系统管理员', '2018-12-20 00:00:00', '2018-12-19 00:00:00', '系统管理员');
INSERT INTO `role` VALUES ('2', 'aaa', '2018-12-20 00:00:00', '2018-12-20 00:00:00', 'aaa');
INSERT INTO `role` VALUES ('3', 'aaa', '2018-12-20 10:44:33', '2018-12-20 10:44:33', 'aaa');

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource` (
  `role_resource_id` int(11) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `resource_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`role_resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_resource
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `price` decimal(10,4) DEFAULT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('10', 'admin', 'admin', '17612197279', '2018-12-10 17:00:00', '2018-12-20 13:05:14', '1000.0000', '1');
INSERT INTO `t_user` VALUES ('11', 'a', 'aaa', '17612197278', '2018-12-12 12:12:12', '2019-01-07 17:10:52', '1000.0000', '1');
INSERT INTO `t_user` VALUES ('14', 'bbb', 'bbb', '17612197279', '2018-12-10 09:22:06', '2018-12-20 08:05:20', '100.0000', '1');
INSERT INTO `t_user` VALUES ('17', 'ccc', 'ccc', '17612197279', '2018-12-12 00:12:12', '2018-12-20 13:05:24', '100.0000', '1');
INSERT INTO `t_user` VALUES ('18', 'zqq', 'zqq', '17271727272', '2018-12-11 10:05:27', '2018-12-20 13:05:27', '1223.0000', '1');
INSERT INTO `t_user` VALUES ('19', 'tuxu', 'tuxu', '17271727272', '2018-12-11 10:05:27', '2018-12-20 10:35:27', '1223.0000', '2');
