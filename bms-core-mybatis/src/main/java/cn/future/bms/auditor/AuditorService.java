package cn.future.bms.auditor;

import java.util.Optional;

/**
 * @author： ygl
 * @date： 2018/3/26
 * @Description：
 */
public interface AuditorService {

    /**
     * 获取当前审计者
     * @return
     */
    public String getCurrentAuditor();
}
