package cn.future.bms.generator;

import lombok.Data;

/**
 * @author： ygl
 * @date： 2018/3/30
 * @Description：
 * 数据库字段to java类 属性封装
 */
@Data
public class ColumnClass {

    /**
     * 数据库字段名称
     */
    private String columnName;
    /**
     * 数据库字段类型
     */
    private String columnType;
    /**
     * 数据库字段注释
     */
    private String columnComment;
    /**
     * 字段名对应的属性名
     */
    private String fieldName;
}
