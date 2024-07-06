package am.itspace.kafkaproducerservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class KafkaProducerServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerServicesApplication.class, args);
    }

}
