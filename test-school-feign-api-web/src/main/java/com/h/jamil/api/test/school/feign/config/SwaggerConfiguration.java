package com.h.jamil.api.test.school.feign.config;

import com.h.jamil.api.framework.config.GitVersion;
import com.h.jamil.api.framework.utility.HideInternalsParameterPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
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

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Autowired
    GitVersion gitVersion;

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("RESTful API")
                .contact(new Contact("Hassan Jamil", "", "hasssanjamilz@gmail.com"))
                .description("RESTful API for Test project")
                .termsOfServiceUrl("somthing")
                .license("Apache License Version 2.0")
                .licenseUrl("something")
                .version("1.0 "+gitVersion.getVersionString())
                .build();
    }

    @Bean
    public Docket internalApi() {
        Docket thisDocket;
        thisDocket = new Docket(DocumentationType.SWAGGER_2)
                // Optional
                .groupName("Enterprise APIs")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                // Ensure to properly specify the proper version number of this API as part of URL path below
                .paths(regex("/v1.*"))
                .build();
        return thisDocket;
    }

    @Bean
    public Docket externalApi() {
        //Adding Header
        ParameterBuilder aParameterBuilder = new ParameterBuilder();
        aParameterBuilder.name("apiKey").modelRef(new ModelRef("string")).description("API Key identifying the calling application").parameterType("header").required(true).build();
        List<Parameter> aParameters = new ArrayList<Parameter>();
        aParameters.add(aParameterBuilder.build());
        aParameterBuilder.name("apiSecret").modelRef(new ModelRef("string")).description("API Key verifying the calling applications identity").parameterType("header").required(true).build();
        aParameters.add(aParameterBuilder.build());

        Docket thisDocket;
        thisDocket = new Docket(DocumentationType.SWAGGER_2)
                // Optional
                .groupName("Enterprise APIs External")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex("/v1.*"))
                .build()
                .globalOperationParameters(aParameters);
        return thisDocket;
    }

    @Bean
    public HideInternalsParameterPlugin hideinternalsPlugin(){
        return new HideInternalsParameterPlugin( (group, name) -> group.endsWith("External") && "sourceSystem".equals(name));
    }
}
