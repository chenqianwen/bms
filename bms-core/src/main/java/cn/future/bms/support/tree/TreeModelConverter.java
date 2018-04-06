package cn.future.bms.support.tree;

/**
 * @author： ygl
 * @date： 2018/4/6
 * @Description：
 * @param <M>  数据源模型
 * @param <RM>  结果集模型
 */
public interface TreeModelConverter<M,RM> {

    /**
     * 转换成tree模型
     * @param m 数据源
     * @return 树模型
     */
    TreeModel warpToTreeModel(M m);
    /**
     * 转换成tree模型
     * @param treeModel 树模型
     * @return 自定义的树属性
     */
    RM warpFromTreeModel(TreeModel treeModel);
}
