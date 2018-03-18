关于创建通用型管理系统的设计方案：
1.	日志记录，elastic
2.	操作记录Aop
3.	权限记录
4.	功能权限和数据权限
5.	数据字典设计
6.	注解设计
7.	组织机构
8.	定时器，邮件服务，二维码工具


bms-core: 核心类：
记录日志，权限，Aop, 注解，异常，返回结果


bms-base: 基类：
rbac，数据权限
用户管理,角色管理,部门管理,字典管理



1.实现IdGenerator接口，自定义ID生成规则
2.spring data jpa Auditing审计功能
3.jpa通用baseRepository
4.fastjson定制http转换器  （2018-03-17T13:12:15.114+0000这样的日期类型转成统一的long型）
5.jsp 多条件查询Specification接口详解
public Predicate toPredicate(Root<SysUser> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder)
CriteriaQuery接口：代表一个specific的顶层查询对象，它包含着查询的各个部分，
比如：select 、from、where、group by、order by等
注意：CriteriaQuery对象只对实体类型或嵌入式类型的Criteria查询起作用
Root接口：代表Criteria查询的根对象，Criteria查询的查询根定义了实体类型，能为将来导航获得想要的结果，它与SQL查询中的FROM子句类似
3：通过调用CriteriaQuery的from方法可以获得Root实例过滤条件
A：过滤条件会被应用到SQL语句的FROM子句中。在criteria 查询中，查询条件通过Predicate或Expression实例应用到CriteriaQuery对象上。
B：这些条件使用 CriteriaQuery .where 方法应用到CriteriaQuery 对象上
C：CriteriaBuilder也作为Predicate实例的工厂，通过调用CriteriaBuilder 的条件  方（ equal,notEqual， gt， ge，lt， le，between，like等）创建Predicate对象。
D：复合的Predicate 语句可以使用CriteriaBuilder的and, or andnot 方法构建。 
例如：
 public Predicate toPredicate(Root<StudentInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {  
    Path<String> namePath = root.get("name");  
    Path<String> nicknamePath = root.get("nickname");  
    /** 
         * 连接查询条件, 不定参数，可以连接0..N个查询条件 
         */  
    query.where(cb.like(namePath, "%李%"), cb.like(nicknamePath, "%王%")); //这里可以设置任意条查询条件  
   }  
