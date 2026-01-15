/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.137.130
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : 192.168.137.130:3306
 Source Schema         : shop_pay

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 19/11/2025 13:28:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
CREATE DATABASE IF NOT EXISTS `shop_pay` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `shop_pay`;

-- ----------------------------
-- Table structure for pay_log
-- ----------------------------
DROP TABLE IF EXISTS `pay_log`;
CREATE TABLE `pay_log`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `status` int(255) NULL DEFAULT NULL COMMENT '支付状态',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息内容',
  `pay_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pay_log
-- ----------------------------
INSERT INTO `pay_log` VALUES ('1991010377697095681', 1, '支付成功', 'AAA', '2025-11-19 05:07:20');
INSERT INTO `pay_log` VALUES ('1991011600600952833', 1, '支付成功', 'AAA', '2025-11-19 05:12:11');

SET FOREIGN_KEY_CHECKS = 1;
