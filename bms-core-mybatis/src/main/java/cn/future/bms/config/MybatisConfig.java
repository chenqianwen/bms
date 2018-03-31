package cn.future.bms.config;

import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author： ygl
 * @date： 2018/3/26
 * @Description：
 */
@Configuration
@MapperScan(basePackages = MybatisConfig.basePackages)
public class MybatisConfig {

    /**
     * mapper 包路径
     */
    public final static String basePackages = "cn.future.bms.mapper";
}
