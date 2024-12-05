package az.company.scraperservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ScraperServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScraperServiceApplication.class, args);
    }

}
