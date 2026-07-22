package com.weeqxa.gameshelf.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Getter
@Setter
@ConfigurationProperties(prefix = "rawg")
public class RawgProperties {

    private String apiKey;

    private String baseUrl;
}
