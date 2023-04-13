package org.example.spring.database.repository;

import org.example.spring.bpp.annotation.Auditing;
import org.example.spring.bpp.annotation.InjectBean;
import org.example.spring.bpp.annotation.Transaction;
import org.example.spring.database.entity.Company;
import org.example.spring.database.jdbc.ConnectionPool;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Transaction
@Auditing
public class CompanyRepository implements CRUDRepository<Company, Integer> {
    @InjectBean
    private  ConnectionPool connectionPool;

    @PostConstruct
    private void postConstruct() {
        System.out.println("postConstruct method CompanyRepository");
    }

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
