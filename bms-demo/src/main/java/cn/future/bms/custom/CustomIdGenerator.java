package cn.future.bms.custom;

import cn.future.bms.id.IdGenerator;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.UUIDGenerator;

import java.io.Serializable;

/**
 * @author： ygl
 * @date： 2018/3/17
 * @Description：
 * 自定义ID生成器
 */
//@Component
public class CustomIdGenerator implements IdGenerator {


    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException{
        return UUIDGenerator.buildSessionFactoryUniqueIdentifierGenerator().generate(session,obj);
    }
}
