package cn.future.bms.base.repository;

import cn.future.bms.base.repository.support.AbstractConditionBuilder;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/18
 * @Description：
 */
public class BaseSpecification<T,C> implements Specification<T> {

    /**
     * 查询条件的dto
     */
    private C condition;

    public BaseSpecification(C condition) {
        this.condition = condition;
    }

    /**
     * 构建查询条件，子类必须实现addCondition方法来编写查询的逻辑。
     * @param root
     * @param query
     * @param builder
     * @return
     */
    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = addCondition(root,query,builder);
        return builder.and(predicates.toArray(new Predicate[predicates.size()]));
    }

    List<Predicate> predicates = new ArrayList<>();
    /**
     * 定义方法，适配于每个方法
     * 拼装predicates
     */
    public List<Predicate> addCondition(Root<T> root, CriteriaQuery<?> query,CriteriaBuilder builder){
        return null;
    }

    public BaseSpecification andCondition(String param){
        Object value = getValueFromCondition(param);

        return null;
    }

    public BaseSpecification orCondition(String param){
        Specification spec = null;
        return null;
    }

    public Object getValueFromCondition(String param){
        return "id";
    }
}
