package demo;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

public class BeanFactoryTestDemo {
    @Test
    public void testBeanFactory(){
        DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
    }
    public static BeanFactory bindViaCode(BeanDefinitionRegistry registry){
        AbstractBeanDefinition newsProvider=new RootBeanDefinition();
        AbstractBeanDefinition newsListener=new RootBeanDefinition();
        AbstractBeanDefinition newsRegistry=new RootBeanDefinition();
        registry.registerBeanDefinition("djNewsProvider",newsProvider);
        registry.registerBeanDefinition("djListener",newsListener);
        registry.registerBeanDefinition("djRegistry",newsRegistry);
        ConstructorArgumentValues argValues=new ConstructorArgumentValues();
        argValues.addIndexedArgumentValue(0,newsListener);
        argValues.addIndexedArgumentValue(1,newsRegistry);
        newsProvider.setConstructorArgumentValues(argValues);
        return new DefaultListableBeanFactory();
    }
}
