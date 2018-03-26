package cn.future.bms.response;

import cn.future.bms.enums.ResultEnum;

/**
 * @author： ygl
 * @date： 2018/3/26
 * @Description： Util of Result
 */
public class ResultHelper {

    private static Result result = new Result();

    public static Result ok() {
        result.setCode(ResultEnum.OK.getCode());
        result.setMsg(ResultEnum.OK.getMsg());
        result.setData(null);
        return result;
    }

    public static Result ok(String msg) {
        result.setCode(ResultEnum.OK.getCode());
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    public static Result ok(Object data) {
        result.setCode(ResultEnum.OK.getCode());
        result.setMsg(ResultEnum.OK.getMsg());
        result.setData(data);
        return result;
    }

    public static Result ok(String msg, Object data) {
        result.setCode(ResultEnum.OK.getCode());
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static Result error() {
        result.setCode(ResultEnum.ERROR.getCode());
        result.setMsg(ResultEnum.ERROR.getMsg());
        result.setData(null);
        return result;
    }

    public static Result error(String msg) {
        result.setCode(ResultEnum.ERROR.getCode());
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    public static Result error(Object data) {
        result.setCode(ResultEnum.ERROR.getCode());
        result.setMsg(ResultEnum.ERROR.getMsg());
        result.setData(data);
        return result;
    }

    public static Result error(String msg, Object data) {
        result.setCode(ResultEnum.OK.getCode());
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}
