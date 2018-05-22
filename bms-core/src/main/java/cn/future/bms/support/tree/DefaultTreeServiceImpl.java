package cn.future.bms.support.tree;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author： ygl
 * @date： 2018/4/6
 * @Description：
 * 默认的建立数模型的实现类
 */
@Service
public class DefaultTreeServiceImpl<M,RM> implements ITreeService<M,RM> {

    /**
     * 设置自定义转换器
     */
    @Autowired
    private TreeModelConverter<M,RM> treeModelConverter;

    /**
     * 建立 树结构
     * @param parentId 根节点ID,不设置则构建整个数据源
     * @param includeParent 是否包含根节点，设置根节点之后，如果includeParent是true则构建parentId及子节点，如果includeParent是false则构建子节点
     * @param list 数据源
     * @return
     */
    @Override
    public List<TreeModel> buildTree(String parentId, boolean includeParent, List<M> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        // 数据源转换成树集合
        List<TreeModel> treeModelList = new ArrayList<>(list.size());
        list.forEach(model ->{
            TreeModel treeModel;
            // 如果没有配置转换器或者不需要转换属性，则把数据源相同属性的值赋值给树模型
            if (treeModelConverter == null || treeModelConverter.warpToTreeModel(model) == null) {
                treeModel = new TreeModel();
                BeanUtils.copyProperties(model,treeModel);
            } else {
                treeModel = treeModelConverter.warpToTreeModel(model);
            }
            treeModelList.add(treeModel);
        });
        // 设置每个节点的子节点
        treeModelList.forEach(treeModel -> treeModel    .setChildren(getChildren(treeModel,treeModelList)));
        // 取到所有根节点
        List<TreeModel> rootList = getRootList(parentId,includeParent,treeModelList);
        return rootList;
    }

    @Override
    public List<RM> renderTree(String parentId, boolean includeParent, List<M> list) {
        List<TreeModel> treeModelList = buildTree(parentId, includeParent, list);
        // 如果没有配置转换器，或者不需要转换树属性 则强制转成TreeModel
        if (treeModelConverter == null || treeModelConverter.warpFromTreeModel(new TreeModel()) == null) {
            return (List<RM>) treeModelList;
        }
        // 如果需要转换树属性
        List<RM> resultModelList = new ArrayList<>(list.size());
        treeModelList.forEach(treeModel -> {
            resultModelList.add(treeModelConverter.warpFromTreeModel(treeModel));
        });
        return resultModelList;
    }

    /**
     * 获取树的子节点
     * @param treeModel 树模型
     * @param list 所有的树模型
     * @return
     */
    protected List<TreeModel> getChildren(TreeModel treeModel, List<TreeModel> list) {
        String id = treeModel.getId();
        List<TreeModel> children = list.stream().filter(tree -> {
            String parentId = tree.getParentId();
            if (id != null && id.equals(parentId)) {
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList());
        return children;
    }
    /**
     * 获取所有的根节点
     * @param parentId
     * @param includeParent
     * @param list
     * @return
     */
    protected List<TreeModel> getRootList(String parentId, boolean includeParent, List<TreeModel> list) {
        if (list != null && !list.isEmpty()) {
            if (StringUtils.isBlank(parentId)) {
                List<TreeModel> rootList = list.stream().filter(treeModel -> {
                    if(treeModel.getRoot() == null ){
                        return false;
                    }
                    return treeModel.getRoot();
                }).collect(Collectors.toList());
                return rootList;
            } else {
                // 包含根节点
                if (includeParent) {
                    // 需要break，不用流操作
                    for (TreeModel model : list) {
                        if (parentId.equalsIgnoreCase(model.getId())) {
                            return Arrays.asList(model);
                        }
                    }
                } else {
                   return list.stream().filter(treeModel -> parentId.equalsIgnoreCase(treeModel.getParentId())).collect(Collectors.toList());
                }
            }
        }
        return null;
    }
}
