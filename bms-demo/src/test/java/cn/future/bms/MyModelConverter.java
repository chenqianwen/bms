package cn.future.bms;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： ygl
 * @date： 2018/4/6
 * @Description：
 */
public class MyModelConverter implements TreeModelConverter<MyModel,MyTreeModel> {

    @Override
    public TreeModel warp2TreeModel(MyModel myModel) {
        TreeModel model = new TreeModel();
        model.setId(myModel.getCode());
        model.setLink(myModel.getLink());
        model.setParentId(myModel.getParent_code());
        model.setName(myModel.getCode());
        model.setRoot(StringUtils.isEmpty(myModel.getParent_code()));
        return model;
    }

    @Override
    public MyTreeModel warp2ResultTreeModel(TreeModel model) {
        MyTreeModel myTreeModel = new MyTreeModel();
        myTreeModel.setText(model.getName());
        myTreeModel.setTo(model.getLink());
        if (!model.getChildren().isEmpty()) {
            List<MyTreeModel> subs = new ArrayList<>();
            for (TreeModel treeModel : model.getChildren()) {
                MyTreeModel subMyTreeModel = warp2ResultTreeModel(treeModel);
                subs.add(subMyTreeModel);
            }
            myTreeModel.setSubs(subs);
        }
        return myTreeModel;
    }

}
