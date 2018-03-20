package cn.future.bms.config.druid.properties;

import lombok.Data;

/**
 * @author： ygl
 * @date： 2018/3/20-17:38
 * @Description：
 * druid _StatViewServlet配置
 */
@Data
public class DruidStatViewServlet {

    private boolean enabled = true;
    private String urlPattern;
    private String allow;
    private String deny;
    private String loginUsername;
    private String loginPassword;
    private String resetEnable;
}
