/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : myforum

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 10/01/2020 21:34:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `note_id` int(11) NULL DEFAULT NULL COMMENT '评论文章的id',
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '评论内容',
  `from_id` int(11) NULL DEFAULT NULL COMMENT '评论用户id',
  `to_id` int(11) NULL DEFAULT NULL COMMENT '评论目标用户id',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (2, 10, '等着我啊！！！！嘻嘻嘻嘻', 8, 7);
INSERT INTO `comment` VALUES (4, 13, '你娃个毛线', 1, 2);
INSERT INTO `comment` VALUES (5, 7, '略略略\r\n哈哈哈哈哈', 2, 5);
INSERT INTO `comment` VALUES (6, 7, '略略略\r\n哈哈哈哈哈', 2, 5);
INSERT INTO `comment` VALUES (7, 7, '略略略\r\n哈哈哈哈哈', 2, 5);
INSERT INTO `comment` VALUES (8, 7, '略略略\r\n哈哈哈哈哈', 2, 5);
INSERT INTO `comment` VALUES (9, 7, '略略略\r\n哈哈哈哈哈', 2, 5);
INSERT INTO `comment` VALUES (10, 7, '略略略\r\n哈哈哈哈哈', 2, 5);
INSERT INTO `comment` VALUES (11, 10, '快来Q我把！！！快来Q我把！！！快来Q我把！！！快来Q我把！！！快来Q我把！！！快来Q我把！！！快来Q我把！！！快来Q我把！！！快来Q我把！！！快来Q我把！！！快来Q我把！！！快来Q我把！！！快来Q我把！！！快来Q我把！！！', 1, 7);
INSERT INTO `comment` VALUES (12, 14, '不该\r\n', 1, 1);
INSERT INTO `comment` VALUES (13, 14, '看情况吧', 1, 1);
INSERT INTO `comment` VALUES (14, 14, '打暑假工赚钱啊，可以赚点学费', 8, 1);
INSERT INTO `comment` VALUES (15, 13, '强哥你好', 5, 2);
INSERT INTO `comment` VALUES (16, 14, '我是阿强😫', 2, 1);
INSERT INTO `comment` VALUES (17, 14, '看个毛线😤\r\n', 2, 1);
INSERT INTO `comment` VALUES (18, 14, '😱', 2, 1);
INSERT INTO `comment` VALUES (19, 14, '😱', 2, 1);
INSERT INTO `comment` VALUES (20, 14, '😱', 2, 1);
INSERT INTO `comment` VALUES (21, 14, '布置', 2, 1);
INSERT INTO `comment` VALUES (22, 14, '看啥', 1, 1);
INSERT INTO `comment` VALUES (24, 14, '惊讶不', 1, 2);
INSERT INTO `comment` VALUES (25, 14, '牛逼不', 1, 2);
INSERT INTO `comment` VALUES (26, 14, '哈哈哈哈哈', 1, 1);
INSERT INTO `comment` VALUES (27, 14, '别撞了', 1, 8);
INSERT INTO `comment` VALUES (28, 9, '物业直播请找me🤤', 1, 5);
INSERT INTO `comment` VALUES (29, 14, '就赶快撒打发教案课件了', 1, 1);
INSERT INTO `comment` VALUES (30, 14, '特瑞特热', 1, 1);
INSERT INTO `comment` VALUES (31, 14, '发帖格瑞特', 1, 8);
INSERT INTO `comment` VALUES (32, 18, '学习好', 1, 9);
INSERT INTO `comment` VALUES (33, 18, '这还用说', 1, 9);
INSERT INTO `comment` VALUES (34, 7, '好好说话行不\r\n', 8, 2);
INSERT INTO `comment` VALUES (35, 7, '好好说话行不\r\n', 8, 2);
INSERT INTO `comment` VALUES (36, 7, '哈哈哈哈哈哈哈', 8, 1);
INSERT INTO `comment` VALUES (42, 7, '略个啥', 1, 2);
INSERT INTO `comment` VALUES (44, 19, '呵呵', 9, 5);
INSERT INTO `comment` VALUES (45, 23, '官方通知:请修改姓名', 8, 5);
INSERT INTO `comment` VALUES (46, 19, '我不好\r\n', 8, 5);
INSERT INTO `comment` VALUES (47, 7, '呵呵', 8, 1);
INSERT INTO `comment` VALUES (48, 7, '删了', 8, 1);
INSERT INTO `comment` VALUES (49, 7, '啊啊啊啊', 8, 2);
INSERT INTO `comment` VALUES (50, 23, '测试评论', 8, 2);
INSERT INTO `comment` VALUES (51, 23, '我去，终于好了', 8, 8);
INSERT INTO `comment` VALUES (52, 7, '嘎嘎嘎', 8, 2);
INSERT INTO `comment` VALUES (53, 23, '😳😳😳', 1, 8);
INSERT INTO `comment` VALUES (54, 23, '🤐', 1, 8);
INSERT INTO `comment` VALUES (55, 18, '🤔🤔🤔🤔', 1, 9);
INSERT INTO `comment` VALUES (56, 28, '真好', 1, 3);

