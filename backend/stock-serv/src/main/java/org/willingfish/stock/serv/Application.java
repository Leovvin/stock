package org.willingfish.stock.serv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableWebMvc
public class Application {
    public static void main(String[] args) {
        final SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.run(args);
    }
}
