package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * Multi Persistence Technologies
 */
@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.example.demo")
//@EnableJpaRepositories(basePackages = "com.acme.repositories.jpa")
//@EnableMongoRepositories(basePackages = "com.acme.repositories.mongo")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
