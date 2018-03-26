package cn.future.bms.controller;

import cn.future.bms.response.Result;
import cn.future.bms.response.ResultHelper;
import cn.future.bms.entity.SysUser;
import cn.future.bms.entity.dto.SysUserReqDto;
import cn.future.bms.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author： ygl
 * @date： 2018/3/21
 * @Description：
 */
@Api(tags = {"系统用户模块"})
@RestController
@RequestMapping("sys/user")
public class SysUserController {

    @Autowired
    private ISysUserService iSysUserService;

    @ApiOperation(value = "新增数据", notes = "新增系统用户")
    @PostMapping
    public Result insert(@RequestBody SysUserReqDto model) {
        int row = iSysUserService.insert(model);
        return ResultHelper.ok(model);
    }

    @ApiOperation(value = "通过ID查询", notes = "查询没有被逻辑删除的数据")
    @ApiImplicitParam(name = "id", value = "主键ID", required = true, paramType = "path", dataType = "String")
    @GetMapping("/{id}")
    public Result findOne(@PathVariable String id) {
        SysUser model = iSysUserService.findById(id);
        return ResultHelper.ok(model);
    }

    @ApiOperation(value = "修改数据", notes = "修改系统用户")
    @PutMapping
    public Result update(@RequestBody SysUserReqDto model) {
        int row = iSysUserService.update(model);
        return ResultHelper.ok(model);
    }

    @ApiOperation(value = "通过ID删除数据", notes = "删除系统用户")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        int row = iSysUserService.deleteById(id);
        return row>0?ResultHelper.ok(id):ResultHelper.error("数据不存在");
    }
}
