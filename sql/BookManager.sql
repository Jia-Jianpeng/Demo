/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : bookmanage

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2019-12-28 16:22:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `author` varchar(256) DEFAULT NULL,
  `price` varchar(256) DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '枪毙任老道', '大英雄王思文', '100￥', '0');
INSERT INTO `book` VALUES ('2', '论一个演员的自我修养', '斯坦尼斯拉夫斯基', '20.40￥', '0');
INSERT INTO `book` VALUES ('3', '采购与供应链管理', '刘宝红', '123', '0');

-- ----------------------------
-- Table structure for `ticket`
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `ticket` varchar(1024) DEFAULT NULL,
  `expired_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uid` (`user_id`),
  UNIQUE KEY `t` (`ticket`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ticket
-- ----------------------------
INSERT INTO `ticket` VALUES ('9', '1', '4687c1cfa5443a4f54a9b30a6fb0a55b7f74', '2020-03-28 15:33:36');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `email` varchar(256) DEFAULT '',
  `password` varchar(256) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'jia', 'jia@qq.com', 'A6907ACF5B337A322193F19B6698C867');
