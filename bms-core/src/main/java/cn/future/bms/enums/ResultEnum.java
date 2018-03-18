package cn.future.bms.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * @author： ygl
 * @date： 2018/3/17
 * @Description：
 */
public enum  ResultEnum {
    OK(0,"ok"),ERROR(1,"error");

    @Getter
    int code;
    @Getter
    String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
