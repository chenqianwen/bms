package cn.future.bms.support.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
/**
 * @author： ygl
 * @date： 2018/3/26
 * @Description：
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
