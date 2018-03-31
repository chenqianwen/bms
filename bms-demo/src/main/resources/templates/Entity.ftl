package ${packageName};
import cn.future.bms.support.entity.BaseEntity;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author： ${author}
 * @date： ${date}
 * @Description：
 * ${tableComment}
*/
@Data
@Table(name="${tableName}")
public class ${className} extends BaseEntity{

<#if columnClassList?exists>
    <#list columnClassList as model>
    /**
     * ${model.columnComment!}
     */
    <#if (model.columnType = 'VARCHAR' || model.columnType = 'TEXT')>
    @Column(name = "${model.columnName}")
    private String ${model.fieldName};
    </#if>
    <#if (model.columnType = 'DATETIME' || model.columnType = 'DATE')>
    @Column(name = "${model.columnName}")
    private Date ${model.fieldName};
    </#if>
    <#if model.columnType = 'BIT' >
    @Column(name = "${model.columnName}")
    private Byte ${model.fieldName};
    </#if>
    <#if model.columnType = 'TINYINT' >
    @Column(name = "${model.columnName}")
    private Integer ${model.fieldName};
    </#if>
    <#if model.columnType = 'DECIMAL' >
    @Column(name = "${model.columnName}")
    private BigDecimal ${model.fieldName};
    </#if>
    </#list>
</#if>
}