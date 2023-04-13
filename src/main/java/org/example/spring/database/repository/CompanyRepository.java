package org.example.spring.database.repository;

import org.example.spring.bpp.annotation.InjectBean;
import org.example.spring.database.jdbc.ConnectionPool;

public class CompanyRepository {
    @InjectBean
    private  ConnectionPool connectionPool;

}
