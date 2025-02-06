/*
 Navicat Premium Dump SQL

 Source Server         : localmysql
 Source Server Type    : MySQL
 Source Server Version : 80041 (8.0.41)
 Source Host           : localhost:3306
 Source Schema         : test3

 Target Server Type    : MySQL
 Target Server Version : 80041 (8.0.41)
 File Encoding         : 65001

 Date: 06/02/2025 11:18:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for caleg
-- ----------------------------
DROP TABLE IF EXISTS `caleg`;
CREATE TABLE `caleg`  (
  `id` bigint NOT NULL,
  `nama` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `nomor_urut` int NULL DEFAULT NULL,
  `dapil_id` bigint NULL DEFAULT NULL,
  `jenkel_id` bigint NULL DEFAULT NULL,
  `partai_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK8uw9i5b3r19t7jc7so7j38b2d`(`dapil_id` ASC) USING BTREE,
  INDEX `FKljq7ipqp119rt744m26gked3s`(`jenkel_id` ASC) USING BTREE,
  INDEX `FKqg42c9wafivbtyhufufkdha8b`(`partai_id` ASC) USING BTREE,
  CONSTRAINT `FK8uw9i5b3r19t7jc7so7j38b2d` FOREIGN KEY (`dapil_id`) REFERENCES `dapil` (`dapil_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKljq7ipqp119rt744m26gked3s` FOREIGN KEY (`jenkel_id`) REFERENCES `jenis_kelamin` (`jenkel_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKqg42c9wafivbtyhufufkdha8b` FOREIGN KEY (`partai_id`) REFERENCES `partai` (`partai_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of caleg
-- ----------------------------

-- ----------------------------
-- Table structure for caleg_seq
-- ----------------------------
DROP TABLE IF EXISTS `caleg_seq`;
CREATE TABLE `caleg_seq`  (
  `next_val` bigint NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of caleg_seq
-- ----------------------------
INSERT INTO `caleg_seq` VALUES (1);

-- ----------------------------
-- Table structure for dapil
-- ----------------------------
DROP TABLE IF EXISTS `dapil`;
CREATE TABLE `dapil`  (
  `dapil_id` bigint NOT NULL,
  `jumlah_kursi` int NULL DEFAULT NULL,
  `nama_dapil` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `provinsi` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`dapil_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dapil
-- ----------------------------

-- ----------------------------
-- Table structure for dapil_seq
-- ----------------------------
DROP TABLE IF EXISTS `dapil_seq`;
CREATE TABLE `dapil_seq`  (
  `next_val` bigint NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dapil_seq
-- ----------------------------
INSERT INTO `dapil_seq` VALUES (1);

-- ----------------------------
-- Table structure for jenis_kelamin
-- ----------------------------
DROP TABLE IF EXISTS `jenis_kelamin`;
CREATE TABLE `jenis_kelamin`  (
  `jenkel_id` bigint NOT NULL AUTO_INCREMENT,
  `nama` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` enum('LAKILAKI','PEREMPUAN') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`jenkel_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jenis_kelamin
-- ----------------------------

-- ----------------------------
-- Table structure for partai
-- ----------------------------
DROP TABLE IF EXISTS `partai`;
CREATE TABLE `partai`  (
  `partai_id` bigint NOT NULL,
  `nama_partai` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `nomor_urut` int NULL DEFAULT NULL,
  PRIMARY KEY (`partai_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of partai
-- ----------------------------

-- ----------------------------
-- Table structure for partai_seq
-- ----------------------------
DROP TABLE IF EXISTS `partai_seq`;
CREATE TABLE `partai_seq`  (
  `next_val` bigint NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of partai_seq
-- ----------------------------
INSERT INTO `partai_seq` VALUES (1);

SET FOREIGN_KEY_CHECKS = 1;
