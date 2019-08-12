package ro.devtester.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "ro.devtester.api")
@EnableSwagger2
public class SuperheroesApplication {

    public static void main(String[] args) {
        new SpringApplication(SuperheroesApplication.class).run(args);
    }

}