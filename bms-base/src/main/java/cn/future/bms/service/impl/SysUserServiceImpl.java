package cn.future.bms.service.impl;

import cn.future.bms.base.repository.support.QueryBuilder;
//import cn.future.bms.base.service.impl.BaseServiceImpl;
import cn.future.bms.dao.SysUserDao;
import cn.future.bms.entity.SysUser;
import cn.future.bms.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author： ygl
 * @date： 2018/3/17
 * @Description：
 */
@Service
class SysUserServiceImpl  implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public SysUser save(SysUser model) {
        return sysUserDao.save(model);
    }

    @Override
    public SysUser findById(String id) {
        Specification<SysUser> spec = new Specification<SysUser>() {
            @Override
            public Predicate toPredicate(Root<SysUser> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> createdBy = root.get("createdBy");
                Path<Object> id1 = root.get("id");
                Predicate p1 = criteriaBuilder.equal(createdBy, "system");
                Predicate p2 = criteriaBuilder.equal(id1, "424676363291668480");
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(p1);
                predicates.add(p2);
                Predicate[] array = predicates.toArray(new Predicate[predicates.size()]);
                Predicate and = criteriaBuilder.and(array);
                Predicate p3 = criteriaBuilder.equal(createdBy, "system1");
                Predicate[] array1 = new Predicate[]{and,p3};
                Predicate finalPre = criteriaBuilder.or(array1);
                CriteriaQuery<?> where = criteriaQuery.where(finalPre);
                return null;
            }
        };
        List<SysUser> all = sysUserDao.findAll(spec);
        List<Predicate> predicates = new ArrayList<>();
//        addLikeCondition(queryWrapper, "username");
        QueryBuilder builder = new QueryBuilder();
        builder.and("username").or("password");
//        List<SysUser> alla = sysUserDao.getAll(builder);
        return all.get(0);
    }



//    @Override
//    public List<Predicate> addCondition(Root<SysUser> root, CriteriaQuery<?> query,CriteriaBuilder builder){
//        Path<Object> id1 = root.get("id");
//        Predicate predicate = builder.equal(id1, "424676105174200320");
//        List<Predicate> list = new ArrayList<>();
//        list.add(predicate);
//        return list;
//    }

    /**
     * 自定义条件
     */
}
