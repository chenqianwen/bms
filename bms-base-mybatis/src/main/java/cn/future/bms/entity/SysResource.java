package cn.future.bms.entity;
import cn.future.bms.support.BaseEntity;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author： ygl
 * @date： 2018/03/31-21:32
 * @Description：
 * 系统权限资源
*/
@Data
@Table(name="sys_resource")
public class SysResource extends BaseEntity{

    /**
     * 资源名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 资源链接
     */
    @Column(name = "link")
    private String link;
    /**
     * 图标
     */
    @Column(name = "icon")
    private String icon;
    /**
     * 0:菜单,1:按钮
     */
    @Column(name = "is_menu")
    private Byte isMenu;
    /**
     * 层级
     */
    @Column(name = "level")
    private Integer level;
    /**
     * 上一层菜单主键
     */
    @Column(name = "parent_id")
    private String parentId;
    /**
     * 上一个同级资源主键
     */
    @Column(name = "previous_id")
    private String previousId;
}