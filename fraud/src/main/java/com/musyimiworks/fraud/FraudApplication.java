package com.musyimiworks.fraud;

import com.musyimiworks.amqp.RabbitMQMessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = {
                "com.musyimiworks.fraud",
                "com.musyimiworks.amqp"
        }
)
@EnableEurekaClient
public class FraudApplication {
    public static void main(String[] args) {
        SpringApplication.run(FraudApplication.class, args);
    }
//    @Bean
//    CommandLineRunner commandLineRunner(
//            RabbitMQMessageProducer producer,
//            FraudConfig fraudConfig
//    ){
//        return args -> {
//            producer.publish(
//                    new Person("Miskuzi", 30),
//                    fraudConfig.getInternalExchange(),
//                    fraudConfig.getInternalNotificationRoutingkey()
//            );
//        };
//    }
//
//    record Person(String name, int age){}
}
