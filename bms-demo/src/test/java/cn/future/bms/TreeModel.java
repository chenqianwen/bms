package cn.future.bms;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author： ygl
 * @date： 2018/4/5
 * @Description：
 */
@Data
public class TreeModel {
    /**
     * 主键
     */
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 是否选中
     */
    private boolean checked;
    /**
     * 是否根节点
     */
    private boolean root;
    /**
     * 父节点ID
     */
    private String parentId;
    /**
     * 图标
     */
    private String icon;
    /**
     * 路径
     */
    private String link;
    /**
     * 子节点集合
     */
    private List<TreeModel> children;
}
