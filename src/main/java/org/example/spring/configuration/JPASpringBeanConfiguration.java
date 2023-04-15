package org.example.spring.configuration;

import org.example.spring.configuration.condition.JPACondition;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Conditional(JPACondition.class)
@Configuration
public class JPASpringBeanConfiguration {

    @PostConstruct
    void init() {
        System.out.println("JPASpringBeanConfiguration added to BeanFactory");
    }

//    @Bean
//    @ConfigurationProperties(prefix = "db")
//    public DatabaseProperties databaseProperties() {
//        return new DatabaseProperties();
//    }
}
