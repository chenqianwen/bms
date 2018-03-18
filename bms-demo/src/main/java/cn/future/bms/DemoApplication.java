package cn.future.bms;

import cn.future.bms.base.repository.impl.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author： ygl
 * @date： 2018/3/16
 * @Description：
 */
@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
