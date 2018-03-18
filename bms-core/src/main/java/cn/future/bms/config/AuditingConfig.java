package cn.future.bms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author： ygl
 * @date： 2018/3/17
 * @Description：
 * 开启jpa的审计功能
 */
@Configuration
@EnableJpaAuditing
public class AuditingConfig {
}
