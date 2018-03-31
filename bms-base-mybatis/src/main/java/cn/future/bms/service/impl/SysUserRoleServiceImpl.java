package cn.future.bms.service.impl;

import cn.future.bms.entity.SysUserRole;
import cn.future.bms.mapper.SysUserRoleMapper;
import cn.future.bms.service.ISysUserRoleService;
import cn.future.bms.support.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author： ygl
 * @date： 2018/3/26
 * @Description：
 */
@Service
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRole> implements ISysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

}
