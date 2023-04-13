package org.example.spring.database.jdbc;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;

public class ConnectionPool implements InitializingBean, DisposableBean {
    private String username;
    private Integer poolSize;
    private List<Object> args;
    private Map<String, Object> properties;

    public ConnectionPool() {
    }

    public ConnectionPool(String username, Integer poolSize, List<Object> args, Map<String, Object> properties) {
        System.out.println("Create object via Constructor and dependency inject");
        this.username = username;
        this.poolSize = poolSize;
        this.args = args;
        this.properties = properties;
    }

    public void setProperties(Map<String, Object> properties) {
        System.out.println("Dependency inject via setProperties");
        this.properties = properties;
    }

    // Configuring bean using an initialization callback that is triggered after the constructor and setters initialisation
    @PostConstruct
    public void postConstruct() {
        System.out.println("Initialisation callback method with annotation @PostConstruct");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initialization callback implements the afterPropertiesSet method from InitializingBean");
    }

    private void initMethod() {
        System.out.println("Initialisation callback init-method from xml");
    }

    // The methods is launched in the process of destroying the application context
    @PreDestroy
    public void preDestroy() {
        System.out.println("Destroying callback method with annotation @PreDestroy");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroying callback implements the destroy method from DisposableBean");
    }

    private void destroyMethod() {
        System.out.println("Destroying callback destroy-method from xml");
    }
}
