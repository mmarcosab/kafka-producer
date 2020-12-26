package br.com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class MainApp {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(MainApp.class, args);
    }

}
