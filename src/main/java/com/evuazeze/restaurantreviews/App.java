package com.evuazeze.restaurantreviews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public Docket swaggerConfiguration() {
        // Return a prepared Docket instance
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/v1/**"))
                .apis(RequestHandlerSelectors.basePackage("com.evuazeze.restaurantreviews"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Restaurant Reviews API",
                "An application for reviewing visited restaurants",
                "1.0",
                "Free to test",
                new springfox.documentation.service.Contact("Emmanuel Evuazeze", "https://github.com/evuazeze", "evuazeze.emmanuel@gmail.com"),
                "API license",
                "https://github.com/evuazeze",
                Collections.emptyList());
    }

}
