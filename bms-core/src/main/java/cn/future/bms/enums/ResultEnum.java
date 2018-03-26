package cn.future.bms.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author： ygl
 * @date： 2018/3/26
 * @Description：
 * enumeration of result
 */
@AllArgsConstructor
public enum  ResultEnum {

    OK(0,"成功"),
    ERROR(1,"失败");

    @Getter
    private int code;
    @Getter
    private String msg;
}
