package com.nirvana.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author krishnaV
 */
@SpringBootApplication
@ComponentScan("com.nirvana.learning*")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
