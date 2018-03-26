package cn.future.bms.service.impl;

import cn.future.bms.entity.SysUser;
import cn.future.bms.mapper.SysUserMapper;
import cn.future.bms.service.ISysUserService;
import cn.future.bms.support.service.IBaseService;
import cn.future.bms.support.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author： ygl
 * @date： 2018/3/26
 * @Description：
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser,String> implements ISysUserService {

    private SysUserMapper sysUserMapper;

    @Autowired
    public void setSysUserMapper(SysUserMapper sysUserMapper) {
        this.setBaseMapper(sysUserMapper);
        this.sysUserMapper = sysUserMapper;
    }


}
