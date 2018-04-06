package cn.future.bms;

import lombok.Data;

import java.util.List;

/**
 * @author： ygl
 * @date： 2018/4/6
 * @Description：
 */
@Data
public class MyTreeModel{

    private String text;
    private String to;
    private String icon;
    private List<MyTreeModel> subs;
}
