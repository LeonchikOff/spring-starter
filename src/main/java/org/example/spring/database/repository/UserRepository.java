package org.example.spring.database.repository;

import org.example.spring.database.jdbc.ConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private final ConnectionPool connectionPool;

    @Autowired
    public UserRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
