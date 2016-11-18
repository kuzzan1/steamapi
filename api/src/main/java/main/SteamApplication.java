package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.concurrent.TimeoutException;

/**
 * Created by jonas on 2016-01-13.
 */
@SpringBootApplication
@EnableScheduling
public class SteamApplication {

    public static void main(String[] args) throws TimeoutException {
        SpringApplication.run( SteamApplication.class);
    }



    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/app/*").allowedOrigins("http://localhost:8000");
            }
        };
    }

}
