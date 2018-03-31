package ${packageName};

import cn.future.bms.support.controller.BaseController;
import cn.future.bms.response.Result;
import cn.future.bms.response.ResultHelper;
import ${entityPackageName}.${className};
import ${dtoPackageName}.${className}DTO;
import ${servicePackageName}.I${className}Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author： ${author}
 * @date： ${date}
 * @Description：
 */
@Api(tags = {"${tableComment}模块"})
@RestController
@RequestMapping("/${className?lower_case}")
public class ${className}Controller extends BaseController<${className}>{

    @Autowired
    private I${className}Service ${className?uncap_first}Service;

}
