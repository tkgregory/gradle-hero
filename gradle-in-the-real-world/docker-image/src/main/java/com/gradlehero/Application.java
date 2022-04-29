package com.gradlehero;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws InterruptedException {
        System.out.println("Harness the power of Docker in your Gradle build!");
        Thread.sleep(3000);
        System.exit(0);
    }
}
