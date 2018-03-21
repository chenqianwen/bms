package cn.future.bms.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author： ygl
 * @date： 2018/3/17
 * @Description：
 * 数据访问层基类
 */
@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T,String>,JpaSpecificationExecutor<T>{


    /**
     * 单表的条件查询
     */

}
