package cn.future.bms.entity;
import cn.future.bms.support.BaseEntity;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author： ygl
 * @date： 2018/03/31-17:45
 * @Description：
 * 系统角色  
*/
@Data
@Table(name="sys_role")
public class SysRole extends BaseEntity{

    /**
     * 角色名称
     */
    @Column(name = "name")
    private String name;
}