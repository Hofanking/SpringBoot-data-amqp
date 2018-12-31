package com.scorpios.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class SpringbootDataAmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDataAmqpApplication.class, args);
    }

}

