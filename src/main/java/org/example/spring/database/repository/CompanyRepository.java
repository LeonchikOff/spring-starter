package org.example.spring.database.repository;

import org.example.spring.bpp.annotation.Auditing;
import org.example.spring.bpp.annotation.Transaction;
import org.example.spring.database.entity.Company;
import org.example.spring.database.jdbc.ConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Transaction
@Auditing
public class CompanyRepository implements CRUDRepository<Company, Integer> {
//    @InjectBean
//    @Qualifier("connectionPool1")
    @Autowired
    private ConnectionPool connectionPool1;
    @Autowired
    private List<ConnectionPool> connectionPools;

    @Value("${db.pool.size}")
    private Integer poolSize;

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
