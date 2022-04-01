import com.demo3.config.PrivateDemo;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

public class ClassDemoTest {
    @Test
    public void testNewInstance() throws NoSuchMethodException {
        final Class<PrivateDemo> privateDemoClass = PrivateDemo.class;
        final Constructor<PrivateDemo> declaredConstructor = privateDemoClass.getDeclaredConstructor("demo".getClass());
        System.out.println(declaredConstructor);
    }
}
