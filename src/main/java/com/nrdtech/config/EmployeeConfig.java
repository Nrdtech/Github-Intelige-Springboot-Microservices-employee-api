package com.nrdtech.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EmployeeConfig {

    @Value("${addressservice.base.url}")
    private String addressBaseUrl;

    @Bean
    public static ModelMapper getModelMapper(){
        return new ModelMapper();
    }
    /*@Bean
    public static RestTemplate getRestTemplate(){
        return new RestTemplate();
    }*/
    @Bean
    public WebClient getWebClient(){
        return  WebClient
                .builder()
                .baseUrl(addressBaseUrl)
                .build();
    }
}
