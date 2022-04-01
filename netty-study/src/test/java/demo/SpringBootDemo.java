package demo;

import com.nettyTest.NettyStart;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.BootstrapRegistryInitializer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

@SpringBootTest(classes = NettyStart.class)
public class SpringBootDemo {
    @Test
    public void testDemo1(){
        List<ApplicationContextInitializer> bootstrapRegistryInitializers = SpringFactoriesLoader.loadFactories(ApplicationContextInitializer.class, this.getClass().getClassLoader());
        System.out.println(bootstrapRegistryInitializers);
    }
}
