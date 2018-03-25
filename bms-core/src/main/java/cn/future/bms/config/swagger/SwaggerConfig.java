package cn.future.bms.config.swagger;

import com.google.common.base.Predicate;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;


/**
 * @author： ygl
 * @date： 2018/3/23
 * @Description：
 */
//@Configuration
//@EnableSwagger2
public class SwaggerConfig {
    /**
     * swagger2的配置文件
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        ParameterBuilder tokenBuilder = new ParameterBuilder();
        List<Parameter> parameterList = new ArrayList<>();
        tokenBuilder.name("Authorization")
                  .defaultValue("去其他请求中获取heard中token参数")
                  .description("令牌")
                  .modelRef(new ModelRef("string"))
                  .parameterType("header")
                  .required(true).build();
        parameterList.add(tokenBuilder.build());
        return new Docket(DocumentationType.SWAGGER_2)
                  .groupName("SYSTEM_BASE")
                  .apiInfo(apiInfo())
                  .select()
                    .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                    .paths(sysPaths())
                    .build()
                  .globalOperationParameters(parameterList);
    }

    /**
     * 系统基类API
     *
     * @return
     */
    public Predicate<String> sysPaths() {
        return or(regex("/sys.*"));
    }

    @Bean
    public Docket testApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                  .groupName("test")
//                  .genericModelSubstitutes(DeferredResult.class)
//                .genericModelSubstitutes(ResponseEntity.class)
                  .useDefaultResponseMessages(false)
                  .forCodeGeneration(true)
                  .select()
                  .paths(or(regex("/error.*")))
                  .build()
                  .apiInfo(apiInfo());
    }


    /**
     * 构建 api文档的详细信息函数
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                  //页面标题
                  .title("BMS-API")
                  //name表示作者，url通常作为项目的链接，email邮箱
                  .contact(new Contact("JackYang", "http://localhost:8090/bms", "1433414364@qq.com"))
                  //描述
                  .description("API OF BMS CREATED BY SWAGGER!")
                  //版本号
                  .version("1.0")
                  .build();
    }
}
