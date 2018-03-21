package cn.future.bms.controller;

import cn.future.bms.entity.SysUser;
import cn.future.bms.mapper.SysUserMapper;
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
@RestController
@RequestMapping("sys/user")
public class SysUserController {

    @Autowired
    private SysUserMapper sysUserMapper;

    @GetMapping("/{id}")
    public SysUser findOne(@PathVariable String id){
        SysUser one = sysUserMapper.findOne(id);
        return one;
    }
}
