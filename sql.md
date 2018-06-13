/*
Navicat MySQL Data Transfer

Source Server         : wangcm
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2018-06-06 15:30:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL COMMENT '主键',
  `express_str` varchar(255) DEFAULT NULL COMMENT '计算公式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', 'if x>11:\r\n    print(\'x>11\')\r\nelif x<11:\r\n    print(\'x<11\')\r\nelse: \r\n    print(\'x=11\')\r\nprint(\'     success\')');
INSERT INTO `test` VALUES ('2', 'if (x+y+z+k+l)>1000:\r\n    print (\'not\')\r\nelif (x+y+z+k+l)>110:\r\n    print(\'ok\')\r\nelse: \r\n    print(\'not\')\r\nprint(\'     success\')');
INSERT INTO `test` VALUES ('3', 'if (x+y+z+k+l)>1000:\r\n    print (\'not\')\r\nelif (x+y+z+k+l)>900:\r\n    print(\'not\')\r\nelif ((x*y*z*k*l+20-22)/2)==5999999:\r\n    print(\'ok\')\r\nelse: \r\n    print(\'not\')\r\nprint(\'     success\')');
