package cn.future.bms.config.swagger;

import cn.future.bms.config.druid.properties.DruidProperties;
import cn.future.bms.enums.ResultEnum;
import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Predicates.or;
import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.schema.AlternateTypeRules.newRule;



/**
 * @author： ygl
 * @date： 2018/3/23
 * @Description：
 */
@EnableSwagger2
@Configuration
public class Swagger2Config {
    /**
     * TODO
     * 加入认证之后，完善。
     * https://github.com/springfox/springfox-demos
     * @return
     */
    @Bean
    public Docket petApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                  .select()
                  .apis(RequestHandlerSelectors.any())
                  .paths(PathSelectors.any())
                  .build()
                  .pathMapping("/")
                  .directModelSubstitute(LocalDate.class,
                            String.class)
                  .genericModelSubstitutes(ResponseEntity.class)
                  .alternateTypeRules(
                            newRule(typeResolver.resolve(DeferredResult.class,
                                      typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
                                      typeResolver.resolve(WildcardType.class)))
                  .useDefaultResponseMessages(false)
                  .globalResponseMessage(RequestMethod.GET,
                            newArrayList(new ResponseMessageBuilder()
                                      .code(500)
                                      .message("500 message")
                                      .responseModel(new ModelRef("Error"))
                                      .build()))
//                  .securitySchemes(newArrayList(apiKey()))
//                  .securityContexts(newArrayList(securityContext()))
                  .securitySchemes(newArrayList(oauth()))
                  .securityContexts(newArrayList(securityContext()))
                  .enableUrlTemplating(true)
                  .globalOperationParameters(
                            newArrayList(new ParameterBuilder()
                                      .name("Authorization")
                                      .defaultValue("start with bear or Basic ")
                                      .description("访问令牌")
                                      .modelRef(new ModelRef("string"))
                                      // path - Used together with Path Templating, where the parameter value is actually part of the operation's URL. This does not include the host or base path of the API. For example, in /items/{itemId}, the path parameter is itemId.
                                      //query - Parameters that are appended to the URL. For example, in /items?id=###, the query parameter is id.
                                      //header - Custom headers that are expected as part of the request. Note that RFC7230 states header names are case insensitive.
                                      //cookie
                                      .parameterType("header")
                                      .required(true)
                                      .build()))
                  .additionalModels(typeResolver.resolve(DruidProperties.class))
                  ;
    }

    @Bean
    SecurityScheme oauth() {
        return new OAuthBuilder()
                  .name("petstore_auth")
                  .grantTypes(grantTypes())
                  .scopes(scopes())
                  .build();
    }

    List<AuthorizationScope> scopes() {
        return newArrayList(
                  new AuthorizationScope("write:pets", "modify pets in your account"),
                  new AuthorizationScope("read:pets", "read your pets"));
    }
    List<GrantType> grantTypes() {
        TokenRequestEndpoint TokenEndpoint= new TokenRequestEndpoint(null,null,null);
        TokenEndpoint tokenEndpoint = new TokenEndpoint(null,null);
        GrantType grantType = new AuthorizationCodeGrant(TokenEndpoint,tokenEndpoint);
//                  .loginEndpoint(new LoginEndpoint("http://petstore.swagger.io/api/oauth/dialog"))
//                  .build();
        return newArrayList(grantType);
    }

    @Autowired
    private TypeResolver typeResolver;

    private ApiKey apiKey() {
        return new ApiKey("mykey", "api_key123", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                  .securityReferences(defaultAuth())
                  .forPaths(PathSelectors.regex("/*"))
                  .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                  = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return newArrayList(
                  new SecurityReference("mykey", authorizationScopes));
    }

    @Bean
    SecurityConfiguration security() {
        return SecurityConfigurationBuilder.builder()
                  .clientId("test-app-client-id")
                  .clientSecret("test-app-client-secret")
                  .realm("test-app-realm")
                  .appName("test-app")
                  .scopeSeparator(",")
                  .additionalQueryStringParams(null)
                  .useBasicAuthenticationWithAccessCodeGrant(false)
                  .build();
    }

    @Bean
    UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
                  .deepLinking(true)
                  .displayOperationId(false)
                  .defaultModelsExpandDepth(1)
                  .defaultModelExpandDepth(1)
                  .defaultModelRendering(ModelRendering.EXAMPLE)
                  .displayRequestDuration(false)
                  .docExpansion(DocExpansion.NONE)
                  .filter(false)
                  .maxDisplayedTags(null)
                  .operationsSorter(OperationsSorter.ALPHA)
                  .showExtensions(false)
                  .tagsSorter(TagsSorter.ALPHA)
                  .validatorUrl(null)
                  .build();
    }
}
