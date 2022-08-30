package com.mymovie.movielog;

import com.mymovie.movielog.config.properties.AppProperties;
import com.mymovie.movielog.config.properties.CorsProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        CorsProperties.class,
        AppProperties.class
})
public class MovielogBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovielogBackendApplication.class, args);
    }

}
