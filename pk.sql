/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : pk

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2018-03-26 16:40:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `car`
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `car_id` varchar(30) NOT NULL,
  `car_card` varchar(30) default NULL,
  `car_vin` varchar(50) default NULL,
  `buy_date` varchar(30) default NULL,
  `color` varchar(30) default NULL,
  `tonnage` varchar(30) default NULL,
  `car_state` varchar(30) default NULL,
  `remarks` longtext,
  `seq_num` int(11) default NULL,
  PRIMARY KEY  (`car_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('car_00001', '川A-420', '214', '2014-10-14', '红色', '10', '空闲', '测试车辆', '1');
INSERT INTO `car` VALUES ('car_00002', '川A-333', '224', '2014-10-08', '绿色', '8.5', '空闲', '测试', '2');

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `emp_id` varchar(255) NOT NULL,
  `type` varchar(30) default NULL,
  `name` varchar(30) default NULL,
  `telephone` varchar(30) default NULL,
  `if_duty` varchar(30) default NULL,
  `passwd` varchar(30) default NULL,
  `age` varchar(30) default NULL,
  `sex` varchar(30) default NULL,
  `address` varchar(200) default NULL,
  `emp_date` varchar(30) default NULL,
  `birthday` varchar(30) default NULL,
  `emp_role` varchar(30) default NULL,
  `status` varchar(30) default NULL,
  `last_modify` varchar(30) default NULL,
  `education` varchar(30) default NULL,
  `remarks` varchar(150) default NULL,
  `seq_num` int(11) default NULL,
  PRIMARY KEY  (`emp_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('111', '操作员', 'linlin', '13558690869', '是', '123456', null, '男', '成都', '2018-03-09', '1988-12-01', '管理员', '空闲', null, '研究生', '发发', '1');
INSERT INTO `employee` VALUES ('emp_00002', '操作员', 'xiaoming', '13908064703', '是', '123456', null, '女', '四川达州', '2018-03-17', '1997-10-16', '管理员', '空闲', null, '本科', '测试', '2');
INSERT INTO `employee` VALUES ('emp_00003', '驾驶员', '王司机', '15984103894', '是', '123456', null, '男', '四川南充哦！', '2018-03-01', '1995-10-25', '普通用户', '空闲', null, '初中', '测试！', '3');
INSERT INTO `employee` VALUES ('emp_00004', '驾驶员', '刘秀丽', '13558690869', '是', '123456', null, '女', '四川攀枝花', '2018-03-15', '1990-10-11', '普通用户', '空闲', null, '初中', '测试', '4');

-- ----------------------------
-- Table structure for `fee`
-- ----------------------------
DROP TABLE IF EXISTS `fee`;
CREATE TABLE `fee` (
  `id` int(11) NOT NULL,
  `fee_type` varchar(30) default NULL,
  `fee_standard` varchar(30) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fee
-- ----------------------------
INSERT INTO `fee` VALUES ('1', '天数计费', '1200');
INSERT INTO `fee` VALUES ('2', '公里计费', '10');
INSERT INTO `fee` VALUES ('3', '1公斤计费', '40');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` varchar(255) NOT NULL,
  `customer` varchar(30) default NULL,
  `customer_tel` varchar(30) default NULL,
  `accept_addr` varchar(30) default NULL,
  `accept_time` varchar(30) default NULL,
  `send_addr` varchar(30) default NULL,
  `send_time` varchar(30) default NULL,
  `driver` varchar(30) default NULL,
  `receive_time` varchar(30) default NULL,
  `goods` varchar(200) default NULL,
  `weight` varchar(255) default NULL,
  `volume` varchar(255) default NULL,
  `fee_type` varchar(30) default NULL,
  `fee_standard` varchar(30) default NULL,
  `pre_kilometer` varchar(30) default NULL,
  `pre_cost` varchar(30) default NULL,
  `rel_cost` varchar(255) default NULL,
  `rel_kilometer` varchar(30) default NULL,
  `num` varchar(30) default NULL,
  `status` varchar(30) default NULL,
  `total_items` int(11) default NULL,
  `remarks` varchar(150) default NULL,
  `operator` varchar(30) default NULL,
  `operate_time` varchar(30) default NULL,
  `car_card` varchar(30) default NULL,
  `seq_num` int(11) default NULL,
  `status1` varchar(30) default NULL,
  `status2` varchar(30) default NULL,
  `status3` varchar(30) default NULL,
  `status4` varchar(30) default NULL,
  `status5` varchar(30) default NULL,
  `time1` varchar(30) default NULL,
  `time2` varchar(30) default NULL,
  `time3` varchar(30) default NULL,
  `time4` varchar(30) default NULL,
  `time5` varchar(30) default NULL,
  PRIMARY KEY  (`order_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('order_00001', '双鱼林', '13558690869', '广东深圳', '2018-03-18', '成都二仙桥', '2018-03-20', 'emp_00003', '2018-03-21 17:15:32', '苹果5s手机', '', '', null, '标准1', '2000', '2000', '', '', '10', '已确认', '2', '', 'linlin', '', '川A-420', '1', '订单定制成功', '审核通过', '已派车', '运输途中', '等待确认', '2018-03-21 16:54:48', '2018-03-21 16:56:18', '2018-03-21 17:09:43', '2018-03-21 17:09:48', '2018-03-21 17:14:54');
INSERT INTO `orders` VALUES ('order_00002', '林大神', '13908064703', '四川成都', '2018-03-22', '云南昆明', '2018-03-24', 'emp_00004', '2018-03-24 1:20:43', '红富士苹果', '', '', null, '10', '100', '1000', '', '', '200', '已确认', '100', '', 'linlin', '', '川A-333', '2', '订单定制成功', '审核通过', '已派车', '运输途中', '等待确认', '2018-03-24 1:08:41', '2018-03-24 1:11:57', '2018-03-24 1:17:28', '2018-03-24 1:18:10', '2018-03-24 1:19:57');
