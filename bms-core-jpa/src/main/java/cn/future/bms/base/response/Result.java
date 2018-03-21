package cn.future.bms.base.response;

import lombok.Data;

/**
 * @author： ygl
 * @date： 2018/3/17
 * @Description：
 * 返回结果封装
 */
@Data
public class Result {
    /**
     * 状态码
     */
    private int code;
    /**
     * 信息
     */
    private String msg;
    /**
     *  数据
     */
    private Object data;
}
