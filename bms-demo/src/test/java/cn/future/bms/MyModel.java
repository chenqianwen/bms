package cn.future.bms;

import lombok.Data;

import java.util.List;

/**
 * @author： ygl
 * @date： 2018/4/6
 * @Description：
 */
@Data
public class MyModel {
    private String code;
    private String link;
    private String parent_code;
    private List<MyModel> sub;
}
