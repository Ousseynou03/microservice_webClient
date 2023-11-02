package com.mybook.mybook;

import com.mybook.mybook.entities.Book;
import com.mybook.mybook.repositories.BookRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class MybookApplication {
    @Bean
    WebClient webClient(){
        return WebClient.builder().build();
    }
    public static void main(String[] args) {
        SpringApplication.run(MybookApplication.class, args);
    }

}
