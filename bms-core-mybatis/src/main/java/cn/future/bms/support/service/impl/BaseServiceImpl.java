package cn.future.bms.support.service.impl;

import cn.future.bms.support.auditor.AuditorService;
import cn.future.bms.support.BaseEntity;
import cn.future.bms.support.mapper.BaseMapper;
import cn.future.bms.support.service.IBaseService;
import cn.future.bms.util.IdGenerateHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/26
 * @Description：
 */
public class BaseServiceImpl<T extends BaseEntity> implements IBaseService<T> {

    @Autowired
    private AuditorService auditorService;

    @Autowired
    private BaseMapper<T> baseMapper;

    @Override
    public int insert(T t) {
        if (StringUtils.isEmpty(t.getId())) {
            t.setId(IdGenerateHelper.snowflakeId());
        }
        t.setCreatedBy(auditorService.getCurrentAuditor());
        t.setCreatedDate(new Date());
        t.setUpdatedBy(auditorService.getCurrentAuditor());
        t.setUpdatedDate(new Date(System.currentTimeMillis()));
        return baseMapper.insertSelective(t);
    }

    @Override
    public int insertList(List<T> list) {
        for (T t : list) {
            if (StringUtils.isEmpty(t.getId())) {
                t.setId(IdGenerateHelper.snowflakeId());
            }
            t.setCreatedBy(auditorService.getCurrentAuditor());
            t.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            t.setUpdatedBy(auditorService.getCurrentAuditor());
            t.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        }
        return baseMapper.insertList(list);
    }

    @Override
    public int delete(T t) {
        return baseMapper.delete(t);
    }

    @Override
    public int deleteById(String id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(T t) {
        t.setUpdatedBy(auditorService.getCurrentAuditor());
        t.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        return baseMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int updateList(List<T> list) {
        int rows = 0;
        for (T t : list) {
            t.setUpdatedBy(auditorService.getCurrentAuditor());
            t.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
            rows += update(t);
        }
        return rows;
    }

    @Override
    public T findById(String id) {
        return baseMapper.selectByPrimaryKey(id);
    }


    @Override
    public List<T> findByIds(String ids) {
        return baseMapper.selectByIds(ids);
    }

    @Override
    public List<T> findByIdArray(String[] idArray) {
        String ids = StringUtils.join(idArray, ",");
        return findByIds(ids);
    }

    @Override
    public List<T> findByIdList(List<String> idList) {
        String ids = StringUtils.join(idList, ",");
        return findByIds(ids);
    }
}
