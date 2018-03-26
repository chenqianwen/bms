package cn.future.bms.config;

import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author： ygl
 * @date： 2018/3/26
 * @Description：
 */
@Configuration
@MapperScan(basePackages = "cn.future.bms.mapper")
public class MybatisConfig {
}
