package cn.future.bms;

import cn.future.bms.entity.SysResource;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author： ygl
 * @date： 2018/4/5
 * @Description：
 */
public class TreeTest {

    static List<MyModel> getModelList(){
        MyModel A1= new MyModel();
        A1.setCode("A1");
        A1.setLink("/A1");
        A1.setParent_code(null);
        MyModel B1= new MyModel();
        B1.setCode("B1");
        B1.setLink("/B1");
        B1.setParent_code("A1");
        return Arrays.asList(A1,B1);
    }

    public static void main(String[] args) {
        List<MyModel> modelList = getModelList();
        List<TreeModel> treeModelList = new ArrayList<>();
        MyModelConverter converter = new MyModelConverter();
        for (MyModel myModel : modelList) {
            TreeModel treeModel = converter.warp2TreeModel(myModel);
            treeModelList.add(treeModel);
        }
        // 每个model 找到他的 children
        for (TreeModel treeModel : treeModelList) {
            treeModel.setChildren(getChildren(treeModel,treeModelList));
        }
        // 获取根元素
        List<TreeModel> roots = getRoot(treeModelList);
        for (TreeModel treeModel : roots) {
            MyTreeModel myTreeModel = converter.warp2ResultTreeModel(treeModel);
            System.out.println(myTreeModel);
            System.out.println(JSONObject.toJSONString(myTreeModel));
        }
    }

    private static List<TreeModel> getRoot(List<TreeModel> list) {
        List<TreeModel> root = list.stream().filter(treeModel -> treeModel.isRoot()).collect(Collectors.toList());
        return root;
    }

    private static List<TreeModel> getChildren(TreeModel treeModel, List<TreeModel> list) {
        List<TreeModel> children = new ArrayList<>();
        String id = treeModel.getId();
        for (TreeModel model : list) {
            String parentId = model.getParentId();
            if (id.equals(parentId)) {
                children.add(model);
            }
        }
        return children;
    }

}
