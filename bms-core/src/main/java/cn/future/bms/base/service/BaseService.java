package cn.future.bms.base.service;

import cn.future.bms.base.repository.support.QueryBuilder;

import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/18
 * @Description：
 * 基类service
 */
public interface BaseService<T> {
    /**
     *
     * @return
     */
    List<T> getAll(QueryBuilder builder);
}
