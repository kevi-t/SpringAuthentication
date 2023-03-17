package spring.authentication.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAuthenticationApplication {

    public static void main(String[] args) {
        System.out.println("APPLICATION STARTING");
        SpringApplication.run(SpringAuthenticationApplication.class, args);
    }

}
