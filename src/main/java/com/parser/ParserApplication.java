package com.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.parser")
public class ParserApplication {

    public static void main(String[] args){
        SpringApplication.run(ParserApplication.class, args);


    }



}
