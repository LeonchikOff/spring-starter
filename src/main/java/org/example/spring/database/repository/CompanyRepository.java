package org.example.spring.database.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.spring.bpp.annotation.Auditing;
import org.example.spring.bpp.annotation.Transaction;
import org.example.spring.database.entity.Company;
import org.example.spring.database.jdbc.ConnectionPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Scope(BeanDefinition.SCOPE_SINGLETON)
@Repository
@Transaction
@Auditing
@Getter
@RequiredArgsConstructor
public class CompanyRepository implements CRUDRepository<Company, Integer> {
    private final ConnectionPool connectionPool;
    private final List<ConnectionPool> connectionPools;
    @Value("${db.pool.size}")
    private final Integer poolSize;


    @Override
    public Optional<Company> findByID(Integer id) {
        System.out.println("findById method...");
        return Optional.of(Company.of(id));
    }

    @Override
    public void delete(Company entity) {
        System.out.println("delete method...");
    }

}

