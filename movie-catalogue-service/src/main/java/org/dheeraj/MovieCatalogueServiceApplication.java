package org.dheeraj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker

public class MovieCatalogueServiceApplication {

    Logger logger = LoggerFactory.getLogger(MovieCatalogueServiceApplication.class);

    @Value("${timeout}")
    private String timeout;

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplateTemplate() {
        logger.info("Rest Template Bean is initialized");
        RestTemplateBuilder builder = new RestTemplateBuilder();
        return builder.build();
    }


    public static void main(String[] args) {

        SpringApplication.run(MovieCatalogueServiceApplication.class, args);

    }

}
