package com.mymovie.movielog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MovielogBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovielogBackendApplication.class, args);
    }

}
