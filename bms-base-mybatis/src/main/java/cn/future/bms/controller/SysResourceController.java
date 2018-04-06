package cn.future.bms.controller;

import cn.future.bms.entity.SysResource;
import cn.future.bms.entity.SysRole;
import cn.future.bms.response.Result;
import cn.future.bms.service.ISysResourceService;
import cn.future.bms.service.ISysRoleService;
import cn.future.bms.support.controller.BaseController;
import cn.future.bms.support.tree.ITreeService;
import cn.future.bms.support.tree.TreeModel;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author： ygl
 * @date： 2018/4/5
 * @Description：
 */
@Api(tags = {"系统资源 模块"})
@RestController
@RequestMapping("/sys/resource")
public class SysResourceController extends BaseController<SysResource> {

    @Autowired
    private ISysResourceService sysResourceService;

    @Autowired
    private ITreeService<SysResource,TreeModel> treeService;


    @GetMapping("/tree")
    public Result buildTree(){
        List<String> idList = Arrays.asList("100000000","101000000","101010000","101020000","101030000","101040000");
        List<SysResource> list = sysResourceService.findByIdList(idList);
        List<TreeModel> treeModelList = treeService.renderTree(null, false, list);
        return OK(treeModelList);
    }


}
