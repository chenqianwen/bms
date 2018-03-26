package cn.future.bms.entity;

import cn.future.bms.support.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author： ygl
 * @date： 2018/3/26
 * @Description：
 */
@Data
@Table(name="sys_user")
public class SysUser extends BaseEntity {

    @Column(name ="username")
    private String username;

    @Column(name ="password")
    private String password;

    @Column(name ="birthday")
    private Date birthday;
}
