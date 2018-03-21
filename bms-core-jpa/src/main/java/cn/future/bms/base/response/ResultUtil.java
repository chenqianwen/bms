package cn.future.bms.base.response;

import cn.future.bms.enums.ResultEnum;

/**
 * @author： ygl
 * @date： 2018/3/17
 * @Description：
 */
public class ResultUtil {
    public static Result ok(Object data){
        Result result = new Result();
        result.setCode(ResultEnum.OK.getCode());
        result.setMsg(ResultEnum.OK.getMsg());
        result.setData(data);
        return result;
    }
    public static Result error(String msg){
        Result result = new Result();
        result.setCode(ResultEnum.ERROR.getCode());
        result.setMsg(msg);
        return result;
    }
    public static Result error(String msg,String data){
        Result result = new Result();
        result.setCode(ResultEnum.ERROR.getCode());
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
    public static Result error(){
        Result result = new Result();
        result.setCode(ResultEnum.ERROR.getCode());
        result.setMsg(ResultEnum.ERROR.getMsg());
        return result;
    }
}
