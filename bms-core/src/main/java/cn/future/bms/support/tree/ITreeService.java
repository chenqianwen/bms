package cn.future.bms.support.tree;

import java.util.List;

/**
 * @author： ygl
 * @date： 2018/4/6
 * @Description：
 */
public interface ITreeService<M,RM> {

    /**
     * 生成树
     * @param parentId 根节点ID
     * @param includeParent 是否包含根节点
     * @param list 数据源
     * @return
     */
    List<TreeModel> buildTree(String parentId, boolean includeParent, List<M> list);

    /**
     * 渲染树属性 : 生成树并且对树模型的属性进行转换
     * @param parentId 根节点ID
     * @param includeParent 是否包含根节点
     * @param list 数据源
     * @return
     */
    List<RM> renderTree(String parentId, boolean includeParent, List<M> list);
}
