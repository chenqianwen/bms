package cn.future.bms.support.tree;

import lombok.Data;

import java.util.List;

/**
 * @author： ygl
 * @date： 2018/4/6
 * @Description：
 * 树 模型
 */
@Data
public class TreeModel {

    /**
     * 树结构唯一标志
     */
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 是否选中
     */
    private Boolean checked;
    /**
     * 是否根节点
     */
    private Boolean root;
    /**
     * 父节点ID
     */
    private String parentId;
    /**
     * 图标
     */
    private String icon;
    /**
     * 链接路径
     */
    private String link;
    /**
     * 子节点集合
     */
    private List<TreeModel> children;
}