-- ----------------------------
-- Table structure for note
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note`  (
  `note_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '发帖人姓名',
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标题',
  `essay` varchar(10000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '发帖时间',
  PRIMARY KEY (`note_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of note
-- ----------------------------
INSERT INTO `note` VALUES (7, 'xianing@qq.com', '我的第一个帖子', '李福根撒旦克里夫就看到了房价开始打飞机\r\n方式打发手动阀撒旦发射点\r\n方式打发手动阀撒发射点发生是\r\nfasfdsafsafasdf\r\n范德萨发生范德萨发达发放\r\n反对撒发射点发生士大夫\r\n幅度萨芬', '2019-08-03 17:28:27');
INSERT INTO `note` VALUES (8, 'xianing@qq.com', '121245', '风格的萨格发生过事故撒旦规范施工速度快JFK拉萨大家发开始了开发大厦开了房间ask链接看看就', '2019-06-26 17:42:11');
INSERT INTO `note` VALUES (9, 'xianing@qq.com', '午夜直播', 'package com.solo.coderiver.comments.repository;\r\n\r\nimport com.solo.coderiver.comments.dataobject.CommentsInfo;\r\nimport org.springframework.data.jpa.repository.JpaRepository;\r\n\r\nimport java.util.List;\r\n\r\npublic interface CommentsInfoRepository extends JpaRepository<CommentsInfo, String> {\r\n\r\n    List<CommentsInfo> findByOwnerId(String ownerId);\r\n}\r\n\r\n作者：solocoder\r\n链接：https://juejin.im/post/5be2c213e51d453dfe02d406\r\n来源：掘金\r\n著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。', '2019-06-28 00:48:55');
INSERT INTO `note` VALUES (10, 'xiaxiaoting@qq.com', '我注册了新账号', '快来Q我把！！！', '2019-06-28 23:05:46');
INSERT INTO `note` VALUES (12, '1941512307@qq.com', 'CSS 网络安全字体组合', 'font-family 属性应该使用若干种字体名称作为回退系统，以确保浏览器/操作系统之间的最大兼容性。如果浏览器不支持第一个字体，则会尝试下一个。\r\n\r\n请以您喜欢的字体开始，并以通用字体系列结束，以便使浏览器在通用系统中挑选相似的字体，如果没有其他字体可用的话：\r\n实例\r\n\r\np{font-family:\'Times New Roman\', Times, serif}', '2019-07-07 21:13:07');
INSERT INTO `note` VALUES (13, '1941512304@qq.com', 'jsp颜色大全', '顏色名稱 	代碼 	\r\n\r\n顏色\r\nmaroon 	#800000 	 \r\ndarkred 	#8B0000 	 \r\nbrown 	#A52A2A 	 \r\nfirebrick 	#B22222 	 \r\ncrimson 	#DC143C 	 \r\nred 	#FF0000 	 \r\n\r\n桃红~紛紅\r\n\r\n顏色名稱 	代碼 	\r\n\r\n顏色\r\nmediumvioletred 	#C71585 	 \r\npalevioletred 	#D87093 	 \r\ndeeppink 	#FF1493 	 \r\nfuchsia(magenta) 	#FF00FF 	 \r\nhotpink 	#FF69B4 	 \r\npink 	#FFC0CB 	 \r\nlightpink 	#FFB6C1 	 \r\nmistyrose 	#FFE4E1 	 \r\nlavenderblush 	#FFF0F5 	 \r\n\r\n', '2019-07-07 21:10:31');
INSERT INTO `note` VALUES (14, '1941512303@qq.com', '放假该去打工吗？', '放假该去打工吗？？/????', '2019-07-04 17:56:35');
INSERT INTO `note` VALUES (15, '1941512303@qq.com', 'bug', 'bug好多！！！', '2019-07-04 16:53:55');
INSERT INTO `note` VALUES (16, '1941512303@qq.com', '修复成功！', 'bug修复成功！', '2019-07-04 17:58:21');
INSERT INTO `note` VALUES (17, '1941512303@qq.com', 'CSS3 opacity 属性', '实例\r\n\r\n设置 div 元素的不透明级别：\r\ndiv\r\n{\r\nopacity:0.5;\r\n}', '2019-07-05 13:49:56');
INSERT INTO `note` VALUES (18, '13523567950@qq.com', '署假大学生去打工好吗', '放署假了，是出去打工好呢，还是在家学习好呢？:孩子今年大二了，还想让他考研，还想让他挣点学费，难以决策。', '2019-07-07 16:36:43');
INSERT INTO `note` VALUES (19, 'xiaguoyun@qq.com', '你好', '我就是就是傻逼补习班', '2019-07-07 20:41:29');
INSERT INTO `note` VALUES (20, '13523567950@qq.com', '测试分页', '飞洒地方京哈上帝就发哈交换机', '2019-08-04 12:14:37');
INSERT INTO `note` VALUES (21, '1941512307@qq.com', '测试1', '测试1', '2019-08-04 15:35:54');
INSERT INTO `note` VALUES (22, '1941512307@qq.com', 'MySQL 排序', '\r\nmysql> use RUNOOB;\r\nDatabase changed\r\nmysql> SELECT * from runoob_tbl ORDER BY submission_date ASC;\r\n+-----------+---------------+---------------+-----------------+\r\n| runoob_id | runoob_title  | runoob_author | submission_date |\r\n+-----------+---------------+---------------+-----------------+\r\n| 3         | 学习 Java   | RUNOOB.COM    | 2015-05-01      |\r\n| 4         | 学习 Python | RUNOOB.COM    | 2016-03-06      |\r\n| 1         | 学习 PHP    | 菜鸟教程  | 2017-04-12      |\r\n| 2         | 学习 MySQL  | 菜鸟教程  | 2017-04-12      |\r\n+-----------+---------------+---------------+-----------------+\r\n4 rows in set (0.01 sec)\r\n \r\nmysql> SELECT * from runoob_tbl ORDER BY submission_date DESC;\r\n+-----------+---------------+---------------+-----------------+\r\n| runoob_id | runoob_title  | runoob_author | submission_date |\r\n+-----------+---------------+---------------+-----------------+\r\n| 1         | 学习 PHP    | 菜鸟教程  | 2017-04-12      |\r\n| 2         | 学习 MySQL  | 菜鸟教程  | 2017-04-12      |\r\n| 4         | 学习 Python | RUNOOB.CO', '2019-08-04 15:38:02');
INSERT INTO `note` VALUES (23, '1941512307@qq.com', 'MySQL GROUP BY 语句 ', 'GROUP BY 语法\r\n\r\nSELECT column_name, function(column_name)\r\nFROM table_name\r\nWHERE column_name operator value\r\nGROUP BY column_name;', '2019-08-04 15:40:39');
INSERT INTO `note` VALUES (24, '1941512305@qq.com', '商务部：中国相关企业暂停新的美国农产品采购', '中新网8月6日电 据商务部网站消息，针对“中国相关企业暂停新的美国农产品采购”一事，商务部新闻发言人6日表示，据了解，由于日前美方宣称拟对3000亿美元中国输美商品加征10%关税，严重违背中美两国元首大阪会晤共识，国务院关税税则委员会对8月3日后新成交的美国农产品采购暂不排除进口加征关税，中国相关企业已暂停采购美国农产品。\r\n中方有关部门表示，中国市场容量大，进口美国优质农产品前景光明，但希望美方认真落实中美两国元首大阪会晤达成的共识，言而有信，落实承诺，为两国农业领域合作创造必要条件。', '2019-08-06 12:04:21');
INSERT INTO `note` VALUES (25, '1941512305@qq.com', '台东发生游览车与大货车相撞事故 6名大陆游客轻伤', '中新网8月6日电 据台湾《联合报》报道，台湾台东县南回公路路段，5日下午骤降瞬间大雨，一辆搭载大陆游客团北上的游览车，晚间6点25分行经台9线418.5公里处，与对向车道南下行驶的大货车发生擦撞事故，导致游览车上6名陆客受到轻伤送医治疗。\r\n多良派出所警察获报立即前往处理，而现场因肇事车辆占据三线车道，警察赶紧架设夜间警告设施外，避免2次事故发生，并实施交通管制维持单线双向通行。\r\n\r\n警方表示，5日晚间8点25分，已排除事故现场，恢复双向通车，而详细肇事原因正由警方厘清中。', '2019-08-06 12:06:19');
INSERT INTO `note` VALUES (26, '1941512305@qq.com', '魅族锤子们的最后时刻：黄章与罗永浩理想主义湮灭', '未来依然充满变数。即便是头部厂商，也时刻面临着重新洗牌的可能。5G的到来或许会带来新一轮的换机潮，位列前五的几家公司都有可能被重新排序。\r\n\r\n期间，属于这些理想主义者们的空间已经逐渐逼仄。\r\n\r\n但他们依旧没有停止折腾。\r\n\r\n刘作虎继续“不将就”，罗永浩已经开始发力电子烟项目，黄章还要继续在魅族上拼尽全力。\r\n\r\n他们没有停止脚步，某些程度上，他们也成功了，并被包装成让公众津津乐道的案例，因为，失败者不会在历史上留下名字。', '2019-08-06 12:09:30');
INSERT INTO `note` VALUES (27, '1941512305@qq.com', '叶一茜晒母女聊天记录，森碟直女式回复惜字如金，堪称话题终结者', '森碟现在才只有11岁，至今还没有公开的个人社交账号，网友们平日里最喜欢对田亮开的玩笑就是，赶紧给森碟开微博，好取关你。但是田亮至今也没有给女儿开通过，不然可就脱粉严重啊。\r\n不过森碟倒是有自己的wx聊天账号，方便和家人联系，而且随着认识的字越来越多，不局限于发语音了，还能发文字。\r\n8月5日，叶一茜就分享了和森碟的wx聊天记录，并幽默地说道：和森碟的聊天，每一句都是ending！', '2019-08-06 12:11:23');
INSERT INTO `note` VALUES (28, '1941512305@qq.com', '一线｜吴昕与小3岁男星“姐弟恋”曝光？女方团队回应并未否认', '8月6日，有网友晒出吴昕“恋情曝光”的照片。吴昕深夜与一名身穿白T的男子同行，并一同进入小区的单元门。此前吴昕也曾在机场被拍到与表弟及该男子一起出行，当时该男子担任吴昕姐弟俩的“司机”。\r\n随后，这名男子被扒出身份，原来是男星郑凯，出生于1986年3月11日，比1983年出生的吴昕小3岁，两人曾在多个综艺节目中有过合作，他与吴昕2011年因《倾世皇妃》相识，2016年两人还共同在综艺节目中合作表演热舞，之后又再度合作网综《遇见足球城》\r\n对此，《一线》向吴昕工作人员求证，对方却不置可否，只说“艺人私事我们不清楚”。', '2019-08-06 12:13:52');
INSERT INTO `note` VALUES (29, '1941512305@qq.com', '易烊千玺王俊凯王源同框庆TFBOYS出道6周年，画面引回忆杀', '在8月6号，正好是TFBOYS出道6周年，TFBOYS的官微踩点发文庆祝，并晒出了王俊凯、王源和千玺三人同框照片，他们一起捧蛋糕拍照，每位颜值担当，而且充满着青春与活力，那温馨的画面引起众多粉丝的回忆，许多年轻人都听过他们的歌，现相继留言评论送祝福。\r\n\r\n不同年代的人所喜欢的偶像大不相同，以前是刘德华、周星驰那群香港明星受观众喜爱，后来到周杰伦、林俊杰等歌手成为许多80、90后的偶像。然后再轮TFBOYS成为不少95、00后的爱豆，如今TFBOYS中的三位成员都长大成年，王俊凯、王源和易烊千玺全部年满十八岁，每位都考上心目中的理想大学。\r\n在8月6号，正好是TFBOYS出道6周年，TFBOYS的官微踩点发文庆祝，并晒出了王俊凯、王源和千玺三人同框照片，他们一起捧蛋糕拍照，每位颜值担当，而且充满着青春与活力，那温馨的画面引起众多粉丝的回忆，许多年轻人都听过他们的歌，现相继留言评论送祝福。\r\nTFBOYS出道6年来，一直圈粉无数，热度也是有增无减，王俊凯、易烊千玺和王源从刚开始稚嫩懵懂的模样变得越来越成熟稳重，兄弟三人合作创作的歌曲一直都是充满着正能量和朝气，并一直从事一些公益类型的活动，也曾连续被邀请上央视春晚舞台，可以说TFBOYS影响了许多年轻听众。\r\n三人在6号晚上同框捧着蛋糕庆祝出道6周年，难免会引起回忆杀，如今易烊千玺、王俊凯和王源3位队友从青涩的少年变成娱乐圈当红艺人，几位演艺事业也越变越宽，不仅会唱歌跳舞，而且开始涉足影视综行业。\r\n在今天的深夜，王俊凯、易烊千玺和王源3人不仅晒出同框合影照，而且还配同样的文案发微博，说到：“TFBOYS特别六，一起大步向前走”。祝贺该组合出道六周年，希望千玺、王俊凯和王源3位年轻人不忘初心，一直认真去创作出更多优秀的音乐以及影视剧给观众、粉丝们，时代的大舞台永远属于年轻人的，敢问你看好TFBOYS组合的星途吗？', '2019-08-06 12:15:37');
INSERT INTO `note` VALUES (30, '1941512303@qq.com', '周三晚', '大家都觉得加拿大等你难兄难弟你你你想你你到哪到哪还真不行八点半不咸不淡爸爸先打叭叭叭那些江小白不对不对不补习摆大巴嘻哈对吧不打想。不行你下班大宝贝行吧行吧摆大巴行吧\r\n新疆大街记得记得八点半行吧\r\n', '2019-08-07 21:55:32');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '以用户Email作为登陆账号',
  `password` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `age` int(11) NULL DEFAULT 0 COMMENT '年龄',
  `phone` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话号码',
  `registertime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
  `imgurl` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '用户头像',
  `id` int(11) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '1941512303@qq.com', '123456', '男', 21, '15981856274', '2019-08-07 19:03:05', '棋士喜欢喜欢电话号', 'moren.jpg', 0, NULL);
INSERT INTO `user` VALUES (2, '1941512304@qq.com', '123456', '男', 10, '15981856274', '2019-08-04 12:30:48', '我强哥', 'moren.jpg', 0, NULL);
INSERT INTO `user` VALUES (3, '1941512305@qq.com', '123456', '女', 20, '15981856274', '2019-06-29 16:18:46', '1941512304@qq.com', 'moren.jpg', 0, NULL);
INSERT INTO `user` VALUES (4, '1941512306@qq.com', '123456', '男', 20, '15981856274', '2019-06-29 16:18:49', '1941512306@qq.com', 'moren.jpg', 0, NULL);
INSERT INTO `user` VALUES (5, 'xianing@qq.com', '123456', '男', 25, '15981856274', '2019-08-04 12:30:55', '呵呵哒', 'moren.jpg', 0, NULL);
INSERT INTO `user` VALUES (6, 'xiaguoyun@qq.com', '123456', '男', 24, '456454545454', '2019-08-04 12:30:58', 'xiaguoyun@qq.com', 'moren.jpg', 0, NULL);
INSERT INTO `user` VALUES (7, 'xiaxiaoting@qq.com', '123456', '女', 23, '121545453564', '2019-08-06 00:37:17', '夏夏夏小婷', 'moren.jpg', 0, NULL);
INSERT INTO `user` VALUES (8, '1941512307@qq.com', '123456', '男', 10, '5498754546456', '2019-08-04 12:31:04', '1941512307@qq.com', 'moren.jpg', 0, NULL);
INSERT INTO `user` VALUES (9, '2540889255@qq.com', '123456', '女', 20, '13523567950', '2019-09-28 17:17:38', '13523567950@qq.com', 'moren.jpg', 0, NULL);

SET FOREIGN_KEY_CHECKS = 1;
