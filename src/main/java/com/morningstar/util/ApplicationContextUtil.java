package com.morningstar.util;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
@Lazy(false)
public class ApplicationContextUtil implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext c) throws BeansException {
        context = c;
    }

    public static ApplicationContext getContext() {
        return context;
    }

    public static Object getBean(String name) throws BeansException {
        return context.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        return ctx.getBean(clazz);
    }
}
