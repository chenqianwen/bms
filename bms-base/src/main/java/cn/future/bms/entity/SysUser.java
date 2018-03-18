package cn.future.bms.entity;

import cn.future.bms.base.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author： ygl
 * @date： 2018/3/17
 * @Description：
 */
@Data
@Entity
@Table(name="sys_user")
public class SysUser extends BaseEntity {

    @Column(name = "username",nullable = false,columnDefinition = "varchar(16) comment'用户名' ")
    private String username;

    @Column(name = "password",nullable = false,columnDefinition = "varchar(16) comment'密码' ")
    private String password;

    @Column
    private Date birthday;
}
