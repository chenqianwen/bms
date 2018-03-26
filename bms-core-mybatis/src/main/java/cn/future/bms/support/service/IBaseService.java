package cn.future.bms.support.service;

import java.io.Serializable;

/**
 * @author： ygl
 * @date： 2018/3/26
 * @Description：
 *  Basic Interface
 */
public interface IBaseService<T ,ID extends Serializable> {

    /**
     * insert entity by T except null
     * if success : return true and set ID to T
     * else : return false
     * @param t entity
     * @return affect rows
     */
    int insert(T t);

    /**
     * delete entity by T
     * @param t
     * @return affect rows
     */
    int delete(T t);

    /**
     * delete entity by ID
     * @param id id
     * @return
     */
    int deleteById(ID id);

    /**
     * update entity by T except null
     * if success : return true and set new T to old T
     * else : return false
     * @param t entity
     * @return affect rows
     */
    int update(T t);

    /**
     * select entity by ID
     * @param id  primary key
     * @return
     */
    T findById(String id);

}
