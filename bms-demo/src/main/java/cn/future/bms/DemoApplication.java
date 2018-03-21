package cn.future.bms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author： ygl
 * @date： 2018/3/16
 * @Description：
 */
@SpringBootApplication
//@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
