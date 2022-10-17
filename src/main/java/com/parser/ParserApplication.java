package com.parser;

import com.parser.service.controller.MyController;
import com.parser.service.entity.Detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.parser")
public class ParserApplication {

    public static void main(String[] args){
        SpringApplication.run(ParserApplication.class, args);
    }



}
