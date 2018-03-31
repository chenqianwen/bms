DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` varchar(64)  NOT NULL COMMENT '主键',
  `created_by` varchar(16) NOT NULL COMMENT '创建者',
  `created_date` datetime NOT NULL COMMENT '创建时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标志',
  `updated_by` varchar(16) NOT NULL COMMENT '修改者',
  `updated_date` datetime NOT NULL COMMENT '修改时间',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `name` varchar(32) DEFAULT NULL COMMENT '姓名',
  `sex` tinyint(1) DEFAULT 0 COMMENT '性别0:男,1:女，默认男',
  `phone` varchar(16) DEFAULT NULL COMMENT '电话',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `avatar` varchar(128) DEFAULT NULL COMMENT '头像',
  `is_frozen` tinyint(1) NOT NULL DEFAULT 0 COMMENT '冻结0:没有冻结,1:冻结',
  PRIMARY KEY (`id`) USING BTREE
)COMMENT='系统用户' ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` varchar(64)  NOT NULL COMMENT '主键',
  `created_by` varchar(16) NOT NULL COMMENT '创建者',
  `created_date` datetime NOT NULL COMMENT '创建时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标志',
  `updated_by` varchar(16) NOT NULL COMMENT '修改者',
  `updated_date` datetime NOT NULL COMMENT '修改时间',
  `name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE
)COMMENT='系统角色' ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` varchar(64)  NOT NULL COMMENT '主键',
  `created_by` varchar(16) NOT NULL COMMENT '创建者',
  `created_date` datetime NOT NULL COMMENT '创建时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标志',
  `updated_by` varchar(16) NOT NULL COMMENT '修改者',
  `updated_date` datetime NOT NULL COMMENT '修改时间',
  `user_id` varchar(64) NOT NULL COMMENT '用户主键',
  `role_id` varchar(64) NOT NULL COMMENT '角色主键',
  PRIMARY KEY (`id`) USING BTREE
)COMMENT='系统用户角色关系' ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource`  (
  `id` varchar(64)  NOT NULL COMMENT '主键',
  `created_by` varchar(16) NOT NULL COMMENT '创建者',
  `created_date` datetime NOT NULL COMMENT '创建时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标志',
  `updated_by` varchar(16) NOT NULL COMMENT '修改者',
  `updated_date` datetime NOT NULL COMMENT '修改时间',
  `name` varchar(16) NOT NULL COMMENT '资源名称',
  `link` varchar(32) DEFAULT NULL COMMENT '资源链接',
  `icon` varchar(16) DEFAULT NULL COMMENT '图标',
  `is_menu` tinyint(1) NOT NULL COMMENT '0:菜单,1:按钮',
  `level` tinyint NOT NULL COMMENT '层级',
  `parent_id` varchar(64) NOT NULL COMMENT '上一层菜单主键',
  `next_id` varchar(64) NOT NULL COMMENT '下一个同级资源主键',
  PRIMARY KEY (`id`) USING BTREE
)COMMENT='系统权限资源' ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;