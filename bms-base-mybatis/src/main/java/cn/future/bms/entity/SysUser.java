package cn.future.bms.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author： ygl
 * @date： 2018/3/20
 * @Description：
 */
@ApiModel(value = "SysUser", description = "系统用户模型")
@Data
public class SysUser extends BaseEntity {

    @ApiModelProperty(value = "用户名")
    private String username;

    private String password;
}
