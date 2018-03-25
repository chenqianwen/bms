package cn.future.bms.controller;

import cn.future.bms.entity.SysUser;
import cn.future.bms.mapper.SysUserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private SysUserMapper sysUserMapper;

    @ApiOperation(value = "通过ID查询", notes = "查询没有被逻辑删除的数据")
    @ApiImplicitParam(name = "id", value = "主键ID", required = true, paramType = "path", dataType = "String")
    @GetMapping("/{id}")
    public SysUser findOne(@PathVariable String id) {
        SysUser one = sysUserMapper.findOne(id);
        return one;
    }
}
