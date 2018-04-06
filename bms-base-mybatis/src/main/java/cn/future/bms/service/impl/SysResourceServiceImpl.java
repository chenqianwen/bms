package cn.future.bms.service.impl;

import cn.future.bms.entity.SysResource;
import cn.future.bms.mapper.SysResourceMapper;
import cn.future.bms.service.ISysResourceService;
import cn.future.bms.support.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author： ygl
 * @date： 2018/4/6
 * @Description：
 */
@Service
public class SysResourceServiceImpl extends BaseServiceImpl<SysResource> implements ISysResourceService {

    @Autowired
    private SysResourceMapper sysResourceMapper;

}