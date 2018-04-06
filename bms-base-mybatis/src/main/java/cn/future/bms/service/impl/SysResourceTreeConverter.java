package cn.future.bms.service.impl;

import cn.future.bms.entity.SysResource;
import cn.future.bms.entity.dto.SysResourceTreeModel;
import cn.future.bms.support.tree.TreeModel;
import cn.future.bms.support.tree.TreeModelConverter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： ygl
 * @date： 2018/4/6
 * @Description：
 */
@Service
public class SysResourceTreeConverter implements TreeModelConverter<SysResource,SysResourceTreeModel> {

    @Override
    public TreeModel warpToTreeModel(SysResource sysResource) {
        TreeModel treeModel = new TreeModel();
        if (StringUtils.isBlank(sysResource.getParentId())) {
            treeModel.setRoot(true);
        }
        BeanUtils.copyProperties(sysResource,treeModel);
        return treeModel;
    }

    @Override
    public SysResourceTreeModel warpFromTreeModel(TreeModel treeModel) {
        SysResourceTreeModel model = new SysResourceTreeModel();
        model.setText(treeModel.getName());
        model.setTo(treeModel.getLink());
        BeanUtils.copyProperties(treeModel,model);
        if (treeModel.getChildren() != null && !treeModel.getChildren().isEmpty()) {
            List<SysResourceTreeModel> children = new ArrayList<>();
            for (TreeModel subTreeModel : treeModel.getChildren()) {
                SysResourceTreeModel subMyTreeModel = warpFromTreeModel(subTreeModel);
                children.add(subMyTreeModel);
            }
            model.setChildren(children);
        }
        return model;
    }
}
