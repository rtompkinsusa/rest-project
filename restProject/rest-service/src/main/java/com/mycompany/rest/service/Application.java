package com.mycompany.rest.service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
/**
 *
 * @author W0914440
 */
@SpringBootApplication
@ImportResource("service-springConfig.xml")
public class Application {
     public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
     
        //this is the main app to run
//        /http://localhost:8080/students
    }
}
