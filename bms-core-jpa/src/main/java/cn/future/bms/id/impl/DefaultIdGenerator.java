package cn.future.bms.id.impl;

import cn.future.bms.id.IdGenerator;
import cn.future.bms.util.IdGenerateHelper;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

import java.io.Serializable;

/**
 * @author： ygl
 * @date： 2018/3/17
 * @Description：
 */
public class DefaultIdGenerator implements IdGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
        return IdGenerateHelper.snowflakeId();
    }
}
