package com.jasmine.idempotent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lgc
 */
@SpringBootApplication
public class IdempotentApplication  {

    public static void main(String[] args) {
        SpringApplication.run(IdempotentApplication.class, args);
    }
}
