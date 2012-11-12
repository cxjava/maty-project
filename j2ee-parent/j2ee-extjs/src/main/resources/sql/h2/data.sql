
INSERT INTO t_base_module (id,module_name,module_url,parent_id,leaf,expanded,display_index,is_display,en_module_name,icon_css,information,parent_url) VALUES (1,'系统设置',NULL,0,0,1,1,1,'System Settings','system_settings',NULL,NULL);
INSERT INTO t_base_module (id,module_name,module_url,parent_id,leaf,expanded,display_index,is_display,en_module_name,icon_css,information,parent_url) VALUES (2,'供应商管理',NULL,0,0,1,2,1,'Operator','abc',NULL,NULL);
INSERT INTO t_base_module (id,module_name,module_url,parent_id,leaf,expanded,display_index,is_display,en_module_name,icon_css,information,parent_url) VALUES (11,'角色管理','/role',1,1,0,3,1,'Role Management','role',NULL,NULL);
INSERT INTO t_base_module (id,module_name,module_url,parent_id,leaf,expanded,display_index,is_display,en_module_name,icon_css,information,parent_url) VALUES (12,'用户管理','/user',1,1,0,2,1,'User Management','user',NULL,NULL);
INSERT INTO t_base_module (id,module_name,module_url,parent_id,leaf,expanded,display_index,is_display,en_module_name,icon_css,information,parent_url) VALUES (13,'模块管理','/module',1,1,0,1,1,'Module Management','module',NULL,NULL);
INSERT INTO t_base_module (id,module_name,module_url,parent_id,leaf,expanded,display_index,is_display,en_module_name,icon_css,information,parent_url) VALUES (14,'系统字段管理','/field',1,1,1,4,1,'field','field',NULL,NULL);
INSERT INTO t_base_module (id,module_name,module_url,parent_id,leaf,expanded,display_index,is_display,en_module_name,icon_css,information,parent_url) VALUES  (21,'供应商信息','/oprator',2,1,0,1,1,'oprator','cde',NULL,NULL);

INSERT INTO t_base_role (id,role_name,role_desc) VALUES (1,'管理员','管理员');
INSERT INTO t_base_role (id,role_name,role_desc) VALUES (2,'测试角色','测试角色');
 
INSERT INTO t_base_role_module (id,role_id,module_id) VALUES (1,2,2);
INSERT INTO t_base_role_module (id,role_id,module_id) VALUES (2,2,21);
INSERT INTO t_base_role_module (id,role_id,module_id) VALUES (3,1,1);
INSERT INTO t_base_role_module (id,role_id,module_id) VALUES (4,1,2);
INSERT INTO t_base_role_module (id,role_id,module_id) VALUES (5,1,13);
INSERT INTO t_base_role_module (id,role_id,module_id) VALUES (6,1,12);
INSERT INTO t_base_role_module (id,role_id,module_id) VALUES (7,1,11);
INSERT INTO t_base_role_module (id,role_id,module_id) VALUES (8,1,14);
INSERT INTO t_base_role_module (id,role_id,module_id) VALUES (9,1,21);

INSERT INTO t_base_user (id,account,password,real_name,sex,email,mobile,office_phone,error_count,last_login_time,last_login_ip,remark) VALUES (2,'test','ddee6e95fae5bb5f8890a6f9ef7d0d1db744ca4417e94c05595ef280046a49021eba3291ee9c9cf8','测试用户',0,'test@qq.com','119','110',0,'2012-11-06 16:52:07',NULL,NULL);
INSERT INTO t_base_user (id,account,password,real_name,sex,email,mobile,office_phone,error_count,last_login_time,last_login_ip,remark) VALUES (1,'admin','6043ae1095884cf9663d140ee6450b49b8489b3aa073a8eec024492b976ee2a24aee0c272369121b','超级管理员',0,'admin@qq.com.cn','119','110',0,'2012-11-07 15:52:04','127.0.0.1','用户信息');

INSERT INTO t_base_user_role (id,user_id,role_id) VALUES  (1,1,1);
INSERT INTO t_base_user_role (id,user_id,role_id) VALUES  (2,2,2);
 
