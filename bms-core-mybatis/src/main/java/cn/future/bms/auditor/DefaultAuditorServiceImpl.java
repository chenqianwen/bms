package cn.future.bms.auditor;

/**
 * @author： ygl
 * @date： 2018/3/26
 * @Description：
 */
public class DefaultAuditorServiceImpl implements AuditorService {

    @Override
    public String getCurrentAuditor() {
        return "system";
    }
}
