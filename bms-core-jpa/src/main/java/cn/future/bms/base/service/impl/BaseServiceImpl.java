//package cn.future.bms.base.service.impl;
//
//import cn.future.bms.base.repository.BaseRepository;
//import cn.future.bms.base.repository.BaseSpecification;
//import cn.future.bms.base.repository.support.QueryBuilder;
//import cn.future.bms.base.service.BaseService;
//import org.springframework.data.jpa.domain.Specification;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//import java.util.List;
//
///**
// * @author： ygl
// * @date： 2018/3/18
// * @Description：
// */
//public class BaseServiceImpl<T> extends BaseSpecification<T> implements BaseService<T> {
//
//    private BaseRepository<T> baseRepository;
//
//
//    @Override
//   public List<T> getAll(QueryBuilder qb){
//        List condition = null;
//        baseRepository.findAll(new Specification<T>() {
//            @Override
//            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
//                condition.add(1);
////                Predicate p1=cb.like(root.get("id").as(String.class), "%"+"1"+"%");
////                Predicate p2=cb.equal(root.get("lastName").as(String.class), "sd");
////                Predicate p3=cb.like(root.get("email").as(String.class), "%s%");
//////              构建组合的Predicate示例：
////                Predicate p = cb.and(p3,cb.or(p1,p2));
//
//                return null;
//            }
//        });
//        return null;
//   }
//
//
//}
