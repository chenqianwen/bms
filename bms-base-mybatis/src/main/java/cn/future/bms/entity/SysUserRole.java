package cn.future.bms.entity;
import cn.future.bms.support.entity.BaseEntity;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author： ygl
 * @date： 2018/03/31-17:54
 * @Description：
 * 系统用户角色关系
*/
@Data
@Table(name="sys_user_role")
public class SysUserRole extends BaseEntity{

    /**
     * 用户主键
     */
    @Column(name = "user_id")
    private String userId;
    /**
     * 角色主键
     */
    @Column(name = "role_id")
    private String roleId;
}