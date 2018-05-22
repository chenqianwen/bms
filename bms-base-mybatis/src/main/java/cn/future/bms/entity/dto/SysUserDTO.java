package cn.future.bms.entity.dto;

import cn.future.bms.entity.SysUser;
import lombok.Data;

/**
 * @author： ygl
 * @date：  2018/03/31-15:10
 * @Description：
 */
@Data
public class SysUserDTO extends SysUser{

    private String username;

    private String password;

    private Boolean checkbox;
}
