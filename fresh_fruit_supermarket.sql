/*
 Navicat Premium Data Transfer

 Source Server         : TT
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : localhost:3306
 Source Schema         : rongxiaotong

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 27/10/2023 14:56:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for my_product
-- ----------------------------
DROP TABLE IF EXISTS `my_product`;
CREATE TABLE `my_product`  (
  `my_product_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '产品',
  `my_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `pname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '产品名称',
  `pprice` decimal(10, 2) DEFAULT NULL COMMENT '产品价格',
  `zh_price` decimal(10, 2) DEFAULT NULL COMMENT '折后价格',
  `pro_count` int(10) DEFAULT NULL COMMENT '产品库存',
  `pro_sale_count` int(10) DEFAULT NULL COMMENT '总销售数量',
  `img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '产品标题图片',
  `deleted` smallint(1) DEFAULT 0 COMMENT '0',
  PRIMARY KEY (`my_product_id`) USING BTREE,
  INDEX `ssfsdfdsf`(`my_user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for my_user
-- ----------------------------
DROP TABLE IF EXISTS `my_user`;
CREATE TABLE `my_user`  (
  `my_user_id` bigint(16) NOT NULL AUTO_INCREMENT COMMENT '用户表',
  `utype` smallint(1) DEFAULT NULL COMMENT '1买家  2农民 3专家  4银行用户',
  `uname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '姓名',
  `sex` smallint(1) DEFAULT NULL COMMENT '性别 1男 2女',
  `phone` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '电话',
  `login_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '登录名',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
  `deleted` smallint(1) DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`my_user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_address
-- ----------------------------
DROP TABLE IF EXISTS `tb_address`;
CREATE TABLE `tb_address`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收货地址',
  `own_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '属于哪个用户的地址',
  `consignee` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货电话',
  `address_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货地址',
  `is_default` tinyint(4) DEFAULT 0 COMMENT '是否默认，0，不是，默认是1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 205 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_address
-- ----------------------------
INSERT INTO `tb_address` VALUES (121, 'zwr', '张文瑞', '15030589961', '青岛市即墨区青岛湾琴湾C区', 1);
INSERT INTO `tb_address` VALUES (129, 'zhangxukun', '张绪昆', '18354648787', '山东省青岛市', 0);
INSERT INTO `tb_address` VALUES (146, 'zhangxu', '张绪昆', '18396833008', '山东省青岛市', 0);
INSERT INTO `tb_address` VALUES (147, 'zhangxukun', '张绪昆', '18354648787', '山东省济南市', 1);
INSERT INTO `tb_address` VALUES (153, 'gaoge', '高歌', '18977771439', '山东省枣庄市', 0);
INSERT INTO `tb_address` VALUES (154, 'gaoge', '高歌', '18977771439', '山东省德州市夏津县', 1);
INSERT INTO `tb_address` VALUES (171, 'gaoge', '高歌', '18977771439', '山东省德州市夏津县', 0);
INSERT INTO `tb_address` VALUES (172, 'admin', '成吉思汗', '18766661438', '山东青岛市崂山区', 1);
INSERT INTO `tb_address` VALUES (173, 'admin', '不朽大帝', '18766661438', '山东青岛市崂山区', 0);
INSERT INTO `tb_address` VALUES (178, 'lzh', '11', '11', '11', 1);
INSERT INTO `tb_address` VALUES (184, 'wyn3', '李增虎', '11111111111', '海信财智谷', 0);
INSERT INTO `tb_address` VALUES (186, 'lisi', '李四', '15623652365', '山东省临沂市河东区', 0);
INSERT INTO `tb_address` VALUES (187, 'lisi', '李四', '15623652365', '山东省青岛市崂山区', 1);
INSERT INTO `tb_address` VALUES (188, 'lisi', '李四', '15662352365', '山东省青岛市黄岛区', 0);
INSERT INTO `tb_address` VALUES (189, 'wangya', '王娅', '13792449255', '青岛市李沧区', 0);
INSERT INTO `tb_address` VALUES (190, 'admin001', 'aaa', '15266884488', 'aaa', 0);
INSERT INTO `tb_address` VALUES (191, 'aaaaaa', 'aaaaa', '12312312312312', '北京市朝阳区大苏打撒旦', 1);
INSERT INTO `tb_address` VALUES (193, 'hh1', 'ER', '12321', '广西桂林', 1);
INSERT INTO `tb_address` VALUES (199, 'hh1', '王多鱼', '3287975734', '广西桂林', 0);
INSERT INTO `tb_address` VALUES (200, 'hh1', '王多鱼', '3287975734', '广西桂林', 0);

-- ----------------------------
-- Table structure for tb_bank
-- ----------------------------
DROP TABLE IF EXISTS `tb_bank`;
CREATE TABLE `tb_bank`  (
  `bank_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '银行',
  `bank_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '\r\n介绍',
  `bank_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `money` decimal(65, 2) NOT NULL COMMENT '资产',
  `rate` decimal(65, 2) NOT NULL COMMENT '利率',
  `repayment` int(11) NOT NULL COMMENT '债务',
  PRIMARY KEY (`bank_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1011 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '银行表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_bank
-- ----------------------------
INSERT INTO `tb_bank` VALUES (1001, '青岛银行', '“青易贷”，是青岛银行小微企业融资产品服务品牌。为助力小微企业成长发展，青岛银行为广大小微企业打造全面金融服务品牌体系——“青易贷”，紧贴小微企业融资需求特点，紧跟市场经济发展变化，不断创新完善融资产品，形成特色产品体系，力争全方位地满足不同行业、不同成长阶段的小微企业各类融资需求。', '96588', 100000.00, 1.10, 24);
INSERT INTO `tb_bank` VALUES (1002, '中国银行', '中国银行金融市场业务，包括国内、国际本外币金融市场相关交易、投资、理财、托管等业务，为公司、个人以及金融同业提供全面、完善、专业的各项金融市场服务。', '95566', 100000.00, 1.20, 36);
INSERT INTO `tb_bank` VALUES (1004, '中国工商银行', '工商银行向小微企业主发放的，用于满足其生产经营资金需求或置换生产经营过程中产生的负债性资金的人民币贷款。', '95588', 150000.00, 1.10, 30);
INSERT INTO `tb_bank` VALUES (1005, '日照银行', '“阳光”系列个人消费贷款业务是日照银行向符合规定条件的自然人发放的用于个人消费用途的人民币贷款业务，旨在以快捷方便的审批流程和优质的服务满足客户在大件商品或服务消费等个人资金需求，如住房装修、购家具家电、购车、婚庆、学习进修、旅游等。“阳光”系列个人消费贷款业务包含“阳光贷”、“金领贷”、“阳光·房易贷”、“阳光·保易贷”、“阳光·车易贷”“阳光·出国贷”等。', '96588', 100000.00, 2.00, 24);
INSERT INTO `tb_bank` VALUES (1006, '华夏银行', '华夏银行作为债务融资工具全国首批主承销商之一，已从业十余载，连续十三年获“全国银行间同业拆借中心优秀交易成员”称号，承销团队经验丰富，专业高效，竭诚为广大企业服务。', '95577', 160000.00, 1.80, 36);
INSERT INTO `tb_bank` VALUES (1007, '中国建设银行', '“诚贷通”小额无抵押贷款“诚贷通”小额无抵押贷款是建设银行为小企业客户发放，由企业主或企业实际控制人提供个人连带责任保证，无需抵（质）押物，用于小企业客户生产经营资金周转的人民币循环额度贷款。', '95533', 200000.00, 3.60, 36);
INSERT INTO `tb_bank` VALUES (1008, '浦发银行', '点贷是我行面向符合条件的客户通过互联网在线受理、在线签约，并即时发放贷款的业务模式。', '95528', 150000.00, 1.10, 24);
INSERT INTO `tb_bank` VALUES (1009, '中国平安银行', '“数保贷”平安银行与担保公司、担保基金、保险公司等联合开发的面向诚信纳税的中小企业法人或企业主的互联网信用贷款', '95511', 160000.00, 1.20, 36);
INSERT INTO `tb_bank` VALUES (1010, '中国民生银行', '为进一步丰富金融服务乡村振兴的内涵，民生银行在持续迭代“农贷通”产品的基础上，通过与中国银联强强联合，将借记卡产品与贷款产品相融合，以科技赋能，将现代金融服务延伸到广大农村区域。“农贷通”卡满载10项特色涉农权益，为农户提供多样化增值服务。', '95568', 200000.00, 1.60, 24);

-- ----------------------------
-- Table structure for tb_bank_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_bank_user`;
CREATE TABLE `tb_bank_user`  (
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录名',
  `bank_id` int(11) NOT NULL COMMENT '银行',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_name`) USING BTREE,
  INDEX `bank_id`(`bank_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '银行用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_bank_user
-- ----------------------------
INSERT INTO `tb_bank_user` VALUES ('buser01', 1001, '$2a$10$Kje9qsCRrPA8/RAZN3j1teMM.Vfn9AaI7kh95mbVwAT/yY.3EZKxi', '王家明', '13236963696', 'user', '2022-04-02 16:19:10', '2022-04-02 16:19:13');
INSERT INTO `tb_bank_user` VALUES ('buser02', 1006, '$2a$10$Kje9qsCRrPA8/RAZN3j1teMM.Vfn9AaI7kh95mbVwAT/yY.3EZKxi', '刘璐', '13236963696', 'user', '2022-04-02 16:19:10', '2022-04-02 16:19:13');
INSERT INTO `tb_bank_user` VALUES ('buser03', 1001, '$2a$10$Kje9qsCRrPA8/RAZN3j1teMM.Vfn9AaI7kh95mbVwAT/yY.3EZKxi', '李涵', '13236963696', 'user', '2022-04-02 16:19:10', '2022-04-02 16:19:13');

-- ----------------------------
-- Table structure for tb_discuss
-- ----------------------------
DROP TABLE IF EXISTS `tb_discuss`;
CREATE TABLE `tb_discuss`  (
  `discuss_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '知识讨论表',
  `knowledge_id` int(11) NOT NULL COMMENT '知识',
  `own_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论者',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `create_time` datetime(0) NOT NULL COMMENT '时间',
  PRIMARY KEY (`discuss_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 130 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_discuss
-- ----------------------------
INSERT INTO `tb_discuss` VALUES (100, 100, 'wyn', '评论内容123', '2022-03-29 14:35:06');
INSERT INTO `tb_discuss` VALUES (101, 22, 'zhangxukun', '1111', '2022-07-22 09:56:49');
INSERT INTO `tb_discuss` VALUES (102, 22, 'admin', '22', '2022-07-29 14:59:21');
INSERT INTO `tb_discuss` VALUES (103, 22, 'admin', '44444444', '2022-07-29 15:31:06');
INSERT INTO `tb_discuss` VALUES (104, 22, 'wyn3', '22', '2022-08-19 16:09:12');
INSERT INTO `tb_discuss` VALUES (105, 23, 'gaoge', '不错不错', '2022-08-31 16:24:10');
INSERT INTO `tb_discuss` VALUES (106, 23, 'gaoge', '学到了，感谢！', '2022-08-31 16:24:18');
INSERT INTO `tb_discuss` VALUES (107, 23, 'gaoge', '长知识了', '2022-08-31 16:26:02');
INSERT INTO `tb_discuss` VALUES (108, 22, 'wyn3', '太简单', '2022-09-06 16:19:37');
INSERT INTO `tb_discuss` VALUES (109, 22, 'admin', '123123', '2023-09-27 14:25:51');
INSERT INTO `tb_discuss` VALUES (110, 22, 'admin', '11', '2023-09-27 14:27:38');
INSERT INTO `tb_discuss` VALUES (111, 22, 'admin', '很好！', '2023-09-27 14:27:42');
INSERT INTO `tb_discuss` VALUES (112, 22, 'admin', '211111', '2023-09-27 14:31:48');
INSERT INTO `tb_discuss` VALUES (113, 22, 'admin', '1111', '2023-09-27 14:32:24');
INSERT INTO `tb_discuss` VALUES (114, 22, 'admin', '666', '2023-09-27 14:32:31');
INSERT INTO `tb_discuss` VALUES (115, 33, 'admin', '6', '2023-09-27 14:32:55');
INSERT INTO `tb_discuss` VALUES (116, 22, 'admin', 'qq', '2023-09-27 14:43:03');
INSERT INTO `tb_discuss` VALUES (117, 22, 'gaoge', '会走路吗', '2023-09-27 14:48:28');
INSERT INTO `tb_discuss` VALUES (118, 22, 'admin', 'dasd', '2023-09-27 15:08:20');
INSERT INTO `tb_discuss` VALUES (119, 22, 'admin', 'rrttrtertrrrrr', '2023-09-27 15:26:56');
INSERT INTO `tb_discuss` VALUES (120, 26, 'admin', '666', '2023-09-27 15:27:52');
INSERT INTO `tb_discuss` VALUES (121, 22, 'admin', '1111111111', '2023-09-27 15:53:53');
INSERT INTO `tb_discuss` VALUES (122, 22, 'admin', '好好好', '2023-09-27 17:24:44');
INSERT INTO `tb_discuss` VALUES (123, 22, 'admin', '121212', '2023-09-27 17:25:05');
INSERT INTO `tb_discuss` VALUES (124, 33, 'aaaaaa', '6', '2023-09-27 17:36:19');
INSERT INTO `tb_discuss` VALUES (125, 22, 'admin', 'ppp', '2023-10-16 15:02:26');
INSERT INTO `tb_discuss` VALUES (126, 24, 'admin', '222312', '2023-10-16 15:05:43');
INSERT INTO `tb_discuss` VALUES (127, 23, 'oo', '学到了', '2023-10-16 16:04:43');
INSERT INTO `tb_discuss` VALUES (128, 25, 'hh1', '12123', '2023-10-17 16:58:46');
INSERT INTO `tb_discuss` VALUES (129, 22, 'aaaaaa', '很有用', '2023-10-20 21:52:25');

-- ----------------------------
-- Table structure for tb_expert
-- ----------------------------
DROP TABLE IF EXISTS `tb_expert`;
CREATE TABLE `tb_expert`  (
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录名 专家',
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `profession` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职业',
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职位',
  `belong` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '属于',
  PRIMARY KEY (`user_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '专家' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_expert
-- ----------------------------
INSERT INTO `tb_expert` VALUES ('gaoge', '高歌', '15649599256', '生物学1', '高级职称', '山东省农科院');
INSERT INTO `tb_expert` VALUES ('wdy', '王多鱼1', '1454654123', '农业科学', '高级工程师', '广东省农科院');
INSERT INTO `tb_expert` VALUES ('wyn', '王玉娜', '17892322499', '生物化学', '高级工程师', '青岛生物研究所');
INSERT INTO `tb_expert` VALUES ('wyn2', '王艳安', '13192924932', '生物化学', '高级工程师', '青岛生物研究所');

-- ----------------------------
-- Table structure for tb_finance
-- ----------------------------
DROP TABLE IF EXISTS `tb_finance`;
CREATE TABLE `tb_finance`  (
  `finance_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '金融融资',
  `bank_id` int(11) NOT NULL COMMENT '银行',
  `own_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录名',
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓名',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话',
  `id_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '编码',
  `status` int(11) NOT NULL COMMENT '状态',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `money` decimal(65, 2) NOT NULL,
  `rate` decimal(65, 2) NOT NULL,
  `repayment` int(11) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  `combination_name1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `combination_phone1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `combination_idnum1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `combination_name2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `combination_phone2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `combination_idnum2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `file_info` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  PRIMARY KEY (`finance_id`) USING BTREE,
  INDEX `bank_id`(`bank_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 148 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_finance
-- ----------------------------
INSERT INTO `tb_finance` VALUES (100, 1001, 'wyn', '王亚楠', '22222222222', '222222222222222222', 1, 're', 100.00, 12.00, 1, '2022-03-28 17:14:32', '2022-03-28 17:14:36', NULL, NULL, NULL, NULL, '', '', 'dd4f92b790dc4f36964888c98169ce66.jpg');
INSERT INTO `tb_finance` VALUES (102, 1001, 'wyn', '王亚楠', '22222222222', '222222222222222222', 2, 're', 109.00, 12.00, 1, '2022-03-28 17:14:32', '2022-03-28 17:14:36', NULL, NULL, NULL, NULL, '', '', 'dd4f92b790dc4f36964888c98169ce66.jpg');
INSERT INTO `tb_finance` VALUES (103, 1004, 'zhangxukun', '张旭坤', '22222222222', '222222222222222222', 0, NULL, 160000.00, 1.80, 36, '2022-07-22 09:59:12', '2022-07-22 09:59:12', '张龙', NULL, NULL, '赵虎', '22222222222', '222222222222222222', 'dd4f92b790dc4f36964888c98169ce66.jpg');
INSERT INTO `tb_finance` VALUES (104, 1006, 'zhangxukun', '张旭坤', '13176879739', '370827199001142213', 2, NULL, 150000.00, 1.10, 30, '2022-07-22 10:02:04', '2022-07-22 10:02:04', NULL, NULL, NULL, NULL, '', '', 'dd4f92b790dc4f36964888c98169ce66.jpg 45f9675d11a34dd3a6df296b8bc4b7e5.jpg dd4f92b790dc4f36964888c98169ce66.jpg dd4f92b790dc4f36964888c98169ce66.jpg dd4f92b790dc4f36964888c98169ce66.jpg');
INSERT INTO `tb_finance` VALUES (105, 1005, 'zhangxukun', '张旭坤', '22222222222', '222222222222222222', 0, NULL, 100000.00, 2.00, 24, '2022-07-22 10:02:29', '2022-07-22 10:02:29', NULL, NULL, NULL, NULL, '', '', 'dd4f92b790dc4f36964888c98169ce66.jpg');
INSERT INTO `tb_finance` VALUES (106, 1004, 'zhangxukun', '张旭坤', '22222222222', '222222222222222222', 0, NULL, 150000.00, 1.10, 30, '2022-07-22 10:26:02', '2022-07-22 10:26:02', NULL, NULL, NULL, NULL, '', '', 'dd4f92b790dc4f36964888c98169ce66.jpg');
INSERT INTO `tb_finance` VALUES (133, 1006, 'lzh', '李增虎', '15621367568', '373312199801032719', 2, NULL, 60000.00, 1.00, 6, '2022-08-17 17:18:14', '2022-08-17 17:18:14', '冯德林', '22222222222', '222222222222222222', '李思', '22222222222', '222222222222222222', 'dd4f92b790dc4f36964888c98169ce66.jpg');
INSERT INTO `tb_finance` VALUES (137, 1007, 'lisi', '李思', '15623652365', '371323199601062719', 0, NULL, 100000.00, 1.20, 6, '2022-08-29 14:38:27', '2022-08-29 14:38:27', '李增虎', '17814382372', '372823199005162816', '何海涵', '13176852739', '373833198910073526', 'dd4f92b790dc4f36964888c98169ce66.jpg');
INSERT INTO `tb_finance` VALUES (141, 1006, 'wyn3', '王亚楠', '13696859685', '370201196501026352', 2, NULL, 120000.00, 1.80, 36, '2022-09-08 10:12:35', '2022-09-08 10:12:35', '沙发', '13754125623', '370203199802036513', '的撒', '13895212195', '370213199009160203', '47fc92e1068d4c20833e4e197aec0b0d.jpg 20e7a0d77ecf4731b28ebc1d6ca22587.jpg ');
INSERT INTO `tb_finance` VALUES (142, 1002, 'lisi', '2222', '222', '2222', 0, NULL, 2222.00, 1.20, 6, '2023-09-27 15:13:33', '2023-09-27 15:13:33', NULL, NULL, NULL, NULL, NULL, NULL, 'ec77756049ba43f79243608f86336fc5.jpg ');
INSERT INTO `tb_finance` VALUES (144, 1002, 'hh1', '马老师', '213213212', '121132444444', 0, NULL, 100000.00, 1.11, 12, '2023-10-19 10:01:48', '2023-10-19 10:01:48', NULL, NULL, NULL, NULL, NULL, NULL, 'c110baca558741a5b06aba99f9150c31.webp ');
INSERT INTO `tb_finance` VALUES (145, 1001, 'hh1', '张三', '2132123131', '21232223.232', 0, NULL, 100000000.00, 1.11, 24, '2023-10-19 10:21:40', '2023-10-19 10:21:40', '马老师', '123132123123123', '45654656132', '小黑', '312312354654', '878789465456', '241cf75d50dc4542bc72d0fcf0576434.webp ');
INSERT INTO `tb_finance` VALUES (147, 1002, 'hh1', '张三111', '22121321', '21212121213', 0, NULL, 100000.00, 1.20, 24, '2023-10-24 15:59:24', '2023-10-24 15:59:24', NULL, NULL, NULL, NULL, NULL, NULL, '84147ddcf80a429f8f48b521b317c135.webp ');

-- ----------------------------
-- Table structure for tb_financing_intention
-- ----------------------------
DROP TABLE IF EXISTS `tb_financing_intention`;
CREATE TABLE `tb_financing_intention`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '融资意向',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `real_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `amount` int(11) NOT NULL,
  `application` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `item` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `repayment_period` int(11) NOT NULL,
  `area` int(11) NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '融资意向表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_financing_intention
-- ----------------------------
INSERT INTO `tb_financing_intention` VALUES (5, 'zhangxukun', '张旭坤', '山东省菏泽市', 80000, '种植农作物', '苹果', 60, 90, '13176879739', '2022-08-09 14:56:31', '2022-08-10 14:56:35');
INSERT INTO `tb_financing_intention` VALUES (6, 'wyn3', '王亚楠', '威海市', 1000000, '芒果种植', '芒果', 36, 1, '13792499256', '2022-09-08 09:58:14', '2022-09-08 10:01:15');
INSERT INTO `tb_financing_intention` VALUES (10, 'aaaaaa', '123123', '3131', 123123123, '3123123', '1231231', 12, 1313, '121313131', '2023-09-27 16:45:43', '2023-09-27 16:45:43');
INSERT INTO `tb_financing_intention` VALUES (12, 'hh1', '张三', '213', 100000, 'ooo', '222', 12, 120, '12131213', '2023-10-19 14:00:57', '2023-10-19 14:00:57');
INSERT INTO `tb_financing_intention` VALUES (13, 'admin', '小黑', '广东', 100000, '种树', '树', 36, 100, '2133212313', '2023-10-23 15:16:09', '2023-10-23 15:16:09');
INSERT INTO `tb_financing_intention` VALUES (14, 'wdy', '王多鱼', '545433', 100000, '45645', '5434', 6, 45343, '25555577777', '2023-10-24 17:06:58', '2023-10-24 17:37:08');

-- ----------------------------
-- Table structure for tb_knowledge
-- ----------------------------
DROP TABLE IF EXISTS `tb_knowledge`;
CREATE TABLE `tb_knowledge`  (
  `knowledge_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pic_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `own_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发布者名字',
  `create_time` time(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  PRIMARY KEY (`knowledge_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_knowledge
-- ----------------------------
INSERT INTO `tb_knowledge` VALUES (22, '水稻种植全过程', '水稻种植第一步：晒种\n水稻种植第二步：选种\n水稻种植第三步：整秧版\n水稻种植第四步：播种\n水稻种植第五步：插秧\n水稻种植第六步：缓苗\n水稻种植第七步：田间管理（关键）', '2cc2479866734c8980d88c86db7dbdc7.webp', 'gaoge', '16:33:59', '2021-08-27 16:33:59');
INSERT INTO `tb_knowledge` VALUES (23, '玉米种植过程详解 ', '玉米一直都被誉为长寿食品，含有丰富的蛋白质、脂肪、维生素、微量元素、纤维素等，具有开发高营养、高生物学功能食品的巨大潜力。但由于其遗传性较为复杂，变异种类丰富，在常规的育种过程中存在着周期过长、变异系数过大、影响子代生长发育的缺点，而现代生物育种技术不但克服了上述缺点和不足，同时也提高了育种速度和质量。玉米出苗后，要及时检查出苗情况，发现缺苗断垄要及时补种、补栽。3叶期前缺苗，用饱满种子浸种催芽后浇水补种。3叶期后缺苗用带土移栽法补苗(播种时可在行间播预备苗)，另外，缺苗处也可在附近留双株补救。', 'cb0d06358f8c40628b6dca273f881875.jpeg', 'gaoge', '09:31:37', '2021-08-30 09:31:37');
INSERT INTO `tb_knowledge` VALUES (24, '大豆种植', '大豆可分为黄豆、青豆和黑豆。可大家都认为大豆只是黄豆。富含蛋白质,大豆磷脂由大豆提取出来的精华,大豆中提取的纯磷脂精华物质,对人体健康有着极大的帮助，并无副作用。对于黄大豆，它需要较长的生产时间，也非常得能耐寒冷，北方地区的气候条件适合种植;然而青豆的生长时间较短，适宜把', '12be19984e374bcfbf06561571365d07.jpg', 'gaoge', '09:37:43', '2021-08-30 09:37:43');
INSERT INTO `tb_knowledge` VALUES (25, '永泰李干的制作过程', '福州特色农产品，永泰李干的制作过程，100％还原！暑期在家帮父母晒李干，永泰李干虽是福建名产，但是市场占有率很低，“养在深山人未识”。我家李干的口感、品质都是不错的，欢迎大家购买品尝！', '7765f8705bc54a2086bc295f3bd7217c.jpg', 'zhangxukun', '09:39:56', '2021-08-30 09:39:56');
INSERT INTO `tb_knowledge` VALUES (26, '葡萄种植111', '葡萄是我们生活中最常见的水果之一。如今，市场上出现了许多葡萄品种，一些葡萄正处于管理的关键阶段。这种葡萄管理说简单其实也简单，说复杂也复杂，会者不难，难者不会。掌握基本要点，就能实现“一年树，两年果，三年高产”的愿望。', 'd50a95115e7d4b2d832fbcc50e35944b.jpg', 'gaoge', '09:44:24', '2021-08-30 09:44:24');
INSERT INTO `tb_knowledge` VALUES (27, '【农业种植 • 园艺】《天天学农（农技知识）》', '天天学农创始团队在过去的数年中走遍中国广大农村，与农民深入交谈，了解越多就越觉得必须要去为农民做点实事。我们中很多人是农民的孩子，知道中国农民真是一群非常勤劳的人，但缺乏生产技术，往往事倍功半，他们也渴望学习。农民是朴实的，像庄稼地一样，种下什么就收获什么。视频涵盖了大棚草莓、猕猴桃、苹果树等方方面面，是农民朋友切实需要的教学视频，我们将提供大量的农业技术教学视频，方便大家学习，不断提高农业技术，创造美好生活。', '5722cfcd93c84a9083720d2cb072c5a0.jpg', 'zhangxukun', '09:46:37', '2021-08-30 09:46:37');
INSERT INTO `tb_knowledge` VALUES (28, '西瓜种植', '西瓜露地早春栽培，一般以地温稳定在15℃左右时为露地播种的适宜时间。播种的最佳时间，还应根据品种、栽培季节、栽培方式以及消费季节等条件来确定。一般月中下旬播种育苗，4月中下旬定植，6月下旬开始收获上市；秋西瓜7月上中旬播种，9月下旬开始采收上市。', 'da482ad921d64a798140138a0607eb76.jpg', 'gaoge', '09:54:19', '2021-08-30 09:54:19');
INSERT INTO `tb_knowledge` VALUES (29, '生姜的一生｜现代农业种植和收获生姜', '两千多年来生姜一直活跃在餐桌上。一般做酱菜和小吃用嫩姜，做调料和药用以老姜为佳。传说，神农氏四处尝百草。有一次，误食毒蘑菇，吃了一株长着尖细叶子的青草，神农氏一阵腹泻，感觉死而复生。神农氏姓姜，他将这株救命的植物，叫做生姜。', '4265868e71a44832a3e39a4547dc307c.jpg', 'zhangxukun', '09:55:54', '2021-08-30 09:55:54');
INSERT INTO `tb_knowledge` VALUES (30, '人工种植蘑菇', '黄伞伞，白杆杆，吃完一起开厂厂！一天卖2吨蘑菇的奥地利现代种植工厂赚钱全过程', '1aff704b6fa94e91b58bdda36f9db166.jpg', 'zhangxukun', '10:00:02', '2021-08-30 10:00:02');
INSERT INTO `tb_knowledge` VALUES (34, 'csgo技巧', 'csgo技巧', '22fea5c4a6534219aa8827120e7839a3.mp4', 'hyx', '15:15:32', '2023-09-27 15:15:32');
INSERT INTO `tb_knowledge` VALUES (36, '柠檬种植技术', '1、种植环境柠檬是一种喜温的植物，但是也不耐高温，更不耐寒，所以仅适宜在我国部分的沿海地区生长。另外它对气温条件的要求也非常高，年平均气温约在18摄氏度的地区最适合柠檬生长。另外，柠檬对于土壤的需求非常低，但宜使用的栽培土应该是疏松性好的、排水能力也要强一些，最好是ph值处于5.5~6.5，酸性的土壤更适合它生长。', 'cbba2e77b1254d818cb2d1945ed7bfe6.webp', 'gaoge', '15:15:26', '2023-10-18 15:15:26');
INSERT INTO `tb_knowledge` VALUES (37, '沃柑苗种植技术', '1、地块选择在种植沃柑的时候，应该选择疏松、肥沃、背风向阳的地块进行种植，这样的地块符合沃柑的生长条件，并在种植前，整平地块，深耕30厘米，并施入充足的腐熟有机肥、过磷酸钙，准备定植。2、沃柑定植定植沃柑应该按照一定的间距进行，最好是2米一棵，每年4-5月份为定植时间，种植前，要消毒苗木根系，起到抗病作用，然后将苗木定植到地块里。', 'cdfad80bfa6a4cc7921c68ead2d8c0e2.webp', 'gaoge', '15:44:54', '2023-10-18 15:44:54');

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order`  (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '需求标题',
  `price` decimal(65, 2) DEFAULT NULL COMMENT '期望价格',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `order_status` int(11) NOT NULL DEFAULT 0 COMMENT '订单状态，0表示待合作，1表示待发货，2表示完成，3表示完成但未评价',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '1销售订单，2需求订单',
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单主图',
  `own_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发起订单人',
  `cooperation_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '合作人名字',
  `create_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单收货地址',
  `version` smallint(1) DEFAULT 0 COMMENT '版本号 避免脏读导致的数据不一致业务情况',
  `deleted` smallint(1) DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2224 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES (83, '求购100斤大米', 123.00, '求购100斤大米，质量佳的优先考虑', 1, 'needs', '35b21d2ca3b1402f9ca67f917ce006c1.gif', 'lzh', NULL, '2021-08-27 16:38:29', '2021-08-27 17:27:49', '山东省威海市', 0, 0);
INSERT INTO `tb_order` VALUES (86, '求购一千斤玉米', 2323.00, '急需，价低者来，请联系17826782782', 1, 'needs', '71ea0e08a7ce4bb697b1d6b87a113379.webp', 'lzh', NULL, '2021-08-27 16:40:28', '2021-08-27 16:40:28', '山东省威海市', 0, 0);
INSERT INTO `tb_order` VALUES (88, '小香薯', 22.80, '求购临安天目山现挖小香薯', 1, 'needs', 'a70954af69094cbf9c72f6d15eb24509.jpg', 'zhangxukun', NULL, '2021-08-27 16:45:03', '2021-08-27 16:45:03', '山东省威海市', 0, 0);
INSERT INTO `tb_order` VALUES (90, '求购90斤苹果', 2332.00, '甘甜可口，不要青苹果', 0, 'needs', 'eee99f060b4843909db360a346ddc18f.webp', 'lzh', NULL, '2021-08-27 16:45:29', '2021-08-27 16:45:29', '山东省威海市', 0, 0);
INSERT INTO `tb_order` VALUES (92, '求购5斤红辣椒', 39.90, '求购5斤红辣椒，变态辣', 0, 'needs', 'e21080ff8f0c47ffb1dee3e236d6a5eb.jpg', 'zhangxukun', NULL, '2021-08-27 16:48:34', '2021-08-27 16:48:34', '山东省威海市', 0, 0);
INSERT INTO `tb_order` VALUES (93, '求购新疆西瓜', 324.00, '要甜的，昼夜温差大的环境中种植的', 0, 'needs', '38d1cf5c26ee444aa709ac2e94730812.webp', 'wyn3', NULL, '2021-08-27 16:51:02', '2021-08-30 13:18:15', '山东省威海市', 0, 0);
INSERT INTO `tb_order` VALUES (94, '求购10斤小紫薯', 48.80, '是小土豆，长不大，乒乓球大小的，但是要口感粉糯。有意者联系18396833838', 0, 'needs', '26820e36e2c449479a34b25c8a647f40.jpg', 'zhangxukun', NULL, '2021-08-27 16:51:11', '2021-08-27 16:51:11', '山东省威海市', 0, 0);
INSERT INTO `tb_order` VALUES (95, '来100斤茄子', 23321.00, '有的MM，价钱合理哦', 0, 'needs', 'd18b7b37555a4bbda1020d56a0626ed5.jpg', 'lzh', NULL, '2021-08-27 16:53:20', '2021-08-27 16:53:20', '山东省威海市', 0, 0);
INSERT INTO `tb_order` VALUES (98, '收100斤羊肉', 2333.00, '价钱给够，带价来，咩咩咩', 0, 'needs', '609b8a1aeef9473ca1bfd5f93098ce8f.jpg', 'wyn3', NULL, '2021-08-27 16:55:57', '2021-08-27 16:55:57', '山东省威海市', 0, 0);
INSERT INTO `tb_order` VALUES (100, '求购青苹果', 120.00, '求购40斤青苹果，有意者私聊', 0, 'needs', 'effaf0126a2541c4a18f8431051743ac.jpg', 'zhangxukun', NULL, '2021-08-27 16:57:29', '2021-08-27 16:57:29', '山东省威海市', 0, 0);
INSERT INTO `tb_order` VALUES (101, '杨梅', 159.00, '求购浮宫杨梅新鲜当季孕妇水果应季非仙居东魁杨梅', 0, 'needs', 'd65fa5bfb94a4270b1e3265e34d83214.jpg', 'zwr', NULL, '2021-08-27 16:59:45', '2021-08-27 16:59:45', '山东省威海市', 0, 0);
INSERT INTO `tb_order` VALUES (102, '洋芋蛋蛋', 12.40, '诚信求购新鲜洋芋蛋蛋', 0, 'needs', '0cb58391ab754653abe7958c6b4febc4.jpg', 'zhangxukun', NULL, '2021-08-27 17:00:07', '2021-08-27 17:00:07', '山东省威海市', 0, 0);
INSERT INTO `tb_order` VALUES (103, '人参果', 96.00, '求购云南人参果圆果5斤精品中果应季孕妇圆水果新鲜当季', 0, 'needs', '8e5a53c441794395b84076fa2e457f40.jpg', 'zwr', NULL, '2021-08-27 17:01:49', '2021-08-27 17:01:49', '山东省威海市', 0, 0);
INSERT INTO `tb_order` VALUES (104, '求购葡萄', 89.00, '求购福安象环葡萄巨峰产地大葡萄5斤', 0, 'needs', '08ea2a0040674d6098b426ad96715fd1.jpg', 'zwr', NULL, '2021-08-27 17:10:07', '2021-08-27 17:10:07', '山东省威海市', 0, 0);
INSERT INTO `tb_order` VALUES (105, '甘蓝', 26.80, '求购羽衣甘蓝新鲜沙拉西餐蔬菜食材即食健身有机蔬菜2斤', 0, 'needs', 'f3705c3686944a5bb3843d842f4f37d8.jpg', 'zwr', NULL, '2021-08-27 17:14:26', '2021-08-27 17:14:26', '山东省威海市', 0, 0);
INSERT INTO `tb_order` VALUES (106, '佛手瓜', 19.90, '求购新鲜云南佛手瓜5斤', 0, 'needs', '566ae2891bf24952874058b86051f4a2.jpg', 'zwr', NULL, '2021-08-27 17:28:37', '2021-08-27 17:28:37', '山东省威海市', 0, 0);
INSERT INTO `tb_order` VALUES (141, '求购水蜜桃', 20.00, '求购水蜜桃', 0, 'needs', 'ff485f0e71684f6fb48c23021ebf1408.jpg', 'lzh', NULL, '2022-09-01 11:54:29', '2022-09-01 11:54:29', '山东省临沂市', 0, 0);
INSERT INTO `tb_order` VALUES (152, '坤坤66ppp', 9994.00, '坤坤水果，多买一个就会爆炸！2312', 0, 'goods', '8e45f96c09a34eee880d0de7ea33b0de.gif', 'admin', NULL, '2023-09-27 14:46:56', '2023-10-15 14:16:44', '山东省青岛市', 2, 1);
INSERT INTO `tb_order` VALUES (2197, '香蕉', 6.98, '健康美味，营养丰富，快来品尝香蕉的美味！', 0, 'goods', '11e2f704404842f7a5aee0def12ee9d8.webp', 'hh1', NULL, '2023-10-16 17:19:11', '2023-10-20 21:11:58', NULL, 1, 0);
INSERT INTO `tb_order` VALUES (2198, '柠檬', 22.00, '\n清新柠檬，酸甜可口，富含维生素C和抗氧化剂，具有提神醒脑、美白肌肤的功效，还可用于烹饪和调制饮品，让你尽享柠檬的美味与益处！', 0, 'goods', 'e5862fd0d2ec45d2b8dc6a2351aa5ed1.webp', 'hh1', NULL, '2023-10-17 17:00:24', '2023-10-20 21:12:34', NULL, 1, 0);
INSERT INTO `tb_order` VALUES (2199, '柠檬6', 22.98, '清新柠檬，酸甜可口，富含维生素C和抗氧化剂，具有提神醒脑、美白肌肤的功效，还可用于烹饪和调制饮品，让你尽享柠檬的美味与益处！', 0, 'goods', 'f1f7d88d66694f7fba0161f9c93e1123.webp', 'admin', NULL, '2023-10-17 19:24:06', '2023-10-20 21:07:22', NULL, 1, 0);
INSERT INTO `tb_order` VALUES (2200, '黄桃', 666.00, '6666666', 0, 'needs', '021ca48418724f6ab6787b003be5816e.webp', 'aaaaaa', NULL, '2023-10-18 09:53:23', '2023-10-18 09:53:23', NULL, 0, 0);
INSERT INTO `tb_order` VALUES (2201, '香蕉', 16.88, '香蕉，果香扑鼻，口感绵密，富含纤维和维生素，是健康能量的来源，让你活力满满！', 0, 'goods', '3c10c1f0e1ae470bae8a79dbe15f103b.webp', 'aaaaaa', NULL, '2023-10-18 09:54:20', '2023-10-20 21:26:14', NULL, 1, 0);
INSERT INTO `tb_order` VALUES (2202, '求购100斤香蕉', 1000.00, '求购100斤香蕉！！！！！！！！！！！！', 0, 'needs', '64299c3324ff41a7809d93f9638b1e95.webp', 'hh1', NULL, '2023-10-18 10:13:15', '2023-10-18 10:13:15', NULL, 0, 0);
INSERT INTO `tb_order` VALUES (2203, '百香果', 22.00, '激情果味尽在百香果，酸甜滋味惹人爱，快来品尝，开启美味之旅！', 0, 'goods', '63714f5d883a42e9939a9fca0818d739.webp', 'admin', NULL, '2023-10-20 20:59:53', '2023-10-20 20:59:53', NULL, 0, 0);
INSERT INTO `tb_order` VALUES (2204, '草莓', 55.90, '浓情草莓，红彤彤的诱惑，口感鲜美，香甜可口，让你回味无穷，快来享受吧！', 0, 'goods', 'cfe5e934e08c40c0be5f835a9c80a5ce.webp', 'admin', NULL, '2023-10-20 21:01:49', '2023-10-20 21:01:49', NULL, 0, 0);
INSERT INTO `tb_order` VALUES (2205, '车厘子', 66.98, '精选车厘子，鲜美多汁，口感细腻，甜度适中，给你品味极致享受，一起来享受车厘子的诱人风味吧！', 0, 'goods', 'f580aa1fdd914489ba7dd79c329b0926.webp', 'admin', NULL, '2023-10-20 21:02:50', '2023-10-20 21:02:50', NULL, 0, 0);
INSERT INTO `tb_order` VALUES (2206, '红辣椒', 4.98, '火辣红辣椒，调味必备，辣劲十足，为美食增添热情，让你尽情享受辛辣的味蕾刺激，快来尝试吧！', 0, 'goods', 'd4969117f1274ff5b6befb2f952bf583.webp', 'admin', NULL, '2023-10-20 21:04:03', '2023-10-20 21:04:03', NULL, 0, 0);
INSERT INTO `tb_order` VALUES (2207, '黄瓜', 5.98, '清爽黄瓜，口感脆嫩，富含水分，是夏日解渴的首选，不仅美味而且营养丰富，让你健康又满足，快来品尝吧！', 0, 'goods', 'a4eaf898ca474cd093b23fc1073ac69c.webp', 'admin', NULL, '2023-10-20 21:05:08', '2023-10-20 21:05:08', NULL, 0, 0);
INSERT INTO `tb_order` VALUES (2208, 'h胡萝卜', 4.98, '萝卜，鲜艳诱人，口感爽脆，富含丰富的胡萝卜素和维生素，促进视力健康，增强免疫力，让你更健康更有活力！', 0, 'goods', '84a7dd9c21e64213a42d3ceba8db5d41.webp', 'admin', NULL, '2023-10-20 21:06:07', '2023-10-20 21:06:07', NULL, 0, 0);
INSERT INTO `tb_order` VALUES (2209, '猕猴桃', 44.98, '酸甜口感，养颜美容，尽情品味猕猴桃的鲜美滋味！', 0, 'goods', '668142fcebd44470ad98caeabd416adf.webp', 'hh1', NULL, '2023-10-20 21:15:12', '2023-10-20 21:15:12', NULL, 0, 0);
INSERT INTO `tb_order` VALUES (2210, '生姜', 6.98, '生姜，挚友般的调味佳品，为你带来温暖与美味！', 0, 'goods', 'a7b6eac4deb148c09a8d10075dd2135b.webp', 'hh1', NULL, '2023-10-20 21:17:55', '2023-10-20 21:17:55', NULL, 0, 0);
INSERT INTO `tb_order` VALUES (2211, '葡萄', 9.98, '\n鲜嫩多汁，甜美滋味，葡萄是天然的美味水果，享受果园的香甜！', 0, 'goods', '0191cd65ea8548eea280162f3b019381.webp', 'hh1', NULL, '2023-10-20 21:19:11', '2023-10-20 21:19:11', NULL, 0, 0);
INSERT INTO `tb_order` VALUES (2212, '青苹果', 18.88, '青苹果，清新爽口，酸甜可口，唤醒你的味蕾，让你倍感清爽！', 0, 'goods', 'aecfc9db830d4a9b969a51aa4d850135.webp', 'hh1', NULL, '2023-10-20 21:20:26', '2023-10-20 21:20:26', NULL, 0, 0);
INSERT INTO `tb_order` VALUES (2213, '玉米', 9.88, '金黄玉米，营养丰富，口感细腻，给你满满的能量，享受自然的美味！', 0, 'goods', 'a284b8edae4b4f5a997e09e399f335f1.webp', 'hh1', NULL, '2023-10-20 21:21:14', '2023-10-20 21:21:14', NULL, 0, 0);
INSERT INTO `tb_order` VALUES (2214, '空心菜', 5.88, '空心菜，绿叶似蔓延的爱意，香气四溢，口感鲜脆，让你尽情品味健康与美味的结合！', 0, 'goods', 'dbbd6fb2e55a4de99a4e10f20b4ab3bc.webp', 'hh1', NULL, '2023-10-20 21:22:21', '2023-10-20 21:22:21', NULL, 0, 0);
INSERT INTO `tb_order` VALUES (2215, '苦瓜', 6.88, '苦瓜，清香苦涩，独特的风味，富含多种营养，有助于清热解暑，保持健康平衡！', 0, 'goods', 'c85f4b6efbf64bf799ec5b4994dab1c7.webp', 'hh1', NULL, '2023-10-20 21:23:17', '2023-10-20 21:23:17', NULL, 0, 0);
INSERT INTO `tb_order` VALUES (2216, '上海青', 8.88, '上海青，是一种嫩绿色的蔬菜，口感鲜嫩，清爽宜人。富含维生素C、维生素K、钙等营养成分，有助于补充身体所需，是一道健康又美味的选择！', 0, 'goods', '2e1f456c7d1946479e171a0b1d28f0ec.webp', 'aaaaaa', NULL, '2023-10-20 21:27:12', '2023-10-20 21:27:12', NULL, 0, 0);
INSERT INTO `tb_order` VALUES (2217, '南瓜', 5.98, '南瓜，橙色圆润的果实，富含丰富的β-胡萝卜素、维生素C和纤维素等营养成分。口感细腻甜美，可以用来制作各种美食，既美味又营养！', 0, 'goods', '1f8bb9997a4e4020a4bb7185c202c981.webp', 'aaaaaa', NULL, '2023-10-20 21:28:21', '2023-10-20 21:28:21', NULL, 0, 0);
INSERT INTO `tb_order` VALUES (2218, '韭菜', 12.99, '韭菜，富含蛋白质、维生素C、维生素K、维生素A等多种营养物质，有助于促进消化、增强免疫力，并具有一定的抗氧化作用。韭菜可以用于制作各种菜肴，如韭菜饺子、韭菜炒鸡蛋等，美味又营养！', 0, 'goods', '60f51fda93f94d90a55377fe458b1337.webp', 'aaaaaa', NULL, '2023-10-20 21:29:34', '2023-10-20 21:29:34', NULL, 0, 0);
INSERT INTO `tb_order` VALUES (2219, '菜花', 5.99, '菜花富含维生素C、维生素K、叶酸和纤维等营养物质，有助于增强免疫力、促进消化和维护健康。它可以烹调成各种美食，如菜花炒肉片、蒸菜花等，味道鲜美，营养丰富！', 0, 'goods', '000ec95383814b899ed2a20f6c7da2a3.webp', 'aaaaaa', NULL, '2023-10-20 21:30:42', '2023-10-20 21:30:42', NULL, 0, 0);
INSERT INTO `tb_order` VALUES (2220, '新疆哈密瓜', 16.99, '阳光照耀，甜蜜飘香。新疆哈密瓜，让你享受夏日的美妙！', 0, 'goods', '52a5794b0dd443f886297b2194bc76fa.webp', 'aaaaaa', NULL, '2023-10-20 21:36:39', '2023-10-20 21:36:39', NULL, 0, 0);
INSERT INTO `tb_order` VALUES (2221, '樱桃', 88.98, '诱人的红色诱发唇齿间的味蕾盛宴，樱桃，让你尽享果香甜蜜！', 0, 'goods', 'e68a08c239a04abeafacfdea057cfe57.webp', 'aaaaaa', NULL, '2023-10-20 21:37:46', '2023-10-20 21:37:46', NULL, 0, 0);
INSERT INTO `tb_order` VALUES (2222, '茄子', 19.88, '独特口感，健康美味。茄子，品味不一样的滋味。', 0, 'goods', '3cf0438243354bacaa90386aebed4223.webp', 'aaaaaa', NULL, '2023-10-20 21:39:40', '2023-10-20 21:39:40', NULL, 0, 0);
INSERT INTO `tb_order` VALUES (2223, '窝瓜', 9.99, '令人垂涎的瓜果，窝瓜，散发着清新的甜蜜香气。口感水润脆爽，带给你一口清凉的滋味享受。', 0, 'goods', 'd6307c60017542fe9050237e6d91a265.webp', 'aaaaaa', NULL, '2023-10-20 21:42:43', '2023-10-20 21:42:43', NULL, 0, 0);

-- ----------------------------
-- Table structure for tb_purchase
-- ----------------------------
DROP TABLE IF EXISTS `tb_purchase`;
CREATE TABLE `tb_purchase`  (
  `purchase_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单表',
  `own_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发布人',
  `purchase_type` int(11) NOT NULL COMMENT '类型',
  `total_price` decimal(65, 2) NOT NULL COMMENT '订单金额',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单收货地址',
  `purchase_status` int(11) NOT NULL COMMENT '需求状态',
  `create_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  PRIMARY KEY (`purchase_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 170 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_purchase
-- ----------------------------
INSERT INTO `tb_purchase` VALUES (120, 'wyn3', 1, 15.80, '184', 1, '2022-09-07 16:09:34', '2022-09-07 16:09:34');
INSERT INTO `tb_purchase` VALUES (121, 'wyn3', 1, 265.00, '184', 1, '2022-09-07 16:09:55', '2022-09-07 16:09:55');
INSERT INTO `tb_purchase` VALUES (122, 'zhangxukun', 1, 324.00, '147', 1, '2022-09-08 10:13:44', '2022-09-08 10:13:44');
INSERT INTO `tb_purchase` VALUES (123, 'admin001', 1, 131.60, '190', 1, '2023-06-30 10:15:27', '2023-06-30 10:15:27');
INSERT INTO `tb_purchase` VALUES (124, 'admin', 1, 275.00, '172', 1, '2023-09-27 14:25:47', '2023-09-27 14:25:47');
INSERT INTO `tb_purchase` VALUES (125, 'admin', 1, 296.53, '172', 1, '2023-09-27 14:26:03', '2023-09-27 14:26:03');
INSERT INTO `tb_purchase` VALUES (126, 'admin', 1, 0.00, '172', 1, '2023-09-27 14:26:14', '2023-09-27 14:26:14');
INSERT INTO `tb_purchase` VALUES (127, 'admin', 1, 6.00, '172', 1, '2023-09-27 14:26:17', '2023-09-27 14:26:17');
INSERT INTO `tb_purchase` VALUES (128, 'admin', 1, 6.00, '172', 1, '2023-09-27 14:26:19', '2023-09-27 14:26:19');
INSERT INTO `tb_purchase` VALUES (129, 'admin', 1, 45.62, '172', 1, '2023-09-27 14:28:31', '2023-09-27 14:28:31');
INSERT INTO `tb_purchase` VALUES (130, 'admin', 1, 679.60, '172', 1, '2023-09-27 14:28:36', '2023-09-27 14:28:36');
INSERT INTO `tb_purchase` VALUES (131, 'admin', 1, 22.81, '172', 1, '2023-09-27 14:29:30', '2023-09-27 14:29:30');
INSERT INTO `tb_purchase` VALUES (132, 'admin', 1, 65.80, '172', 1, '2023-09-27 14:30:02', '2023-09-27 14:30:02');
INSERT INTO `tb_purchase` VALUES (133, 'admin', 1, 68.43, '172', 1, '2023-09-27 14:32:44', '2023-09-27 14:32:44');
INSERT INTO `tb_purchase` VALUES (134, 'admin', 1, 36.00, '172', 1, '2023-09-27 14:33:04', '2023-09-27 14:33:04');
INSERT INTO `tb_purchase` VALUES (135, 'admin', 1, 189.60, '172', 1, '2023-09-27 14:34:41', '2023-09-27 14:34:41');
INSERT INTO `tb_purchase` VALUES (136, 'admin', 1, 2.00, '172', 1, '2023-09-27 14:34:46', '2023-09-27 14:34:46');
INSERT INTO `tb_purchase` VALUES (137, 'admin', 1, 2.00, '172', 1, '2023-09-27 14:35:33', '2023-09-27 14:35:33');
INSERT INTO `tb_purchase` VALUES (138, 'admin', 1, 158.00, '172', 1, '2023-09-27 14:36:15', '2023-09-27 14:36:15');
INSERT INTO `tb_purchase` VALUES (139, 'admin', 1, 158.00, '172', 1, '2023-09-27 14:36:52', '2023-09-27 14:36:52');
INSERT INTO `tb_purchase` VALUES (140, 'admin', 1, 68.43, '172', 1, '2023-09-27 14:37:15', '2023-09-27 14:37:15');
INSERT INTO `tb_purchase` VALUES (141, 'admin', 1, 387.77, '172', 1, '2023-09-27 14:37:53', '2023-09-27 14:37:53');
INSERT INTO `tb_purchase` VALUES (142, 'admin', 1, 123.00, '172', 1, '2023-09-27 14:43:42', '2023-09-27 14:43:42');
INSERT INTO `tb_purchase` VALUES (143, 'admin', 1, 800.00, '172', 1, '2023-09-27 14:44:34', '2023-09-27 14:44:34');
INSERT INTO `tb_purchase` VALUES (144, 'admin', 1, 222222000000000.00, '172', 1, '2023-09-27 15:07:23', '2023-09-27 15:07:23');
INSERT INTO `tb_purchase` VALUES (145, 'admin', 1, 22.81, '172', 1, '2023-09-27 15:08:28', '2023-09-27 15:08:28');
INSERT INTO `tb_purchase` VALUES (146, 'admin', 1, 22.81, '172', 1, '2023-09-27 15:11:18', '2023-09-27 15:11:18');
INSERT INTO `tb_purchase` VALUES (147, 'lisi', 1, 345.00, '186', 1, '2023-09-27 15:14:38', '2023-09-27 15:14:38');
INSERT INTO `tb_purchase` VALUES (148, 'admin', 1, 133333.20, '172', 1, '2023-09-27 15:21:03', '2023-09-27 15:21:03');
INSERT INTO `tb_purchase` VALUES (149, 'admin', 1, 111111.00, '172', 1, '2023-09-27 15:30:32', '2023-09-27 15:30:32');
INSERT INTO `tb_purchase` VALUES (150, 'admin', 1, 9999999999999.00, '172', 1, '2023-09-27 15:54:40', '2023-09-27 15:54:40');
INSERT INTO `tb_purchase` VALUES (151, 'lisi', 1, 0.00, '187', 1, '2023-09-27 16:00:35', '2023-09-27 16:00:35');
INSERT INTO `tb_purchase` VALUES (152, 'lisi', 1, 29997.00, '187', 1, '2023-09-27 16:00:38', '2023-09-27 16:00:38');
INSERT INTO `tb_purchase` VALUES (153, 'admin', 1, 309969.00, '172', 1, '2023-09-27 16:07:11', '2023-09-27 16:07:11');
INSERT INTO `tb_purchase` VALUES (154, 'admin', 1, 99999999.00, '172', 1, '2023-09-27 17:07:08', '2023-09-27 17:07:08');
INSERT INTO `tb_purchase` VALUES (155, 'admin', 1, 49995.00, '172', 1, '2023-09-27 17:09:01', '2023-09-27 17:09:01');
INSERT INTO `tb_purchase` VALUES (156, 'admin', 1, 9999.00, '172', 1, '2023-09-27 17:24:33', '2023-09-27 17:24:33');
INSERT INTO `tb_purchase` VALUES (157, 'admin', 1, 99999999.00, '172', 1, '2023-09-27 17:27:15', '2023-09-27 17:27:15');
INSERT INTO `tb_purchase` VALUES (158, 'admin', 1, 99999999.00, '172', 1, '2023-09-27 17:27:30', '2023-09-27 17:27:30');
INSERT INTO `tb_purchase` VALUES (159, 'admin', 1, 13980000.00, '172', 1, '2023-09-27 17:27:53', '2023-09-27 17:27:53');
INSERT INTO `tb_purchase` VALUES (160, 'admin', 1, 111.00, '172', 1, '2023-09-27 17:35:48', '2023-09-27 17:35:48');
INSERT INTO `tb_purchase` VALUES (161, 'admin', 1, 145.73, '172', 1, '2023-10-23 17:29:38', '2023-10-23 17:29:38');
INSERT INTO `tb_purchase` VALUES (162, 'hh1', 1, 22.98, '193', 1, '2023-10-23 17:33:05', '2023-10-23 17:33:05');
INSERT INTO `tb_purchase` VALUES (163, 'hh1', 1, 77.90, '193', 1, '2023-10-23 18:14:19', '2023-10-23 18:14:19');
INSERT INTO `tb_purchase` VALUES (164, 'hh1', 1, 19.88, '193', 0, '2023-10-23 18:27:44', '2023-10-23 18:27:44');
INSERT INTO `tb_purchase` VALUES (165, 'hh1', 0, 17.97, '193', 1, '2023-10-23 18:29:31', '2023-10-23 18:29:31');
INSERT INTO `tb_purchase` VALUES (166, 'aaaaaa', 0, 6.88, '191', 1, '2023-10-24 10:54:41', '2023-10-24 10:54:41');
INSERT INTO `tb_purchase` VALUES (167, 'aaaaaa', 1, 32.64, '191', 1, '2023-10-27 14:20:29', '2023-10-27 14:20:29');
INSERT INTO `tb_purchase` VALUES (168, 'aaaaaa', 1, 58.74, '191', 1, '2023-10-27 14:23:54', '2023-10-27 14:23:54');
INSERT INTO `tb_purchase` VALUES (169, 'aaaaaa', 1, 16.96, '191', 1, '2023-10-27 14:30:47', '2023-10-27 14:30:47');

-- ----------------------------
-- Table structure for tb_purchase_detail
-- ----------------------------
DROP TABLE IF EXISTS `tb_purchase_detail`;
CREATE TABLE `tb_purchase_detail`  (
  `detail_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单详情',
  `purchase_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `unin_price` decimal(65, 2) NOT NULL,
  `sum_price` decimal(65, 2) NOT NULL,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`detail_id`) USING BTREE,
  INDEX `purchase_id`(`purchase_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 183 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单详情表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_purchase_detail
-- ----------------------------
INSERT INTO `tb_purchase_detail` VALUES (123, 120, 78, 15.80, 15.80, 1);
INSERT INTO `tb_purchase_detail` VALUES (124, 121, 97, 69.00, 69.00, 1);
INSERT INTO `tb_purchase_detail` VALUES (125, 121, 89, 98.00, 196.00, 2);
INSERT INTO `tb_purchase_detail` VALUES (126, 122, 80, 324.00, 324.00, 1);
INSERT INTO `tb_purchase_detail` VALUES (127, 123, 77, 65.80, 131.60, 2);
INSERT INTO `tb_purchase_detail` VALUES (128, 124, 87, 25.00, 275.00, 11);
INSERT INTO `tb_purchase_detail` VALUES (129, 125, 71, 22.81, 296.53, 13);
INSERT INTO `tb_purchase_detail` VALUES (130, 126, 71, 22.81, 296.53, 13);
INSERT INTO `tb_purchase_detail` VALUES (131, 127, 143, 2.00, 6.00, 3);
INSERT INTO `tb_purchase_detail` VALUES (132, 128, 143, 2.00, 6.00, 3);
INSERT INTO `tb_purchase_detail` VALUES (133, 129, 71, 22.81, 45.62, 2);
INSERT INTO `tb_purchase_detail` VALUES (134, 130, 80, 324.00, 648.00, 2);
INSERT INTO `tb_purchase_detail` VALUES (135, 130, 78, 15.80, 31.60, 2);
INSERT INTO `tb_purchase_detail` VALUES (136, 131, 71, 22.81, 22.81, 1);
INSERT INTO `tb_purchase_detail` VALUES (137, 132, 77, 65.80, 65.80, 1);
INSERT INTO `tb_purchase_detail` VALUES (138, 133, 71, 22.81, 68.43, 3);
INSERT INTO `tb_purchase_detail` VALUES (139, 134, 143, 2.00, 36.00, 18);
INSERT INTO `tb_purchase_detail` VALUES (140, 135, 78, 15.80, 189.60, 12);
INSERT INTO `tb_purchase_detail` VALUES (141, 136, 143, 2.00, 2.00, 1);
INSERT INTO `tb_purchase_detail` VALUES (142, 137, 143, 2.00, 2.00, 1);
INSERT INTO `tb_purchase_detail` VALUES (143, 138, 144, 79.00, 158.00, 2);
INSERT INTO `tb_purchase_detail` VALUES (144, 139, 144, 79.00, 158.00, 2);
INSERT INTO `tb_purchase_detail` VALUES (145, 140, 71, 22.81, 68.43, 3);
INSERT INTO `tb_purchase_detail` VALUES (146, 141, 71, 22.81, 387.77, 17);
INSERT INTO `tb_purchase_detail` VALUES (147, 142, 66, 123.00, 123.00, 1);
INSERT INTO `tb_purchase_detail` VALUES (148, 143, 146, 800.00, 800.00, 1);
INSERT INTO `tb_purchase_detail` VALUES (149, 144, 2120, 111111.00, 111111000000000.00, 1000000000);
INSERT INTO `tb_purchase_detail` VALUES (150, 144, 1199, 111111.00, 111111000000000.00, 1000000000);
INSERT INTO `tb_purchase_detail` VALUES (151, 145, 71, 22.81, 22.81, 1);
INSERT INTO `tb_purchase_detail` VALUES (152, 146, 71, 22.81, 22.81, 1);
INSERT INTO `tb_purchase_detail` VALUES (153, 147, 70, 345.00, 345.00, 1);
INSERT INTO `tb_purchase_detail` VALUES (154, 148, 2120, 111111.00, 111111.00, 1);
INSERT INTO `tb_purchase_detail` VALUES (155, 149, 2122, 111111.00, 111111.00, 1);
INSERT INTO `tb_purchase_detail` VALUES (156, 150, 152, 9999999999999.00, 9999999999999.00, 1);
INSERT INTO `tb_purchase_detail` VALUES (157, 151, 152, 9999999999999.00, 9999999999999.00, 1);
INSERT INTO `tb_purchase_detail` VALUES (158, 152, 152, 9999.00, 29997.00, 3);
INSERT INTO `tb_purchase_detail` VALUES (159, 153, 152, 9999.00, 309969.00, 31);
INSERT INTO `tb_purchase_detail` VALUES (160, 154, 2140, 99999999.00, 99999999.00, 1);
INSERT INTO `tb_purchase_detail` VALUES (161, 155, 152, 9999.00, 49995.00, 5);
INSERT INTO `tb_purchase_detail` VALUES (162, 156, 152, 9999.00, 9999.00, 1);
INSERT INTO `tb_purchase_detail` VALUES (163, 157, 2140, 99999999.00, 99999999.00, 1);
INSERT INTO `tb_purchase_detail` VALUES (164, 158, 2140, 99999999.00, 99999999.00, 1);
INSERT INTO `tb_purchase_detail` VALUES (165, 159, 2144, 233.00, 13980000.00, 60000);
INSERT INTO `tb_purchase_detail` VALUES (166, 160, 2143, 111.00, 111.00, 1);
INSERT INTO `tb_purchase_detail` VALUES (167, 161, 2222, 19.88, 39.76, 2);
INSERT INTO `tb_purchase_detail` VALUES (168, 161, 2221, 88.98, 88.98, 1);
INSERT INTO `tb_purchase_detail` VALUES (169, 161, 2220, 16.99, 16.99, 1);
INSERT INTO `tb_purchase_detail` VALUES (170, 162, 2220, 16.99, 16.99, 1);
INSERT INTO `tb_purchase_detail` VALUES (171, 162, 2219, 5.99, 5.99, 1);
INSERT INTO `tb_purchase_detail` VALUES (172, 163, 2204, 55.90, 55.90, 1);
INSERT INTO `tb_purchase_detail` VALUES (173, 163, 2203, 22.00, 22.00, 1);
INSERT INTO `tb_purchase_detail` VALUES (174, 164, 2222, 19.88, 19.88, 1);
INSERT INTO `tb_purchase_detail` VALUES (175, 165, 2219, 5.99, 17.97, 3);
INSERT INTO `tb_purchase_detail` VALUES (176, 166, 2215, 6.88, 6.88, 1);
INSERT INTO `tb_purchase_detail` VALUES (177, 167, 2215, 6.88, 13.76, 2);
INSERT INTO `tb_purchase_detail` VALUES (178, 167, 2212, 18.88, 18.88, 1);
INSERT INTO `tb_purchase_detail` VALUES (179, 168, 2215, 6.88, 13.76, 2);
INSERT INTO `tb_purchase_detail` VALUES (180, 168, 2209, 44.98, 44.98, 1);
INSERT INTO `tb_purchase_detail` VALUES (181, 169, 2210, 6.98, 6.98, 1);
INSERT INTO `tb_purchase_detail` VALUES (182, 169, 2211, 9.98, 9.98, 1);

-- ----------------------------
-- Table structure for tb_question
-- ----------------------------
DROP TABLE IF EXISTS `tb_question`;
CREATE TABLE `tb_question`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '在线问答',
  `expert_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专家',
  `questioner` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作物详细信息',
  `plant_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '农作物名称',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '问题标题',
  `question` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '问题',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '回答',
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 129 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '在线问答' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_question
-- ----------------------------
INSERT INTO `tb_question` VALUES (101, 'zhangxu', 'wyn3', '13792499999', '玉米', '玉米苗灌溉', '专家您好，我想请问玉米苗新技术灌溉，对玉米苗有没有影响', '建议用盐水灌溉，一周后玉米没死你来打我', 1);
INSERT INTO `tb_question` VALUES (103, 'zhangxu', 'wyn3', '13792499999', '新疆哈密瓜', '新疆哈密瓜甜度控制', '新疆哈密瓜甜度是否跟日晒有关', '不要发癫', 1);
INSERT INTO `tb_question` VALUES (108, 'gaoge', 'lzh', '15621367568', '苹果树', '苹果果树种植方法', '苹果果树种植多久浇一次水比较好呀', 'aaaaa', 1);
INSERT INTO `tb_question` VALUES (110, 'gaoge', 'wyn3', '13596488256', '这是测试提问', '这是测试提问', '这是测试提问', 'aaaaa', 1);
INSERT INTO `tb_question` VALUES (111, 'gaoge', 'wyn3', '13792499275', '草莓', '北方草莓种植品种', '北方草莓种植品种有哪些', '红颜，甜宝', 1);
INSERT INTO `tb_question` VALUES (113, 'gaoge', 'admin', '1231231231234', '123', '123', '123', '不要发癫', 1);
INSERT INTO `tb_question` VALUES (114, 'gaoge', 'zzz', '1232312123', '121212312', '23122', '3213212', '不要发癫', 1);
INSERT INTO `tb_question` VALUES (115, 'gaoge', 'admin', '1222', '苹果怎么种', '苹果怎么种', '苹果怎么种', '不要发癫', 1);
INSERT INTO `tb_question` VALUES (116, 'gaoge', 'admin', '11111111111', '111111111111111', '111', '1111111', '不要发癫', 1);
INSERT INTO `tb_question` VALUES (117, 'wyn2', 'admin', '11213121', '西瓜', '西瓜种植问题', '西瓜怎么种在树上', NULL, 0);
INSERT INTO `tb_question` VALUES (118, 'wyn', 'admin', '11', '11', '11', '11', NULL, 0);
INSERT INTO `tb_question` VALUES (119, 'gaoge', 'admin', '.12.1.', '.12.', '..3.1.', '.212.', '222222222', 1);
INSERT INTO `tb_question` VALUES (121, 'gaoge', 'aaaaaa', '12312412412312312', '苹果', '苹果可以吃吗', '苹果可以吃吗', NULL, 0);
INSERT INTO `tb_question` VALUES (122, 'gaoge', 'aaaaaa', '苹果可以吃吗', '苹果可以吃吗', '苹果可以吃吗', '苹果可以吃吗', NULL, 0);
INSERT INTO `tb_question` VALUES (123, 'gaoge', 'aaaaaa', '苹果吃了会怎样', '苹果吃了会怎样', '苹果吃了会怎样', '苹果吃了会怎样', NULL, 0);
INSERT INTO `tb_question` VALUES (124, 'gaoge', 'admin', '14515225444', '花生', '花生种植', '怎么种', NULL, 0);
INSERT INTO `tb_question` VALUES (125, 'gaoge', 'admin', '中心', '下自成蹊', '程序', '选择性', NULL, 0);
INSERT INTO `tb_question` VALUES (126, 'gaoge', 'hh1', '1212312', '22', '555', '55132', '已解决', 0);
INSERT INTO `tb_question` VALUES (128, 'gaoge', 'hh1', '23', '23', '11', 'iii', NULL, 0);

-- ----------------------------
-- Table structure for tb_reserve
-- ----------------------------
DROP TABLE IF EXISTS `tb_reserve`;
CREATE TABLE `tb_reserve`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '专家预约',
  `expert_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专家',
  `questioner` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '咨询者',
  `area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '面积',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '土地地址',
  `plant_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '农作物名称',
  `soil_condition` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '土壤条件',
  `plant_condition` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作物条件',
  `plant_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作物详细信息',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作物详细信息',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '留言',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '回答',
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 218 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '专家预约表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_reserve
-- ----------------------------
INSERT INTO `tb_reserve` VALUES (210, 'gaoge', 'wyn3', '2', '青岛崂山区北宅', '草莓', '沙地', '越冬植物', '红颜草莓', '13785964152', NULL, '已处理', 1);
INSERT INTO `tb_reserve` VALUES (211, 'gaoge', 'zzz', '213123', '123123123', '123123123123', '213213', '123123231', '123123123', '123123123', NULL, '2222222222', 1);
INSERT INTO `tb_reserve` VALUES (214, 'gaoge', 'lisi', '111111111', '山东省临沂市', '委屈饿', '恶趣味', '恶趣味', '恶趣味', '18766661439', NULL, '预约完成', 1);
INSERT INTO `tb_reserve` VALUES (215, 'gaoge', 'aaaaaa', 'asdas', 'dasd', 'asdadasd', 'sadas', 'dasdas', 'asda', 'dasdasdad', NULL, NULL, 0);
INSERT INTO `tb_reserve` VALUES (216, 'gaoge', 'admin', '123', '广西桂林', '1213', '6', '666', '卡卡卡卡卡卡卡卡', '18698765432', NULL, NULL, 0);
INSERT INTO `tb_reserve` VALUES (217, 'gaoge', 'hh1', '111', '广西桂林', 'were', 'ewf', 'fe', 'ewr', '18698765432', NULL, NULL, 0);

-- ----------------------------
-- Table structure for tb_sell_purchase
-- ----------------------------
DROP TABLE IF EXISTS `tb_sell_purchase`;
CREATE TABLE `tb_sell_purchase`  (
  `sell_purchase_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '卖出订单',
  `purchase_id` int(11) NOT NULL COMMENT '订单',
  `own_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `purchase_type` int(11) NOT NULL,
  `unin_pricee` decimal(65, 2) NOT NULL,
  `sum_price` decimal(65, 2) NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单收货地址',
  `purchase_status` int(11) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  `order_id` int(11) NOT NULL,
  PRIMARY KEY (`sell_purchase_id`) USING BTREE,
  INDEX `purchase_id`(`purchase_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 65 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '卖出订单表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_sell_purchase
-- ----------------------------
INSERT INTO `tb_sell_purchase` VALUES (15, 120, 'zhangxukun', 2, 15.80, 15.80, '184', 1, '2022-09-07 16:09:34', '2022-09-07 16:09:34', 78);
INSERT INTO `tb_sell_purchase` VALUES (16, 121, 'zwr', 2, 69.00, 69.00, '184', 1, '2022-09-07 16:09:55', '2022-09-07 16:09:55', 97);
INSERT INTO `tb_sell_purchase` VALUES (17, 121, 'zwr', 2, 98.00, 196.00, '184', 1, '2022-09-07 16:09:55', '2022-09-07 16:09:55', 89);
INSERT INTO `tb_sell_purchase` VALUES (18, 122, 'wyn3', 2, 324.00, 324.00, '147', 1, '2022-09-08 10:13:44', '2022-09-08 10:13:44', 80);
INSERT INTO `tb_sell_purchase` VALUES (19, 123, 'wyn3', 2, 65.80, 131.60, '190', 1, '2023-06-30 10:15:27', '2023-06-30 10:15:27', 77);
INSERT INTO `tb_sell_purchase` VALUES (20, 124, 'wyn3', 2, 25.00, 275.00, '172', 1, '2023-09-27 14:25:47', '2023-09-27 14:25:47', 87);
INSERT INTO `tb_sell_purchase` VALUES (21, 125, 'wyn3', 2, 22.81, 296.53, '172', 1, '2023-09-27 14:26:03', '2023-09-27 14:26:03', 71);
INSERT INTO `tb_sell_purchase` VALUES (22, 126, 'wyn3', 2, 22.81, 296.53, '172', 1, '2023-09-27 14:26:15', '2023-09-27 14:26:15', 71);
INSERT INTO `tb_sell_purchase` VALUES (23, 127, 'wangya', 2, 2.00, 6.00, '172', 1, '2023-09-27 14:26:17', '2023-09-27 14:26:17', 143);
INSERT INTO `tb_sell_purchase` VALUES (24, 128, 'wangya', 2, 2.00, 6.00, '172', 1, '2023-09-27 14:26:19', '2023-09-27 14:26:19', 143);
INSERT INTO `tb_sell_purchase` VALUES (25, 129, 'wyn3', 2, 22.81, 45.62, '172', 1, '2023-09-27 14:28:31', '2023-09-27 14:28:31', 71);
INSERT INTO `tb_sell_purchase` VALUES (26, 130, 'wyn3', 2, 324.00, 648.00, '172', 1, '2023-09-27 14:28:36', '2023-09-27 14:28:36', 80);
INSERT INTO `tb_sell_purchase` VALUES (27, 130, 'zhangxukun', 2, 15.80, 31.60, '172', 1, '2023-09-27 14:28:36', '2023-09-27 14:28:36', 78);
INSERT INTO `tb_sell_purchase` VALUES (28, 131, 'wyn3', 2, 22.81, 22.81, '172', 1, '2023-09-27 14:29:30', '2023-09-27 14:29:30', 71);
INSERT INTO `tb_sell_purchase` VALUES (29, 132, 'wyn3', 2, 65.80, 65.80, '172', 1, '2023-09-27 14:30:02', '2023-09-27 14:30:02', 77);
INSERT INTO `tb_sell_purchase` VALUES (30, 133, 'wyn3', 2, 22.81, 68.43, '172', 1, '2023-09-27 14:32:44', '2023-09-27 14:32:44', 71);
INSERT INTO `tb_sell_purchase` VALUES (31, 134, 'wangya', 2, 2.00, 36.00, '172', 1, '2023-09-27 14:33:04', '2023-09-27 14:33:04', 143);
INSERT INTO `tb_sell_purchase` VALUES (32, 135, 'zhangxukun', 2, 15.80, 189.60, '172', 1, '2023-09-27 14:34:41', '2023-09-27 14:34:41', 78);
INSERT INTO `tb_sell_purchase` VALUES (33, 136, 'wangya', 2, 2.00, 2.00, '172', 1, '2023-09-27 14:34:46', '2023-09-27 14:34:46', 143);
INSERT INTO `tb_sell_purchase` VALUES (34, 137, 'wangya', 2, 2.00, 2.00, '172', 1, '2023-09-27 14:35:33', '2023-09-27 14:35:33', 143);
INSERT INTO `tb_sell_purchase` VALUES (35, 138, 'admin', 2, 79.00, 158.00, '172', 1, '2023-09-27 14:36:15', '2023-09-27 14:36:15', 144);
INSERT INTO `tb_sell_purchase` VALUES (36, 139, 'admin', 2, 79.00, 158.00, '172', 1, '2023-09-27 14:36:52', '2023-09-27 14:36:52', 144);
INSERT INTO `tb_sell_purchase` VALUES (37, 140, 'wyn3', 2, 22.81, 68.43, '172', 1, '2023-09-27 14:37:15', '2023-09-27 14:37:15', 71);
INSERT INTO `tb_sell_purchase` VALUES (38, 141, 'wyn3', 2, 22.81, 387.77, '172', 1, '2023-09-27 14:37:53', '2023-09-27 14:37:53', 71);
INSERT INTO `tb_sell_purchase` VALUES (39, 142, 'wyn3', 2, 123.00, 123.00, '172', 1, '2023-09-27 14:43:42', '2023-09-27 14:43:42', 66);
INSERT INTO `tb_sell_purchase` VALUES (40, 143, 'admin', 2, 800.00, 800.00, '172', 1, '2023-09-27 14:44:34', '2023-09-27 14:44:34', 146);
INSERT INTO `tb_sell_purchase` VALUES (41, 144, 'admin', 2, 111111.00, 111111000000000.00, '172', 1, '2023-09-27 15:07:23', '2023-09-27 15:07:23', 2120);
INSERT INTO `tb_sell_purchase` VALUES (42, 144, 'admin', 2, 111111.00, 111111000000000.00, '172', 1, '2023-09-27 15:07:23', '2023-09-27 15:07:23', 1199);
INSERT INTO `tb_sell_purchase` VALUES (43, 145, 'wyn3', 2, 22.81, 22.81, '172', 1, '2023-09-27 15:08:28', '2023-09-27 15:08:28', 71);
INSERT INTO `tb_sell_purchase` VALUES (44, 146, 'wyn3', 2, 22.81, 22.81, '172', 1, '2023-09-27 15:11:18', '2023-09-27 15:11:18', 71);
INSERT INTO `tb_sell_purchase` VALUES (45, 147, 'wyn3', 2, 345.00, 345.00, '186', 1, '2023-09-27 15:14:38', '2023-09-27 15:14:38', 70);
INSERT INTO `tb_sell_purchase` VALUES (46, 148, 'admin', 2, 111111.00, 111111.00, '172', 1, '2023-09-27 15:21:03', '2023-09-27 15:21:03', 2120);
INSERT INTO `tb_sell_purchase` VALUES (47, 149, 'admin', 2, 111111.00, 111111.00, '172', 1, '2023-09-27 15:30:32', '2023-09-27 15:30:32', 2122);
INSERT INTO `tb_sell_purchase` VALUES (48, 150, 'admin', 2, 9999999999999.00, 9999999999999.00, '172', 1, '2023-09-27 15:54:40', '2023-09-27 15:54:40', 152);
INSERT INTO `tb_sell_purchase` VALUES (49, 151, 'admin', 2, 9999999999999.00, 9999999999999.00, '187', 1, '2023-09-27 16:00:35', '2023-09-27 16:00:35', 152);
INSERT INTO `tb_sell_purchase` VALUES (50, 152, 'admin', 2, 9999.00, 29997.00, '187', 1, '2023-09-27 16:00:38', '2023-09-27 16:00:38', 152);
INSERT INTO `tb_sell_purchase` VALUES (51, 153, 'admin', 2, 9999.00, 309969.00, '172', 1, '2023-09-27 16:07:11', '2023-09-27 16:07:11', 152);
INSERT INTO `tb_sell_purchase` VALUES (52, 154, 'aaaaaa', 2, 99999999.00, 99999999.00, '172', 1, '2023-09-27 17:07:08', '2023-09-27 17:07:08', 2140);
INSERT INTO `tb_sell_purchase` VALUES (53, 155, 'admin', 2, 9999.00, 49995.00, '172', 1, '2023-09-27 17:09:01', '2023-09-27 17:09:01', 152);
INSERT INTO `tb_sell_purchase` VALUES (54, 156, 'admin', 2, 9999.00, 9999.00, '172', 1, '2023-09-27 17:24:33', '2023-09-27 17:24:33', 152);
INSERT INTO `tb_sell_purchase` VALUES (55, 157, 'aaaaaa', 2, 99999999.00, 99999999.00, '172', 1, '2023-09-27 17:27:15', '2023-09-27 17:27:15', 2140);
INSERT INTO `tb_sell_purchase` VALUES (56, 158, 'aaaaaa', 2, 99999999.00, 99999999.00, '172', 1, '2023-09-27 17:27:30', '2023-09-27 17:27:30', 2140);
INSERT INTO `tb_sell_purchase` VALUES (57, 159, 'admin', 2, 233.00, 13980000.00, '172', 1, '2023-09-27 17:27:53', '2023-09-27 17:27:53', 2144);
INSERT INTO `tb_sell_purchase` VALUES (58, 160, 'admin', 2, 111.00, 111.00, '172', 1, '2023-09-27 17:35:48', '2023-09-27 17:35:48', 2143);
INSERT INTO `tb_sell_purchase` VALUES (59, 167, 'aaaaaa', 2, 6.88, 13.76, '191', 1, '2023-10-27 14:20:29', '2023-10-27 14:20:29', 2215);
INSERT INTO `tb_sell_purchase` VALUES (60, 167, 'aaaaaa', 2, 18.88, 18.88, '191', 1, '2023-10-27 14:20:29', '2023-10-27 14:20:29', 2212);
INSERT INTO `tb_sell_purchase` VALUES (61, 168, 'aaaaaa', 2, 6.88, 13.76, '191', 1, '2023-10-27 14:23:54', '2023-10-27 14:23:54', 2215);
INSERT INTO `tb_sell_purchase` VALUES (62, 168, 'aaaaaa', 2, 44.98, 44.98, '191', 1, '2023-10-27 14:23:54', '2023-10-27 14:23:54', 2209);
INSERT INTO `tb_sell_purchase` VALUES (63, 169, 'hh1', 2, 6.98, 6.98, '191', 1, '2023-10-27 14:30:47', '2023-10-27 14:30:47', 2210);
INSERT INTO `tb_sell_purchase` VALUES (64, 169, 'hh1', 2, 9.98, 9.98, '191', 1, '2023-10-27 14:30:47', '2023-10-27 14:30:47', 2211);

-- ----------------------------
-- Table structure for tb_shoppingcart
-- ----------------------------
DROP TABLE IF EXISTS `tb_shoppingcart`;
CREATE TABLE `tb_shoppingcart`  (
  `shopping_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车',
  `order_id` int(11) NOT NULL COMMENT '产品',
  `count` int(11) NOT NULL,
  `own_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  PRIMARY KEY (`shopping_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 80 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_shoppingcart
-- ----------------------------
INSERT INTO `tb_shoppingcart` VALUES (21, 145, 1, 'a123456', '2023-09-27 14:39:47', '2023-09-27 14:39:47');
INSERT INTO `tb_shoppingcart` VALUES (27, 146, 2, 'zzz', '2023-09-27 14:45:42', '2023-09-27 14:45:42');
INSERT INTO `tb_shoppingcart` VALUES (38, 70, 1, 'lisi', '2023-09-27 15:18:48', '2023-09-27 15:18:48');
INSERT INTO `tb_shoppingcart` VALUES (45, 2142, 2, 'qwe', '2023-09-27 17:09:23', '2023-09-27 17:09:49');
INSERT INTO `tb_shoppingcart` VALUES (49, 2144, 1, 'hh1', '2023-10-19 15:41:50', '2023-10-19 15:41:50');
INSERT INTO `tb_shoppingcart` VALUES (53, 2144, 1, 'gaoge', '2023-10-20 11:24:38', '2023-10-20 11:24:38');
INSERT INTO `tb_shoppingcart` VALUES (55, 2198, 1, 'gaoge', '2023-10-20 17:39:25', '2023-10-20 17:39:25');
INSERT INTO `tb_shoppingcart` VALUES (72, 2220, 1, 'hh1', '2023-10-26 14:06:06', '2023-10-26 14:06:16');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户表',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓名',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话',
  `identity_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '编码',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地址',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'user' COMMENT 'user普通用户，expert专家，admin管理员 , bank银行用户',
  `create_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  `integral` int(11) DEFAULT 500 COMMENT '积分500',
  `credit` int(11) DEFAULT 5 COMMENT '信誉1，2，3，4，5',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`user_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('aaaaaa', '$2a$10$dtXA4gy8nI227/QfMLky0OMt5K7/4tL6K9xbKiD5KcbfWy.hFU72G', 'aaaaaa', '132133245', '888888888', '广西桂林', 'user', '2023-09-27 16:10:32', '2023-09-27 17:37:20', 0, 0, 'rongxiaotong.gif', 'aaaaaa');
INSERT INTO `tb_user` VALUES ('admin', '$2a$10$ThTAFZUmLnCMX98ueT5wZe51tZeRxHXV47/emCgd9NpHluyB7r9Wa', '管理员', '17894286579', '370343199612012718', '山1231123123', 'admin', '2021-09-01 09:00:51', '2023-10-16 15:35:47', 0, 0, 'c8c855f1825146eea5ae2ce11e3538fa.jpg', '张三555');
INSERT INTO `tb_user` VALUES ('gaoge', '$2a$10$Kje9qsCRrPA8/RAZN3j1teMM.Vfn9AaI7kh95mbVwAT/yY.3EZKxi', '高歌', '15649599256', '370343199612016352', '山东省临沂市', 'expert', '2021-08-27 16:05:20', '2023-10-20 17:27:48', 0, 0, 'f1bd96ecafba46cca7a0c6af92d84fbd.jpg', '高歌');
INSERT INTO `tb_user` VALUES ('hh1', '$2a$10$WQtfgfHofxahXCz0nvbQT.8//GM4A62.oXN9TZ86v4bMoVbVcYxXm', 'hh1', '1111111111', '2212312123', '山6666', 'user', '2023-10-16 16:12:07', '2023-10-16 17:23:11', 500, 5, 'rongxiaotong.gif', '张1');
INSERT INTO `tb_user` VALUES ('hhh', '$2a$10$KRRfqd1XPbzv6CG6Hnego.usVBglTdKkNQnC/5OnHU12BgyXebkye', '666', '666666666', '55555555555', '广西桂林', 'user', '2023-09-27 15:25:29', '2023-09-27 15:25:29', 0, 0, 'rongxiaotong.gif', NULL);
INSERT INTO `tb_user` VALUES ('hyx', '$2a$10$jf2fVp6K4uUP9.MULsRz5.52AlK982fxL0D0/ywZZzTs/gLxfLt.O', '陈辉', '43534534', '3445435', '6773333', 'expert', '2023-09-27 15:09:50', '2023-09-27 15:11:47', 0, 0, 'rongxiaotong.gif', NULL);
INSERT INTO `tb_user` VALUES ('kk', '$2a$10$9HGireit5y0Xyo9MiP5U8uE8yZlGlJasJGl8FjW8Lt5HDWgqLPDnS', 'kk', '1145213262', '122313213', '广西桂林', 'user', '2023-10-16 15:46:13', '2023-10-16 15:49:28', 500, 5, 'rongxiaotong.gif', '王');
INSERT INTO `tb_user` VALUES ('kkkk', '$2a$10$sqqnB/VARIh/mka6ykzY3OsmwxZ.4FCIxCOZizmbPT2zOerYx/Dxm', 'kk01', '1752135313', '2311345465465465', '广西桂林', 'user', '2023-10-13 19:09:03', '2023-10-13 19:11:19', 500, 5, 'rongxiaotong.gif', '王');
INSERT INTO `tb_user` VALUES ('lisi', '$2a$10$Kje9qsCRrPA8/RAZN3j1teMM.Vfn9AaI7kh95mbVwAT/yY.3EZKxi', 'lisi', '15623652365', '371323199601062719', '山东省临沂市', 'user', '2022-08-19 16:39:11', '2023-09-27 16:05:56', 0, 0, '4c2d9f1c2b424016aa2ed1f3ceb2654a.webp', '李思');
INSERT INTO `tb_user` VALUES ('lzh', '$2a$10$Kje9qsCRrPA8/RAZN3j1teMM.Vfn9AaI7kh95mbVwAT/yY.3EZKxi', 'llllzzzzhhhh', '15621367568', '373312199801032719', '山东省威海市', 'user', '2022-07-22 11:05:54', '2022-09-07 16:45:53', 0, 0, 'ac10c6dc98d14afda5f09ba81f286197.jpg', '李增虎');
INSERT INTO `tb_user` VALUES ('oo', '123123', 'oo', NULL, NULL, NULL, 'user', '2023-10-16 16:02:30', '2023-10-16 16:08:08', 500, 5, 'rongxiaotong.gif', NULL);
INSERT INTO `tb_user` VALUES ('wangya', '$2a$10$Kje9qsCRrPA8/RAZN3j1teMM.Vfn9AaI7kh95mbVwAT/yY.3EZKxi', 'wangya', '13792449255', '370213198911120506', '山东省青岛市', 'user', '2022-09-08 10:14:22', '2022-09-08 10:19:34', 0, 0, 'rongxiaotong.gif', '王娅');
INSERT INTO `tb_user` VALUES ('wdy', '$2a$10$LV5dXrnOoTScks1VwusJReXW6T5LzXpYGmr2W1lIC9SYmiI4t9c3C', '王多鱼', '1454654123', '23265777777777', '广东东莞', 'expert', '2023-10-24 16:21:00', '2023-10-24 16:43:24', 500, 5, 'rongxiaotong.gif', '王多鱼1');
INSERT INTO `tb_user` VALUES ('wyn', '$2a$10$Kje9qsCRrPA8/RAZN3j1teMM.Vfn9AaI7kh95mbVwAT/yY.3EZKxi', 'wanayuna', '18711236658', '370123200008123456', '山东省威海市', 'expert', '2021-08-27 16:05:20', '2022-09-01 11:21:11', 0, 0, 'f1bd96ecafba46cca7a0c6af92d84fbd.jpg', '李玉娜');
INSERT INTO `tb_user` VALUES ('wyn3', '$2a$10$Kje9qsCRrPA8/RAZN3j1teMM.Vfn9AaI7kh95mbVwAT/yY.3EZKxi', 'wyn3', '15630429628', '324624861233056852', '山东省青岛市', 'user', '2022-04-11 11:36:03', '2022-08-18 15:04:18', 0, 0, 'bd12eba3a9a24d89845ebbdb7fbff448.jpg', '王亚楠');
INSERT INTO `tb_user` VALUES ('zhangsan', '$2a$10$Kje9qsCRrPA8/RAZN3j1teMM.Vfn9AaI7kh95mbVwAT/yY.3EZKxi', 'zhangsan', '13792499274', '370343199609176060', '山东省青岛市', 'user', '2022-08-19 16:37:10', '2022-08-19 16:37:10', 0, 0, 'bd12eba3a9a24d89845ebbdb7fbff448.jpg', '张三');
INSERT INTO `tb_user` VALUES ('zhangxukun', '$2a$10$Kje9qsCRrPA8/RAZN3j1teMM.Vfn9AaI7kh95mbVwAT/yY.3EZKxi', 'kelven', '13544545454', '370123200008083422', '山东省临沂市', 'user', '2021-08-27 16:05:25', '2022-08-23 15:19:28', 0, 0, '2ae82e5cf7ca47c9ab516d37dccab5dd.jpg', '张旭坤');
INSERT INTO `tb_user` VALUES ('zwr', '$2a$10$Kje9qsCRrPA8/RAZN3j1teMM.Vfn9AaI7kh95mbVwAT/yY.3EZKxi', '张文瑞', '15623652222', '111111111111111111', '山东省威海市', 'user', '2021-08-30 09:20:24', '2022-08-23 15:23:34', 0, 0, 'bd12eba3a9a24d89845ebbdb7fbff449.jpg', '张文瑞');

-- ----------------------------
-- Function structure for sfn_GetSimilar_Rate
-- ----------------------------
DROP FUNCTION IF EXISTS `sfn_GetSimilar_Rate`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `sfn_GetSimilar_Rate`(s1 VARCHAR(64),s2 VARCHAR(64)) RETURNS float
BEGIN
declare l1 int default 0;
declare l2 int default 0;
declare i int default 0;
declare _ss varchar(2) ;
declare j int default 0;
declare sum int default 0;

set l1=CHAR_LENGTH(s1);
set l2=CHAR_LENGTH(S2);
IF l1=0 THEN RETURN 0;
END IF;
IF l2=0 THEN RETURN 0;
END IF;

SET i=0;
set sum=0;
myloop1:LOOP
	SET i=i+1;
	IF i>l1 THEN LEAVE myloop1;
	end if;
	SET _ss=substr(s1,i,1);
	SET j=0;
	myloop2:LOOP
		set j=j+1;
		if j>l2 then 
		   LEAVE myloop2;
		end if;
		if _ss=substr(s2,j,1) then 
		  set sum=sum+1;
		end if;
	END LOOP myloop2;

END LOOP myloop1;

RETURN sum/l2;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
