package cn.future.bms.auditor;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * @author： ygl
 * @date： 2018/3/17
 * @Description：
 */

public class DefaultAuditor implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("system");
    }
}
