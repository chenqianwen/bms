package cn.future.bms.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author： ygl
 * @date： 2018/3/21
 * @Description：
 */
@Data
public class SysUser extends BaseEntity {

    private Date birthday;

    private String username;

    private String password;
}
