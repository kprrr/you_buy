/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : you_buy

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2015-09-01 16:20:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
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
-- Table structure for region
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
-- Table structure for sites
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
INSERT INTO `sites` VALUES ('8b897b70323a7a67bf97a1e81f0e4bf6', '1', '2', '', '3', '', '', '4', '', '4', '2015-09-01 15:26:36', '1');
INSERT INTO `sites` VALUES ('e21646dd86b015f2ded24e3f6e42bec4', '场馆2', '3', 'http://localhost:80/upload/1441092321792.png', '4', '5', '5', '13969874586', '324.15', '567.22', '2015-09-01 15:25:33', '1');
