package cn.future.bms.controller;

import cn.future.bms.base.response.Result;
import cn.future.bms.base.response.ResultUtil;
import cn.future.bms.entity.SysUser;
import cn.future.bms.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author： ygl
 * @date： 2018/3/17
 * @Description：
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping
    public Result save(){
        SysUser user = new SysUser();
        user.setBirthday(new Date());
        user = sysUserService.save(user);
        return ResultUtil.ok(user);
    }

    @GetMapping("/{id}")
    public Result find(@PathVariable  String id){
        SysUser user = sysUserService.findById(id);
        return ResultUtil.ok(user);
    }
}
