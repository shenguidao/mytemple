package cn.dz.daima.configer;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*swagger配置信息*/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("0.0")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //        .apis(RequestHandlerSelectors.basePackage("cn.dz.daima.controller"))
                .build();

    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("0.0API")
                .description("测试1")
                .termsOfServiceUrl("http://www.by-health.com/")
                //.contact(contact)
                .version("1.0")
                .build();
    }

    @Bean
    public Docket createPgRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("1.0")
                .apiInfo(pgApiInfoDemo())
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("cn.dz.daima.controller")).build();
    }

    private ApiInfo pgApiInfoDemo() {
        return new ApiInfoBuilder().title("1.0API").description("开发示例")
                .termsOfServiceUrl("").version("1.0").build();
    }

}



