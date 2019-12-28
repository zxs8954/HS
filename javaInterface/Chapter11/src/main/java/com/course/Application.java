package com.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PreDestroy;

/**
 * 这种Application注解的写法就不用加上@ComponentScan("com.course")这个注解了
 * 下面这种写法最常见
 */
@EnableScheduling
@SpringBootApplication
public class Application {
    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        Application.context= SpringApplication.run(Application.class,args);
    }
    @PreDestroy
    public void close(){
        Application.context.close();
    }
}
