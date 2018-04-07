package cn.future.bms.controller;

import cn.future.bms.support.controller.BaseController;
import cn.future.bms.response.Result;
import cn.future.bms.response.ResultHelper;
import cn.future.bms.entity.SysUser;
import cn.future.bms.entity.dto.SysUserDTO;
import cn.future.bms.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        String account = dto.getAccount();
        String password = dto.getPassword();
        Boolean checkbox = dto.getCheckbox();
        log.info("-----------------------------======------------------------------");
        log.info("请求数据："+account+"--"+password+"--"+checkbox);
        return OK("success");
    }
}
