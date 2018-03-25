package cn.future.bms.mapper;

import cn.future.bms.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author： ygl
 * @date： 2018/3/20
 * @Description：
 */
@Mapper
public interface SysUserMapper {

    @Select("SELECT id, username FROM sys_user WHERE id = #{id}")
    SysUser findOne(String id);
}