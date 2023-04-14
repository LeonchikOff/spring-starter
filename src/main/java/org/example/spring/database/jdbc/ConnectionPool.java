package org.example.spring.database.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("connectionPool")
public class ConnectionPool {
    private final String username;
    private final Integer poolSize;

    @Autowired
    public ConnectionPool(@Value("${db.username}") String username,
                          @Value("${db.pool.size}") Integer poolSize) {
        this.username = username;
        this.poolSize = poolSize;
    }

    // Configuring bean using an initialization callback that is triggered after the constructor and setters initialisation
    @PostConstruct
    public void postConstruct() {
        System.out.println("Initialisation callback method with annotation @PostConstruct");
    }

    // The methods is launched in the process of destroying the application context
    @PreDestroy
    public void preDestroy() {
        System.out.println("Destroying callback method with annotation @PreDestroy");
    }
}
