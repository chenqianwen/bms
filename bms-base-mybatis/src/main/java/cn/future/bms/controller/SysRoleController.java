package cn.future.bms.controller;

import cn.future.bms.support.controller.BaseController;
import cn.future.bms.response.Result;
import cn.future.bms.response.ResultHelper;
import cn.future.bms.entity.SysRole;
import cn.future.bms.entity.dto.SysRoleDTO;
import cn.future.bms.service.ISysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author： ygl
 * @date： 2018/03/31-17:45
 * @Description：
 */
@Api(tags = {"系统角色  模块"})
@RestController
@RequestMapping("/sysrole")
public class SysRoleController extends BaseController<SysRole>{

    @Autowired
    private ISysRoleService sysRoleService;

}
