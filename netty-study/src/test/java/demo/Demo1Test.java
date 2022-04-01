package demo;

import com.nettyTest.config.WebConfig;
import com.nettyTest.lazydemo.LazyTest;
import com.nettyTest.pojo.Bean1;
import com.nettyTest.pojo.Bean2;
import com.nettyTest.util.PrintUtil;
import org.junit.Test;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Demo1Test {

    @Test
    public void testDemo2(){
        Bean1 bean1=new Bean1();
        BeanMap beanMap = BeanMap.create(bean1);
        Map<String,Object> objectMap=new HashMap<>();
        objectMap.put("s","sssss");
        objectMap.put("d",13);
        beanMap.putAll(objectMap);
        System.out.println(bean1);
    }
    @Test
    public void testDemo4(){
        final HashSet<Integer> collect = IntStream.range(0, 100)
                .collect((Supplier<HashSet<Integer>>) HashSet::new, HashSet::add, (AbstractCollection::addAll));
        System.out.println(collect);
    }

    @Test
    public void test13(){
        HashMap<Object, Object> map = new HashMap<>();
        final Object o = map.get(1);
        System.out.println(o);
    }
    @Test
    public void testDemo1(){
        int i=0;
        for (; i < 4; i++) {
            if(i==3){
                break;
            }
        }
        if(i<4){
            while (i>0){
                --i;
                System.out.println(i);
            }
        }
        System.out.println(i);
    }
    @Test
    public void testMap(){
        PrintUtil printUtil=new PrintUtil();
        BeanMap beanMap=BeanMap.create(printUtil);
        final Set<Object> set = beanMap.keySet();
        final Object collect = set.stream().collect(Collectors.toMap(key -> (String) key, beanMap::get));
    }
    @Test
    public void test5(){
        final AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(WebConfig.class);
    }
    @Test
    public void testEntity(){
        LinkedHashMap<String,String> linkedHashMap=new LinkedHashMap<String,String>(16,0.75f,true);
        linkedHashMap.put("2","2");
        linkedHashMap.put("3","3");
        linkedHashMap.put("1","1");
        List<String> collect = linkedHashMap.keySet().stream().collect(Collectors.toList());

        linkedHashMap.remove("2");
        System.out.println(linkedHashMap.get("2"));
        System.out.println(linkedHashMap);
        System.out.println(new ArrayList<>(linkedHashMap.values()));
//        List<String> demoList=new ArrayList<>();
//        demoList.add("1");
//        demoList.add("2");
//        demoList.add("3");
//        demoList.sort((demo1,demo2)->-demo1.compareTo(demo2));
//        demoList.add(3,"4");
//        System.out.println(demoList);
     }
    @Test
    public void testEntity1(){
        final List<Integer> l1 = Arrays.asList(4, 2, 3, 1);
        final List<Integer> l2 = Arrays.asList(4, 2, 3, 1);
        Stream.of(l1,l2).flatMap(list->list.stream());
    }
    @Test
    public void testDemo10(){
        switch (10){
            case 1:{
                System.out.println(1);
            }
            case 2:{
                System.out.println(2);
            }
            case 3:{
                System.out.println(3);
            }
            case 10:{
                System.out.println(10);
                break;
            }
        }
    }
}
