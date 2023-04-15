package org.example.spring.configuration;

import org.example.web.configuration.AppWebBeanConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppWebBeanConfiguration.class)
//@ComponentScan(basePackages = "org.example.spring")
//<context:component-scan base-package="org.example.spring"/>
//@PropertySource("classpath:application.properties")
//<context:property-placeholder location="classpath:application.properties/>
public class AppSpringBeanConfiguration {
}