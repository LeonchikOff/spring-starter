package org.example.spring;

import org.example.spring.database.jdbc.pool.ConnectionPool;
import org.example.spring.database.repository.CompanyRepository;
import org.example.spring.database.repository.UserRepository;
import org.example.spring.ioc.ContainerCDI;
import org.example.spring.service.UserService;

//      Dependency injection is one of the implementations of the Inversion of Control pattern
//      Injection is performed through
//      1) a constructor,
//      2) a static initialization block,
//      3) settlers of object (prevents the object from being kept immutable)
public class ApplicationRunner {
    public static void main(String[] args) {

//      In this case, the injection of dependencies is controlled by the Application Runner class
        ConnectionPool connectionPool = new ConnectionPool();
        UserRepository userRepository = new UserRepository(connectionPool);
        CompanyRepository companyRepository = new CompanyRepository(connectionPool);
        UserService userService = new UserService(userRepository, companyRepository);

//      In this case, the injection of dependencies is controlled by the ContainerCDI class
        ContainerCDI containerCDI = new ContainerCDI();
        ConnectionPool connectionPoolFromCDI = containerCDI.get(ConnectionPool.class);
        UserRepository userRepositoryFromCDI = containerCDI.get(UserRepository.class);
        CompanyRepository companyRepositoryFromCDI = containerCDI.get(CompanyRepository.class);
        UserService userServiceFromCDI = containerCDI.get(UserService.class);
        //TODO using of userService
    }
}
