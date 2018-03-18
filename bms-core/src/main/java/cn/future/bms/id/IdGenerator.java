package cn.future.bms.id;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

import java.io.Serializable;

/**
 * @author： ygl
 * @date： 2018/3/16
 * @Description：
 * id生成器接口
 */
public interface IdGenerator {
    /**
     * 生成ID的方法
     * @param session
     * @param obj
     * @return
     * @throws HibernateException
     */
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException;
}
