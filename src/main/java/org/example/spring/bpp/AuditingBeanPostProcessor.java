package org.example.spring.bpp;

import org.example.spring.bpp.annotation.Auditing;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Component
public class AuditingBeanPostProcessor implements BeanPostProcessor {

    private final Map<String, Class<?>> auditingClassBeans = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(Auditing.class))
            auditingClassBeans.put(beanName, beanClass);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = auditingClassBeans.get(beanName);
        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(),
                    ((proxy, method, args) -> {
                        System.out.println("Audit method: " + method.getName());
                        long startTimeMethod = System.nanoTime();
                        try {
                            return method.invoke(bean, args);
                        } finally {
                            long finishTimeMethod = System.nanoTime();
                            System.out.println("Time execution: " + (finishTimeMethod - startTimeMethod) + "nano");
                        }
                    }));
        }
        return bean;
    }
}
