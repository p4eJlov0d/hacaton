package ru.p4ejlov0d.hacaton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import ru.p4ejlov0d.hacaton.configuration.GnewsProperties;

@EnableScheduling
@SpringBootApplication
@EnableConfigurationProperties(GnewsProperties.class)
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
