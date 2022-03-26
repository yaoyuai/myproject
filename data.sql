DROP DATABASE IF EXISTS `data`;
CREATE DATABASE `data` DEFAULT CHARSET UTF8MB4 COLLATE UTF8MB4_GENERAL_CI;
USE `data`;


drop table  if EXISTS card_info;
-- 卡信息表
create table card_info(
	card_id int PRIMARY KEY AUTO_INCREMENT COMMENT '卡id',
	card_no varchar(50) UNIQUE COMMENT '卡号',
	card_money float COMMENT '卡余额',
	card_deposit int COMMENT '卡押金',
	card_ctime datetime COMMENT '卡创建时间',
	card_mtime datetime COMMENT '卡修改时间',
	state_id int COMMENT '状态id',
	apply_id int COMMENT '申请id',
	admin_id int COMMENT '管理员id'
);


drop table  if EXISTS user_info;
-- 就诊人信息表
create table user_info(
	user_id int PRIMARY key AUTO_INCREMENT COMMENT '就诊人id',
	user_name VARCHAR(50) COMMENT '就诊人姓名',
	user_age int COMMENT '就诊人年龄',
	user_sex char(1) COMMENT '性别',
	user_place VARCHAR(50) comment '籍贯',
	user_no varchar(50) COMMENT '证件号码',
	user_tel varchar(11) COMMENT '联系电话',
	user_address varchar(50) comment '现住址',
	user_ctime datetime COMMENT '就诊人创建时间',
	user_mtime datetime COMMENT '就诊人修改时间',
	card_id int COMMENT '卡id',
	state_id int COMMENT '状态id',
	admin_id int COMMENT '管理员id'
);


drop table  if EXISTS user_log;
-- 用户日志表
create  table user_log(
	log_id int PRIMARY key AUTO_INCREMENT COMMENT '就诊人日志id',
	log_cotent varchar(100) COMMENT '操作内容',
	log_ctime datetime COMMENT '日志创建时间',
	user_id int COMMENT '就诊人id'
);



drop table  if EXISTS bill_info;
-- 卡账户明细表
CREATE TABLE bill_info(
  bill_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '账户明细ID',
  bill_content VARCHAR(32) COMMENT '发生事项',
	bill_money VARCHAR(50) COMMENT '交易金额',
  user_id INT COMMENT '就诊人ID',
  admin_id INT COMMENT '管理员ID',
  card_id int COMMENT '卡id',
  state_id INT COMMENT '状态id',
  bill_ctime datetime COMMENT '创建时间',
  bill_mtime DATETIME COMMENT '更新时间'
)COMMENT='账务表';


drop table  if EXISTS scheduling_info;
-- 医生排班表
CREATE TABLE scheduling_info(
  scheduling_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '排班ID',
  doctor_id INT COMMENT '医生ID',
  admin_id INT COMMENT '管理员ID',
  scheduling_time varchar(50) COMMENT '排班时间',
  state_id INT COMMENT '状态id',
  scheduling_ctime datetime COMMENT '创建时间',
  scheduling_mtime DATETIME COMMENT '更新时间'
)COMMENT='排班表';




drop table  if EXISTS reserve_info;
-- 预约挂号表
CREATE TABLE reserve_info(
  reserve_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '预约挂号ID',
  reserve_date varchar(50) COMMENT '预约时间',
  scheduling_id INT COMMENT '排班ID',
  user_id INT COMMENT '就诊人ID',
  state_id INT COMMENT '状态id',
	doctor_id int COMMENT '医生id',
  reserve_ctime datetime COMMENT '创建时间',
  reserve_mtime DATETIME COMMENT '更新时间'
)COMMENT='预约挂号表';


drop table  if EXISTS apply_info;
-- 申请领卡表
CREATE TABLE apply_info(
	apply_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '申请ID', 
	apply_time datetime COMMENT '申请时间',
	apply_num INT COMMENT '申请卡片数量',
	apply_admin_id INT COMMENT '申请人ID',
	audit_admin_id INT COMMENT '审核人ID',
	audit_num INT COMMENT '审核数量',
	audit_time DATETIME COMMENT '审核时间',
	state_id INT COMMENT '状态id'
);


