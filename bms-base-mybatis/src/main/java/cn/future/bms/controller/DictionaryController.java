package cn.future.bms.controller;

import cn.future.bms.service.IDictionaryService;
import cn.future.bms.support.controller.BaseController;
import cn.future.bms.entity.Dictionary;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author： ygl
 * @date： 2018/04/05-19:12
 * @Description：
 */
@Api(tags = {"数据字典模块"})
@RestController
@RequestMapping("/dictionary")
public class DictionaryController extends BaseController<Dictionary> {

    @Autowired
    private IDictionaryService dictionaryService;


}
