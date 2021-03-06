package com.emu.apps.bookmarks.web.rest.config;

import com.emu.apps.bookmarks.web.rest.BookmarkApi;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.Collections;
import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.withClassAnnotation;

@Configuration
@EnableSwagger2WebMvc
@Import({springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration.class})
public class SwaggerBookmarksConfig {

   @Bean
    public Docket bookmarkApiv1() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(BookmarkApi.API_V1)
                .select()
                .apis(withClassAnnotation(RestController.class))
                .paths(regex(BookmarkApi.API_V1 + ".*"))
                .build()
                .enable(true)
                .apiInfo(metaData(BookmarkApi.VERSION))
                .produces(Collections.singleton("application/json"))
                .securityContexts(Lists.newArrayList(buildSecurityContext()))
                .securitySchemes(Lists.newArrayList(buildSecurityScheme()));

    }


    private ApiKey buildSecurityScheme() {
        return new ApiKey("Authorization", "Authorization", "header");
    }

    private SecurityContext buildSecurityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(regex(BookmarkApi.API_V1 + ".*"))
                .build();
    }

    private List <SecurityReference> defaultAuth() {

        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference("Authorization", authorizationScopes));
    }


    private ApiInfo metaData(String version) {

        return new ApiInfo(
                "Bookmarks Rest API",
                "",
                version,
                "Terms of service",
                new Contact("Eric MULLER", "https://webmarks.net", "eric.pierre.muller@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0", Lists.newArrayList());
    }
}