package com.ranjit.blogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

 

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CategoryApp 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(CategoryApp.class, args);
    }
}
