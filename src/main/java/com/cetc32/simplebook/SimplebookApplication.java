package com.cetc32.simplebook;

import com.cetc32.simplebook.service.StoreService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties
@SpringBootApplication
public class SimplebookApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimplebookApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StoreService storeService){
        return (args) -> {
            storeService.deleteAll();
            storeService.init();
        };
    }
}
