package com.example.boot;


import com.example.boot.flume.FlumeAgentApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApp {

    public static void main(String[] args) {
        //FlumeAgentApplication.start("classpath:flume.properties");

        SpringApplication.run(MainApp.class, args);
    }
}
