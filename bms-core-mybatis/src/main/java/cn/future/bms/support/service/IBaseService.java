package cn.future.bms.support.service;

import java.io.Serializable;
import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/26
 * @Description：
 *  Basic Interface
 */
public interface IBaseService<T> {

    /**
     * insert entity by T except null
     * if success : return true and set ID to T
     * else : return false
     * @param t entity
     * @return affect rows
     */
    int insert(T t);

    /**
     * insert entity by T except null
     * if success : return true and set ID to T
     * else : return false
     * @param t entity list
     * @return affect rows
     */
    int insertList(List<T> t);

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
    int deleteById(String id);

    /**
     * update entity by T except null
     * if success : return true and set new T to old T
     * else : return false
     * @param t entity
     * @return affect rows
     */
    int update(T t);

    /**
     * update entity by T list except null
     * if success : return true and set new T to old T
     * else : return false
     * @param t entity list
     * @return affect rows
     */
    int updateList(List<T> t);

    /**
     * select entity by ID
     * @param id  primary key
     * @return
     */
    T findById(String id);

    /**
     * select entity by more ID
     * @param ids  primary key, PS:1,2,3
     * @return
     */
    List<T> findByIds(String ids);

    /**
     * select entity by more List
     * @param ids  primary key list
     * @return
     */
    List<T> findByIdList(List<String> ids);

    /**
     * select entity by ID array
     * @param ids  primary key array
     * @return
     */
    List<T> findByIdArray(String[] ids);

}
