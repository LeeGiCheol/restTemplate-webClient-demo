package com.example.resttemplate_webclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class RestTemplateWebClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestTemplateWebClientApplication.class, args);
    }


    // 전역적으로 커스터마이징 설정
    @Bean
    public WebClientCustomizer webClientCustomizer() {
        return new WebClientCustomizer() {
            @Override
            public void customize(WebClient.Builder webClientBuilder) {
                webClientBuilder.baseUrl("http://localhost:8080");
            }
        };
    }


    // Apache HttpClient를 사용할 경우
    @Bean
    public RestTemplateCustomizer restTemplateCustomizer() {
        return restTemplate -> restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
    }

}
