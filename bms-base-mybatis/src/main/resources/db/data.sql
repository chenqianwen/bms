INSERT INTO sys_resource (id,created_by,created_date,updated_by,updated_date,is_deleted,name,icon,is_menu,level)
VALUES ('100000000','system','2018-04-05 19:39:24','system','2018-04-05 19:39:24',0,'系统','set',0,0);
INSERT INTO sys_resource (id,created_by,created_date,updated_by,updated_date,is_deleted,name,icon,is_menu,level,parent_id)
VALUES ('101000000','system','2018-04-05 19:39:24','system','2018-04-05 19:39:24',0,'系统管理','set',0,0,'100000000');
INSERT INTO sys_resource (id,created_by,created_date,updated_by,updated_date,is_deleted,name,link,icon,is_menu,level,parent_id)
VALUES ('101010000','system','2018-04-05 19:39:24','system','2018-04-05 19:39:24',0,'账户管理','/account','activity',0,0,'101000000');
INSERT INTO sys_resource (id,created_by,created_date,updated_by,updated_date,is_deleted,name,link,icon,is_menu,level,parent_id,previous_id)
VALUES ('101020000','system','2018-04-05 19:39:24','system','2018-04-05 19:39:24',0,'组织机构管理','/organization','ul-list',0,0,'101000000','101010000');
INSERT INTO sys_resource (id,created_by,created_date,updated_by,updated_date,is_deleted,name,link,icon,is_menu,level,parent_id,previous_id)
VALUES ('101030000','system','2018-04-05 19:39:24','system','2018-04-05 19:39:24',0,'用户管理','/user','yonghu',0,0,'100000000','101020000');
INSERT INTO sys_resource (id,created_by,created_date,updated_by,updated_date,is_deleted,name,link,icon,is_menu,level,parent_id,previous_id)
VALUES ('101040000','system','2018-04-05 19:39:24','system','2018-04-05 19:39:24',0,'角色管理','/role','link',0,0,'100000000','101030000');