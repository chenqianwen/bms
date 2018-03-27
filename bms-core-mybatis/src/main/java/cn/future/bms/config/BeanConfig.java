package cn.future.bms.config;

import cn.future.bms.support.auditor.AuditorService;
import cn.future.bms.support.auditor.DefaultAuditorServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author： ygl
 * @date： 2018/3/26
 * @Description：
 */
@Configuration
public class BeanConfig {

    @Bean
    @ConditionalOnMissingBean(name = "auditorService")
    public AuditorService auditorService(){
        return  new DefaultAuditorServiceImpl();
    }
}
