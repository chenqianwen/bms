package cn.future.bms.support.service.impl;

import cn.future.bms.support.entity.BaseEntity;
import cn.future.bms.support.mapper.BaseMapper;
import cn.future.bms.support.service.IBaseService;
import cn.future.bms.util.IdGenerateHelper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;

/**
 * @author： ygl
 * @date： 2018/3/26
 * @Description：
 */
@Service
public class BaseServiceImpl<T extends BaseEntity,ID extends Serializable> implements IBaseService<T,ID> {

    @Autowired
    private AuditorService auditorService;

    /**
     * need to autowired by subclass
     */
    @Setter
    private BaseMapper<T> baseMapper;

    @Override
    public int insert(T t) {
        t.setId(IdGenerateHelper.snowflakeId());
        t.setCreatedBy(auditorService.getCurrentAuditor());
        t.setCreatedDate(new Date());
        t.setUpdatedBy(auditorService.getCurrentAuditor());
        t.setUpdatedDate(new Date());
        return  baseMapper.insertSelective(t);
    }

    @Override
    public int delete(T t) {
        return  baseMapper.delete(t);
    }

    @Override
    public int deleteById(ID id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(T t) {
        return baseMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public T findById(String id) {
        return baseMapper.selectByPrimaryKey(id);
    }
}
