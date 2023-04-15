package org.example.spring;

import org.example.spring.configuration.AppSpringBeanConfiguration;
import org.example.spring.service.CompanyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        System.out.println("annotationConfigApplicationContext creating");
        try (AnnotationConfigApplicationContext annotationConfigApplicationContext =
                     new AnnotationConfigApplicationContext(AppSpringBeanConfiguration.class)) {
            System.out.println("annotationConfigApplicationContext is created");
            CompanyService companyService = annotationConfigApplicationContext.getBean(CompanyService.class);
            System.out.println(companyService.findById(1));
        }
        System.out.println("annotationConfigApplicationContext is closed");
        System.out.println("*******************************************");
    }
}
