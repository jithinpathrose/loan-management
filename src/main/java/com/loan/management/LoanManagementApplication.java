package com.loan.management;

import com.loan.management.logger.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoanManagementApplication {

    public static void main(String[] args){
        Console.logDebug("Starting loan management");
        SpringApplication.run(LoanManagementApplication.class, args);
    }
}
