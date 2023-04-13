package org.example.spring.bfpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;

public class VerifyPropertyBeanFactoryPostProcessor implements BeanFactoryPostProcessor, Ordered {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory");
//        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
//            List<ConstructorArgumentValues.ValueHolder> genericArgumentValues = beanDefinition.getConstructorArgumentValues().getGenericArgumentValues();
//            genericArgumentValues.stream().map(ConstructorArgumentValues.ValueHolder::getName).forEach(System.out::println);
//        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
