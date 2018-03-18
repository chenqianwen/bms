package cn.future.bms.service;

import cn.future.bms.entity.SysUser;

/**
 * @author： ygl
 * @date： 2018/3/17
 * @Description：
 */
public interface SysUserService {
    public SysUser save(SysUser model);

    public SysUser findById(String id);
}
