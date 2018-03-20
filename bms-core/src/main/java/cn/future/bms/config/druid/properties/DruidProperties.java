package cn.future.bms.config.druid.properties;

import com.alibaba.druid.filter.logging.Log4jFilter;
import com.alibaba.druid.pool.DruidAbstractDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author： ygl
 * @date： 2018/3/20-16:42
 * @Description：
 * alibaba DruidDataSource properties
 */
@Data
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DruidProperties {

    /**############################# 连接池配置 #############################**/
    /**
     * 配置初始化大小、最小、最大
     */
    private int initialSize = 1;
    private int minIdle = 1;
    private int maxActive = 20;
    /**
     * 配置获取连接等待超时的时间,单位是毫秒
     * 获取连接时最大等待时间，单位毫秒。
     * 配置了maxWait之后，缺省启用公平锁，并发效率会有所下降，如果需要可以通过配置useUnfairLock属性为true使用非公平锁。
     */
    private int maxWait = 60000;
    /**
     * 是否缓存preparedStatement，也就是PSCache。用oracle可以配置true,mysql可以配置为false。
     * PSCache对支持游标的数据库性能提升巨大，比如说oracle。
     * 在mysql5.5以下的版本中没有PSCache功能，建议关闭掉。作者在5.5版本中使用PSCache，通过监控界面发现PSCache有缓存命中率记录，应该是支持PSCache。
     */
    private boolean poolPreparedStatements = false;
    /**
     * 指定每个连接上PSCache的大小
     */
    private int maxPoolPreparedStatementPerConnectionSize=  0;
    /**
     * 用来检测连接是否有效的sql，要求是一个查询语句。
     * 如果validationQuery为null，testOnBorrow、testOnReturn、testWhileIdle都不会其作用。
     */
    private String validationQuery= "SELECT 'x'";
    /**
     * 单位：秒，检测连接是否有效的超时时间。
     * 底层调用jdbc Statement对象的void setQueryTimeout(int seconds)方法
     */
    private int validationQueryTimeout= 1;
    /**
     * 申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。
     */
    private boolean testOnBorrow= false;
    /**
     * 归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能
     */
    private boolean testOnReturn= false;
    /**
     * 建议配置为true，不影响性能，并且保证安全性。
     * 申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。
     */
    private boolean testWhileIdle= true;
    /**
     * 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
     */
    private long timeBetweenEvictionRunsMillis= 60000;
    /**
     * 配置一个连接在池中最小生存的时间，单位是毫秒
     */
    private long minEvictableIdleTimeMillis= 300000;
    /**
     * 一个连接在池中最大生存的时间，单位是毫秒
     */
    private long maxEvictableIdleTimeMillis= 600000;
    /**
     * 配置监控统计拦截的filters
     */
    private String filters= "stat,wall,log4j";

    /**############################# 监控配置 #############################**/
    private DruidWebStatFilterProperties webStatFilter = new DruidWebStatFilterProperties();
    private DruidStatViewServlet statViewServlet = new DruidStatViewServlet();
}
