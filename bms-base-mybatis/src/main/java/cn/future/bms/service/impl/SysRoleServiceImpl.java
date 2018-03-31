package cn.future.bms.service.impl;

import cn.future.bms.entity.SysRole;
import cn.future.bms.mapper.SysRoleMapper;
import cn.future.bms.service.ISysRoleService;
import cn.future.bms.support.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author： ygl
 * @date： 2018/3/26
 * @Description：
 */
@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole> implements ISysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

}
