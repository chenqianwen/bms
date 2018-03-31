package ${packageName};

import ${entityPackageName}.${className};
import ${mapperPackageName}.${className}Mapper;
import ${servicePackageName}.I${className}Service;
import cn.future.bms.support.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author： ygl
 * @date： 2018/3/26
 * @Description：
 */
@Service
public class ${className}ServiceImpl extends BaseServiceImpl<${className}> implements I${className}Service {

    @Autowired
    private ${className}Mapper ${className?uncap_first}Mapper;

}
