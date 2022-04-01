package demo;

import com.nettyTest.pojo.Bean1;
import com.nettyTest.pojo.Bean2;
import org.junit.Test;

import java.io.*;

public class TestSerilize {
    @Test
    public void testDemo() throws IOException, ClassNotFoundException {
        Bean1 bean1=new Bean2();
        bean1.s="sss";
        bean1.d=1;

        FileOutputStream fileOutputStream=new FileOutputStream("C:\\Users\\26929\\Desktop\\test.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(bean1);
        FileInputStream fileInputStream=new FileInputStream("C:\\Users\\26929\\Desktop\\test.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object o = objectInputStream.readObject();
        Bean1 bean11=(Bean1)o;
        System.out.println(bean11.s);
    }
}
