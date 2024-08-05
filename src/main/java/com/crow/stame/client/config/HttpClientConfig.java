package com.crow.stame.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class HttpClientConfig {
    @Value("${kitsu.api.url}")
    private String kitsuApiUrl;

    @Bean
    public WebClient kitsuWebClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder.baseUrl(kitsuApiUrl)
                .defaultHeader("Accept", "application/vnd.api+json")
                .defaultHeader("Content-Type", "application/vnd.api+json")
                .build();
    }
}
