package cn.future.bms.entity;
import cn.future.bms.support.BaseEntity;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author： ygl
 * @date： 2018/04/05-19:12
 * @Description：
 * 数据字典
*/
@Data
@Table(name="dictionary")
public class Dictionary extends BaseEntity{

    /**
     * 代码
     */
    @Column(name = "code")
    private String code;
    /**
     * 名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 描述
     */
    @Column(name = "description")
    private String description;
}