package com.study.jpaentitylistener.support;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanUtils implements ApplicationContextAware  {
    // ApplicationContextAware : ApplicationContext 를 관리하기 위한 class

    private static ApplicationContext applicationContext;
    //  ApplicationContext : Bean 생성과 관련된 spring 의 IoC(Injection of Control) 엔진

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanUtils.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }
}
