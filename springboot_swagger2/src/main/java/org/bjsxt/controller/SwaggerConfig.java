package org.bjsxt.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration  //表明这是一个注解类
@EnableSwagger2  //开启 Swagger2
public class SwaggerConfig {

    /**
     * 配置 Swagger 的 Docket 的 Bean 实例
     *
     * @return
     */
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

    //配置 Swagger信息=apiInfo
    private ApiInfo apiInfo() {
        //作者信息
        Contact contact = new Contact("Hedon", "http://hedon.wang", "171725713@qq.com");

        return new ApiInfo("Swagger API 文档",                    //文档标题
                "这个是一个 Swagger 接口文档。",              //文档描述
                "v1.0",                                       //文档版本
                "http://heon.wang",                   //队伍的网站地址
                contact,                                              //作者信息
                "Apache 2.0",                                  //许可证
                "http://www.apache.org/licenses/LICENSE-2.0",//许可证Url
                new ArrayList());
    }

//    private List<SysMenu> getChiledNenus(){
//        ArrayList<SysMenu> childs = new ArrayList<>();
//
//        return childs;
//    }

}