drop table  if EXISTS admin_info;
-- 管理员表
CREATE TABLE admin_info(
	admin_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '管理员ID', 
	admin_name VARCHAR(30) COMMENT '管理员账号',
	admin_pwd VARCHAR(30)  COMMENT '管理员密码', 
	role_id INT COMMENT '角色id',
	admin_ctime  datetime COMMENT '创建时间',
	admin_mtime DATETIME COMMENT '修改时间',
	state_id INT COMMENT '状态id',
	office_id INT COMMENT '科室id' 
);

INSERT INTO `admin_info` VALUES (null, 'zhangsan', '123456', 1, now(), null, 2, 1);
INSERT INTO `admin_info` VALUES (null, 'lisi', '123456', 2, now(), null, 2, 3);
INSERT INTO `admin_info` VALUES (null, '王五', '123456', 3, now(), null, 2, 2);
INSERT INTO `admin_info` VALUES (null, '赵六', '123456', 3, now(), null, 2, 2);



drop table  if EXISTS office_info;
-- 科室表
CREATE TABLE office_info(
	office_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '科室ID', 
	office_name VARCHAR(30) COMMENT '科室名称'
);
insert into office_info values(null,"管理科");
insert into  office_info values(null,"看病科");
insert into  office_info values(null,"收费科");




drop table  if EXISTS role_info;
-- 角色表
CREATE TABLE role_info(
	role_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '角色ID',
	role_name VARCHAR(50) COMMENT '角色名',
	role_ctime datetime COMMENT '创建时间',
	role_mtime DATETIME COMMENT '修改时间',
	state_id INT COMMENT '状态id'
);
INSERT INTO `role_info` VALUES (1, '系统管理员',now(), NULL, 1);
INSERT INTO `role_info` VALUES (2, '收费人员',now(), NULL, 1);
INSERT INTO `role_info` VALUES (3, '医生',now(), NULL, 1);


drop table  if EXISTS role_menu_rel;
-- 角色关系表
CREATE TABLE role_menu_rel(
  role_menu_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '角色菜单关系ID',
  role_id INT COMMENT '角色ID',
  menu_id INT COMMENT '菜单ID'
);

INSERT INTO `role_menu_rel` VALUES (null, 2, 3);
INSERT INTO `role_menu_rel` VALUES (null, 2, 9);
INSERT INTO `role_menu_rel` VALUES (null, 2, 10);
INSERT INTO `role_menu_rel` VALUES (null, 2, 11);
INSERT INTO `role_menu_rel` VALUES (null, 2, 12);
INSERT INTO `role_menu_rel` VALUES (null, 2, 13);
INSERT INTO `role_menu_rel` VALUES (null, 2, 2);
INSERT INTO `role_menu_rel` VALUES (null, 2, 14);

INSERT INTO `role_menu_rel` VALUES (null, 1, 4);
INSERT INTO `role_menu_rel` VALUES (null, 1, 1);
INSERT INTO `role_menu_rel` VALUES (null, 1, 5);
INSERT INTO `role_menu_rel` VALUES (null, 1, 6);
INSERT INTO `role_menu_rel` VALUES (null, 1, 7);
INSERT INTO `role_menu_rel` VALUES (null, 1, 8);
INSERT INTO `role_menu_rel` VALUES (null, 1, 15);
INSERT INTO `role_menu_rel` VALUES (null, 1, 16);
INSERT INTO `role_menu_rel` VALUES (null, 1, 17);



drop table  if EXISTS menu_info;
-- 菜单表
CREATE TABLE menu_info(
  menu_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '菜单ID',
  menu_name VARCHAR(50) COMMENT '菜单名',
  menu_pid INT COMMENT '上级菜单ID',
  menu_ctime datetime COMMENT '创建时间',
  menu_mtime DATETIME COMMENT '修改时间',
	menu_url varchar(50) COMMENT '菜单url',
  state_id INT COMMENT '状态id'
);

