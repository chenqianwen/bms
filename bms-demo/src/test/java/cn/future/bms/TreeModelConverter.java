package cn.future.bms;

/**
 * @author： ygl
 * @date： 2018/4/6
 * @Description：
 * tree模型的转换器
 */

/**
 *
 * @param <M>  数据源模型
 * @param <TM>  结果集模型
 */
public interface TreeModelConverter<M,TM> {
    /**
     * 转换成tree模型
     * @return
     */
    TreeModel warp2TreeModel(M m);
    /**
     * 把tree模型转成自定义的模型
     * 如果不需要转换则返回null即可
     * @return
     */
    TM warp2ResultTreeModel(TreeModel model);
}
