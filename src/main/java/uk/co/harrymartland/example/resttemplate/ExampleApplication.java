package uk.co.harrymartland.example.resttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import uk.co.harrymartland.example.resttemplate.configuration.ApiProperties;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties(ApiProperties.class)
public class ExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }

}