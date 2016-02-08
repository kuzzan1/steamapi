package main;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;
import com.rethinkdb.net.Cursor;
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

    public static final RethinkDB r = RethinkDB.r;

    public static void main(String[] args) throws TimeoutException {


        SpringApplication.run( SteamApplication.class);
        Connection conn = r.connection().hostname("176.58.126.231").port(28015).authKey( "bajskorv" ).connect();

        Cursor run = r.db( "data" ).table( "tournament" ).changes().run( conn );
        for( Object o : run ) {
            System.out.println(o);
        }
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
