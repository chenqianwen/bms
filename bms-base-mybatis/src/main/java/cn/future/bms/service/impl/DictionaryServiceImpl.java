package cn.future.bms.service.impl;

import cn.future.bms.entity.Dictionary;
import cn.future.bms.mapper.DictionaryMapper;
import cn.future.bms.service.IDictionaryService;
import cn.future.bms.support.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author： ygl
 * @date： 2018/3/26
 * @Description：
 */
@Service
public class DictionaryServiceImpl extends BaseServiceImpl<Dictionary> implements IDictionaryService {

    @Autowired
    private DictionaryMapper dictionaryMapper;

}
