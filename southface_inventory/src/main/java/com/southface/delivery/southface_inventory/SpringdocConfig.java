package com.southface.delivery.southface_inventory;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringdocConfig {
    @Bean
    public GroupedOpenApi api(){
        return GroupedOpenApi.builder()
            .pathsToMatch("/")
            .group("inventory")
            .build();
    }
}