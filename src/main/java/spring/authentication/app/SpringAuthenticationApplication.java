package spring.authentication.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import spring.authentication.app.config.SecurityConfiguration;

@SpringBootApplication
public class SpringAuthenticationApplication {

    public static void main(String[] args) {
        System.out.println("APPLICATION STARTING");
        SpringApplication.run(SpringAuthenticationApplication.class, args);
    }

}
