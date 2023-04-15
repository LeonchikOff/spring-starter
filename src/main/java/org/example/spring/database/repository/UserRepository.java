package org.example.spring.database.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.spring.database.jdbc.ConnectionPool;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Repository
@RequiredArgsConstructor
@Getter
public class UserRepository {
    @Qualifier("connectionPool")
    private final ConnectionPool connectionPool;
}
