package org.example.spring;

import org.example.spring.database.repository.CRUDRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//      Dependency injection is one of the implementations of the Inversion of Control pattern
//      Injection is performed through
//      1) a constructor,
//      2) a static initialization block,
//      3) settlers of object (prevents the object from being kept immutable)
public class ApplicationRunner {
    public static void main(String[] args) {
        /*
            ClassPathXmlApplicationContext implements the ApplicationContext interface,
            which in turn extends the BeanFactory interface,
            and also contains a DefaultListableBeanFactory object,
            which contains a map that is a container of configurable components(beans).
        */
        System.out.println("************************************************");
        System.out.println("classPathXmlApplicationContext creating");
        try (ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml")) {
            System.out.println("classPathXmlApplicationContext is created");
            CRUDRepository crudRepository = classPathXmlApplicationContext.getBean("companyRepository", CRUDRepository.class);
            crudRepository.findByID(1);
        }
        System.out.println("classPathXmlApplicationContext is closed");
        System.out.println("*******************************************");
    }
}
