/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : you_buy

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2015-09-26 16:32:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `activity`
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` varchar(32) NOT NULL,
  `activity_type` int(11) DEFAULT NULL,
  `isotherpay` int(11) DEFAULT NULL,
  `activity_name` varchar(32) DEFAULT NULL,
  `activity_longitude` float DEFAULT NULL,
  `acitivity_latitude` float DEFAULT NULL,
  `site_city` varchar(32) DEFAULT NULL,
  `site_name` varchar(32) DEFAULT NULL,
  `site_address` varchar(100) DEFAULT NULL,
  `starttime` varchar(32) DEFAULT NULL,
  `lasttime` int(11) DEFAULT NULL,
  `deadline` varchar(32) DEFAULT NULL,
  `signed_num` int(11) DEFAULT NULL,
  `limit_num` int(11) DEFAULT NULL,
  `create_userid` varchar(32) DEFAULT NULL,
  `activity_status` int(11) DEFAULT NULL,
  `shared_times` int(11) DEFAULT NULL,
  `createtime` varchar(32) DEFAULT NULL,
  `isdelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('825831efcb035ed03beb4e671e102d62', null, null, null, '324.15', '567.22', null, '阿萨德1', null, null, null, null, null, null, '1', '0', '0', null, '1');
INSERT INTO `activity` VALUES ('947cf6ed414148ab917c2af7a40134c9', null, null, null, '324.15', '567.22', null, '阿萨德1', null, null, null, null, null, null, '1', '0', '0', '2015-09-26 16:18:35', '1');

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` varchar(32) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `isdelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '123', '1');

-- ----------------------------
-- Table structure for `collects`
-- ----------------------------
DROP TABLE IF EXISTS `collects`;
CREATE TABLE `collects` (
  `id` varchar(32) NOT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  `activity_id` varchar(32) DEFAULT NULL,
  `site_name` varchar(100) DEFAULT NULL,
  `site_address` varchar(100) DEFAULT NULL,
  `distance` int(11) DEFAULT NULL,
  `activity_starttime` varchar(32) DEFAULT NULL,
  `signup_num` int(11) DEFAULT NULL,
  `createtime` varchar(32) DEFAULT NULL,
  `isdelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collects
-- ----------------------------

-- ----------------------------
-- Table structure for `comments`
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `id` varchar(32) NOT NULL,
  `activity_id` varchar(32) DEFAULT NULL,
  `commentator_id` varchar(32) DEFAULT NULL,
  `commentator_name` varchar(32) DEFAULT NULL,
  `commentator_photo` varchar(100) DEFAULT NULL,
  `content` varchar(100) DEFAULT NULL,
  `isreply` int(11) DEFAULT NULL,
  `recevier_id` varchar(32) DEFAULT NULL,
  `receiver_name` varchar(32) DEFAULT NULL,
  `createtime` varchar(32) DEFAULT NULL,
  `isdelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comments
-- ----------------------------

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` varchar(32) NOT NULL,
  `sender_id` varchar(32) DEFAULT NULL,
  `receiver_id` varchar(32) DEFAULT NULL,
  `content` varchar(100) DEFAULT NULL,
  `issystem` int(11) DEFAULT NULL,
  `createtime` varchar(32) DEFAULT NULL,
  `isdelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for `region`
-- ----------------------------
DROP TABLE IF EXISTS `region`;
CREATE TABLE `region` (
  `super_region_id` int(11) DEFAULT NULL,
  `region_id` int(11) NOT NULL,
  `region_name` varchar(32) DEFAULT NULL,
  `isdelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`region_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of region
-- ----------------------------
INSERT INTO `region` VALUES (null, '1', '京口区', '1');
INSERT INTO `region` VALUES (null, '2', '润州区', '1');
INSERT INTO `region` VALUES (null, '3', '丹徒区', '1');
INSERT INTO `region` VALUES (null, '4', '丹阳市', '1');
INSERT INTO `region` VALUES (null, '5', '扬中市', '1');
INSERT INTO `region` VALUES (null, '6', '句容市', '1');

-- ----------------------------
-- Table structure for `signup`
-- ----------------------------
DROP TABLE IF EXISTS `signup`;
CREATE TABLE `signup` (
  `id` varchar(32) NOT NULL,
  `activity_id` varchar(32) DEFAULT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  `site_name` varchar(32) DEFAULT NULL,
  `site_address` varchar(32) DEFAULT NULL,
  `distance` int(11) DEFAULT NULL,
  `activity_starttime` varchar(32) DEFAULT NULL,
  `signup_num` int(11) DEFAULT NULL,
  `createtime` varchar(32) DEFAULT NULL,
  `isdelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of signup
-- ----------------------------

-- ----------------------------
-- Table structure for `signup_num`
-- ----------------------------
DROP TABLE IF EXISTS `signup_num`;
CREATE TABLE `signup_num` (
  `id` varchar(32) DEFAULT NULL,
  `activity_id` varchar(32) DEFAULT NULL,
  `活动人数上限` int(11) DEFAULT NULL,
  `limit_num` int(11) DEFAULT NULL,
  `createtime` varchar(32) DEFAULT NULL,
  `isdelete` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of signup_num
-- ----------------------------

-- ----------------------------
-- Table structure for `sites`
-- ----------------------------
DROP TABLE IF EXISTS `sites`;
CREATE TABLE `sites` (
  `id` varchar(32) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `img` varchar(100) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `place` varchar(200) DEFAULT NULL,
  `region_id` varchar(32) DEFAULT NULL,
  `tel` varchar(11) DEFAULT NULL,
  `longitude` varchar(32) DEFAULT NULL,
  `latitude` varchar(32) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT NULL,
  `isdetele` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sites
-- ----------------------------
INSERT INTO `sites` VALUES ('e21646dd86b015f2ded24e3f6e42bec4', '阿萨德1', '3', 'http://127.0.0.1:80/upload/1441458344550.jpg', '4', '5', '5', '13969874586', '324.15', '567.22', '2015-09-01 15:25:33', '1');

-- ----------------------------
-- Table structure for `wxuser`
-- ----------------------------
DROP TABLE IF EXISTS `wxuser`;
CREATE TABLE `wxuser` (
  `id` varchar(32) NOT NULL,
  `wxId` varchar(32) DEFAULT NULL,
  `nickname` varchar(32) DEFAULT NULL,
  `photo` varchar(32) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `registtime` varchar(32) DEFAULT NULL,
  `wxuser_address` varchar(100) DEFAULT NULL,
  `signature` varchar(100) DEFAULT NULL,
  `wxuser_longitude` varchar(32) DEFAULT NULL,
  `wxuser_latitude` varchar(32) DEFAULT NULL,
  `tel` varchar(11) DEFAULT NULL,
  `createtime` varchar(32) DEFAULT NULL,
  `isdelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wxuser
-- ----------------------------
INSERT INTO `wxuser` VALUES ('1', '1', '系统', null, '1', '20', null, '江苏省南京市龙台国际1516', '我的未来式我做主', '32.1586610000', '119.4281740000', '13952087941', null, '1');
