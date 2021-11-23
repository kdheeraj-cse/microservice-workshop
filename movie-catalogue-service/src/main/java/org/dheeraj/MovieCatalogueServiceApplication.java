package org.dheeraj;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
public class MovieCatalogueServiceApplication {

    @Value("${timeout}")
    private String timeout;

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplateTemplate() {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        return builder.build();
    }


    public static void main(String[] args) {
        SpringApplication.run(MovieCatalogueServiceApplication.class, args);
    }

}
