package cn.future.bms.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author： ygl
 * @date： 2018/3/17
 * @Description：
 */
@Slf4j
@Component
public class ApplicationContextHelper implements ApplicationContextAware{

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHelper.applicationContext = applicationContext;
        log.info("获取上下文的应用----------");
    }

    /**
     * 通过class获取Bean.
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz){
        return applicationContext.getBean(clazz);
    }
}
