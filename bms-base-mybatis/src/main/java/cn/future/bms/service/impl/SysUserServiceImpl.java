package cn.future.bms.service.impl;

import cn.future.bms.entity.SysUser;
import cn.future.bms.mapper.SysUserMapper;
import cn.future.bms.service.ISysUserService;
import cn.future.bms.support.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author： ygl
 * @date： 2018/3/26
 * @Description：
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

}
