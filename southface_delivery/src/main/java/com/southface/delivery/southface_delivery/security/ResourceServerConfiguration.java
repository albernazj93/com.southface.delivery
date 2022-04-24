package com.southface.delivery.southface_delivery.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    
@Override
    public void configure(HttpSecurity http) throws Exception
    {
        // http.authorizeRequests().anyRequest().authenticated()
        //     .antMatchers("/swagger-ui/**").permitAll();
            // .antMatchers (HttpMethod.GET, "/wines/search/**").hasRole("BA")
            http.authorizeRequests()
            .antMatchers("/api/**").authenticated()
            .antMatchers("/", "/swagger-ui/**").permitAll()
            .antMatchers("/", "/h2-console/**").permitAll();

            http.csrf().disable();
            http.headers().frameOptions().disable();
    }
}
