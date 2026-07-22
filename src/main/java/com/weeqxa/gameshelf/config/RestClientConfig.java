package com.weeqxa.gameshelf.config;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
@EnableConfigurationProperties(RawgProperties.class)
public class RestClientConfig {

    @Bean
    public RestClient restClient(RawgProperties rawgProperties) {
        return RestClient.builder()
                .baseUrl(rawgProperties.getBaseUrl())
                .build();
    }
}
