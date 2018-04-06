package cn.future.bms.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @author： ygl
 * @date： 2018/4/6
 * @Description：
 */
@Data
public class SysResourceTreeModel {
    private String text;
    private String to;
    private String icon;
    private List<SysResourceTreeModel> children;
}
