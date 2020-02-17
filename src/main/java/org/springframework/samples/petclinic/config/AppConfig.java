package org.springframework.samples.petclinic.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

@Configuration
@PropertySource("ham.properties")
public class AppConfig {

    @Value("${me.ham.name}")
    String name;

    @PostConstruct
    public void printName(){
        System.out.println("ham.properties ::: name :::"+name);
    }
}
