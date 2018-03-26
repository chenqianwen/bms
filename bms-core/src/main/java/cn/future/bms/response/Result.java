package cn.future.bms.response;

import lombok.Data;

/**
 * @author： ygl
 * @date： 2018/3/26
 * @Description：
 * result to response
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