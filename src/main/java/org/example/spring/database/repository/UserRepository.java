package org.example.spring.database.repository;

import org.example.spring.database.jdbc.ConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Repository
public class UserRepository {
    private final ConnectionPool connectionPool;

    @Autowired
    public UserRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public ConnectionPool getConnectionPool() {
        return connectionPool;
    }
}
