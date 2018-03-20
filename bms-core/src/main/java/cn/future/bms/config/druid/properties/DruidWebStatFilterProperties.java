package cn.future.bms.config.druid.properties;

import lombok.Data;

/**
 * @author： ygl
 * @date： 2018/3/20-17:29
 * @Description：
 * druid _配置WebStatFilter
 */
@Data
public class DruidWebStatFilterProperties {

    /**
     * 是否开启WebStatFilter配置
     */
    private boolean enabled = true;

    private String urlPattern;
    /**
     * 用于排除一些不必要的url，比如.js,/jslib/等等
     */
    private String exclusions;
    /**
     * 缺省sessionStatMaxCount是1000个。你可以按需要进行配置
     */
    private String sessionStatMaxCount;
    /**
     * 你可以关闭session统计功能
     */
    private String sessionStatEnable;
    /**
     * 配置principalSessionName，使得druid能够知道当前的session的用户是谁
     */
    private String principalSessionName;
    /**
     * 如果你的user信息保存在cookie中，你可以配置principalCookieName，使得druid知道当前的user是谁
     */
    private String principalCookieName;
    /**
     * 配置profileEnable能够监控单个url调用的sql列表
     */
    private String profileEnable;
}
