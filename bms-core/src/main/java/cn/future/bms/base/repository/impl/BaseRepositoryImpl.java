package cn.future.bms.base.repository.impl;

import cn.future.bms.base.repository.BaseRepository;
import cn.future.bms.base.entity.BaseEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author： ygl
 * @date： 2018/3/17
 * @Description：
 */
public class BaseRepositoryImpl<T extends BaseEntity> extends SimpleJpaRepository<T, String> implements BaseRepository<T> {

    private final EntityManager entityManager;

    BaseRepositoryImpl(JpaEntityInformation entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    /**
     * 实体的条件查询
     */
    public List<T>  find(Specification<T> spec){
        // Specification：条件
        List<T> all = findAll(spec);
        return all;
    }
    /**
     *
     * @param id
     * @return
     */
    @Override
    public Optional<T> findById(String id) {
        Map<String, Object> map = new HashMap<>();
        map.put("is_deleted",0);
        Class<T> domainType = this.getDomainClass();
        return Optional.ofNullable(this.entityManager.find(domainType, id, map));
    }



}
