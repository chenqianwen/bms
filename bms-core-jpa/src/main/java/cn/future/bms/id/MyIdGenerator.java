package cn.future.bms.id;

import cn.future.bms.util.ApplicationContextHelper;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

/**
 * @author： ygl
 * @date： 2018/3/16
 * @Description：
 * 最终的ID生成器
 */
public class MyIdGenerator implements IdentifierGenerator{

    private IdGenerator idGenerator;

    /**
     * 生成ID方法
     * @param session
     * @param obj
     * @return
     * @throws HibernateException
     */
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
        if (idGenerator == null) {
            idGenerator = ApplicationContextHelper.getBean(IdGenerator.class);
        }
        return idGenerator.generate(session,obj);
    }
}
