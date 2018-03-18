package cn.future.bms.config;

import cn.future.bms.auditor.DefaultAuditor;
import cn.future.bms.id.IdGenerator;
import cn.future.bms.id.impl.DefaultIdGenerator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

/**
 * @author： ygl
 * @date： 2018/3/16
 * @Description：
 * bms逻辑上bean配置
 */
@Configuration
public class BeanConfig {

    /**
     * 设置的ID生成器
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(IdGenerator.class)
    public IdGenerator idGeneratorInterface(){
        return new DefaultIdGenerator();
    }
    /**
     * 设置的审计者
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(AuditorAware.class)
    public AuditorAware auditorAware(){
        return new DefaultAuditor();
    }
}
