import com.demo3.Demo3Start;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(classes = Demo3Start.class)
public class Demo3Test {
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void demo3(){
        final String forObject = restTemplate.getForObject("https://localhost:8761/demo/test", String.class);
        System.out.println(forObject);
    }

}
