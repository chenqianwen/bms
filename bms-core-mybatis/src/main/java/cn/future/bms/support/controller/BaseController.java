package cn.future.bms.support.controller;

import cn.future.bms.response.Result;
import cn.future.bms.response.ResultHelper;
import cn.future.bms.support.service.IBaseService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author： ygl
 * @date： 2018/3/31
 * @Description：
 */
public class BaseController<T> {

    @Autowired
    private IBaseService<T> baseService;

    public Result OK(Object obj){
        return ResultHelper.ok(obj);
    }

    public Result ERROR(Object obj){
        return ResultHelper.error(obj);
    }

    @ApiOperation(value = "新增", notes = "新增数据")
    @PostMapping
    public Result insert(@RequestBody T model) {
        baseService.insert(model);
        return OK(model);
    }

    @ApiOperation(value = "通过ID查询", notes = "查询没有被逻辑删除的数据")
    @ApiImplicitParam(name = "id", value = "主键ID", required = true, paramType = "path", dataType = "String")
    @GetMapping("/{id}")
    public Result findOne(@PathVariable String id) {
        T t = baseService.findById(id);
        return OK(t);
    }

    @ApiOperation(value = "修改", notes = "修改数据")
    @PutMapping
    public Result update(@RequestBody T model) {
        baseService.update(model);
        return OK(model);
    }

    @ApiOperation(value = "通过ID删除数据", notes = "删除数据")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        int row = baseService.deleteById(id);
        return row>0?OK(id):ERROR("数据不存在");
    }
}
