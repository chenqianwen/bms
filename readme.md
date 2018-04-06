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

bms-base-mybatis: 基类需要用mybatis的




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
通过调用CriteriaQuery的from方法可以获得Root实例过滤条件
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
6.集成swagger2：访问地址http://localhost:port/swagger-ui.html
7.集成druid:localhost:8010/api/druid/login.html
7.集成mybatis，通用mapper，baseMapper,baseService,baseServiceImpl,baseController
封装了常用的数据库操作，crud
8.freemarker做的代码生成器，可以通过表名生成entity,mapper,mapper.xml,service,serviceImpl,controller
9.关于系统菜单权限的设置：
a.最多三级菜单：每一级可容99个菜单或者按钮
命名规则： 1  00  00   00
         (一)(二)(三)(按钮)         
举例说明：一级菜单:       1 00 00 00
            二级菜单:     1 01 00 00
                三级菜单: 1 01 01 00
                    按钮：1 01 01 01 
                    按钮：1 01 01 02 
                    按钮：1 01 01 99 
                三级菜单：1 01 02 00
                    按钮：1 01 02 01 
                    按钮：1 01 02 02 
                    按钮：1 01 02 99 
                三级菜单：1 01 99 00 
                    按钮：1 01 99 01 
                    按钮：1 01 99 02 
                    按钮：1 01 99 99 
            二级菜单:     1 02 00 00        
            二级菜单:     1 99 00 00   
        一级菜单:         2 00 00 00   
            二级菜单:     2 01 00 00   
                    按钮：2 01 00 01 
                    按钮：2 01 00 02 
                    按钮：2 01 00 99
            二级菜单:     2 02 00 00   
                三级菜单：2 02 01 00 
                    按钮：2 02 01 01 
                    按钮：2 02 01 02 
                    按钮：2 02 01 99               
        一级菜单:         9 00 00 00      
        无限一级菜单：    n 00 00 00   
b.每个菜单设计成链表形式：可找到上级菜单和下一个同级菜单