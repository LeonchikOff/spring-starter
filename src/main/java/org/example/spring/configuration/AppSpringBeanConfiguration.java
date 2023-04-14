package org.example.spring.configuration;

import org.example.spring.database.repository.CRUDRepository;
import org.example.web.configuration.AppWebBeanConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Configuration
@ImportResource("classpath:beans.xml")
@Import(AppWebBeanConfiguration.class)
@ComponentScan(basePackages = "org.example.spring",
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Component.class),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = CRUDRepository.class),
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "org\\..+Repository")
        })
//<context:component-scan base-package="org.example.spring"/>
@PropertySource("classpath:application.properties")
//<context:property-placeholder location="classpath:application.properties/>
public class AppSpringBeanConfiguration {
}