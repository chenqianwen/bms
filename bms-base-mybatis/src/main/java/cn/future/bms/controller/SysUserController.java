package cn.future.bms.controller;

import cn.future.bms.entity.SysUser;
import cn.future.bms.entity.dto.SysUserDTO;
import cn.future.bms.response.Result;
import cn.future.bms.service.ISysUserService;
import cn.future.bms.support.controller.BaseController;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： ygl
 * @date： 2018/03/31-15:44
 * @Description：
 */
@Api(tags = {"系统用户模块"})
@Slf4j
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends BaseController<SysUser>{

    @Autowired
    private ISysUserService sysUserService;

    @PostMapping("/login")
    public Result login(@RequestBody SysUserDTO dto){
        String username = dto.getUsername();
        String password = dto.getPassword();
        Boolean checkbox = dto.getCheckbox();
        log.info("-----------------------------======------------------------------");
        log.info("请求数据："+username+"--"+password+"--"+checkbox);
        return OK("success");
    }
}