INSERT INTO menu_info(menu_name,menu_pid,menu_url,menu_ctime) VALUES ('卡片管理',0,'',now());
INSERT INTO menu_info(menu_name,menu_pid,menu_url,menu_ctime) VALUES ('卡片业务',0,'',now());
INSERT INTO menu_info(menu_name,menu_pid,menu_url,menu_ctime) VALUES ('统计查询',0,'',now());
INSERT INTO menu_info(menu_name,menu_pid,menu_url,menu_ctime) VALUES ('系统管理',0,'',now());
INSERT INTO menu_info(menu_name,menu_pid,menu_url,menu_ctime) VALUES ('卡入库',1,'outcardinto.html',now());
INSERT INTO menu_info(menu_name,menu_pid,menu_url,menu_ctime) VALUES ('卡注销',1,'outcardlogout.html',now());
INSERT INTO menu_info(menu_name,menu_pid,menu_url,menu_ctime) VALUES ('卡查询',1,'outcardselect.html',now());
INSERT INTO menu_info(menu_name,menu_pid,menu_url,menu_ctime) VALUES ('领卡审批',1,'outaudit.html',now());
INSERT INTO menu_info(menu_name,menu_pid,menu_url,menu_ctime) VALUES ('领卡',2,'outapply.html',now());
INSERT INTO menu_info(menu_name,menu_pid,menu_url,menu_ctime) VALUES ('售卡',2,'outsale.html',now());
INSERT INTO menu_info(menu_name,menu_pid,menu_url,menu_ctime) VALUES ('换卡',2,'outchangecard.html',now());
INSERT INTO menu_info(menu_name,menu_pid,menu_url,menu_ctime) VALUES ('退卡',2,'outexitcard.html',now());
INSERT INTO menu_info(menu_name,menu_pid,menu_url,menu_ctime) VALUES ('领卡查询',3,'outapplycardselect.html',now());
INSERT INTO menu_info(menu_name,menu_pid,menu_url,menu_ctime) VALUES ('工作量统计',3,'outcardsum.html',now());
INSERT INTO menu_info(menu_name,menu_pid,menu_url,menu_ctime) VALUES ('人员管理',4,'outadmin.html',now());
INSERT INTO menu_info(menu_name,menu_pid,menu_url,menu_ctime) VALUES ('权限管理',4,'outpower3.html',now());
INSERT INTO menu_info(menu_name,menu_pid,menu_url,menu_ctime) VALUES ('医生排班',4,'outschedule.html',now());





drop table  if EXISTS admin_log;
-- 管理员日志表
CREATE TABLE admin_log(
  log_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '日志ID', 
  log_content VARCHAR(150) COMMENT '日志内容',
  log_ctime datetime COMMENT '创建时间',
  admin_id INT COMMENT '管理员ID'
);





drop table  if EXISTS state_info;
-- 状态表
CREATE TABLE state_info(
	state_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '状态ID', 
	state_name VARCHAR(50) COMMENT '状态名称',
	state_ctime  datetime COMMENT '创建时间',
	state_mtime DATETIME COMMENT '修改时间',
	state_type VARCHAR(50) COMMENT '状态类型'
);
INSERT INTO `state_info` VALUES (1, '禁用', '2022-03-07 23:16:37', NULL, 'user');
INSERT INTO `state_info` VALUES (2, '启用', '2022-03-07 23:16:37', NULL, 'user');
INSERT INTO `state_info` VALUES (3, '已删除', '2022-03-07 23:16:37', NULL, 'other');
INSERT INTO `state_info` VALUES (4, '待审核', '2022-03-08 13:11:41', NULL, 'card');
INSERT INTO `state_info` VALUES (5, '待出售', '2022-03-08 13:11:50', NULL, 'card');
INSERT INTO `state_info` VALUES (6, '已出售', '2022-03-08 13:52:06', NULL, 'card');
INSERT INTO `state_info` VALUES (7, '待审批', '2022-03-08 16:31:58', NULL, 'check');
INSERT INTO `state_info` VALUES (8, '已审批', '2022-03-08 16:32:04', NULL, 'check');
INSERT INTO `state_info` VALUES (9, '已损坏', '2022-03-09 19:36:47', NULL, 'card');
INSERT INTO `state_info` VALUES (10, '已注销', '2022-03-10 10:20:54', NULL, 'card');
INSERT INTO `state_info` VALUES (11, '已预约', '2022-03-13 11:01:51', NULL, 'order');
INSERT INTO `state_info` VALUES (13, '已取号', '2022-03-13 11:02:51', NULL, 'order');
INSERT INTO `state_info` VALUES (15, '已取消', '2022-03-13 23:05:19', NULL, 'order');
INSERT INTO `state_info` VALUES (16, '待领用', '2022-03-16 11:12:38', NULL, 'card');

