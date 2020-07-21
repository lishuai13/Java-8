package chapter2.demo3;

import org.junit.Test;

import java.util.function.Consumer;

public class test {

    private String name;

    @Test
    public  void test() {
        //final变量
        final String  str = "xxx";
        //即成事实的final变量，赋值一次
        String str1 = "yyy";
        //赋值两次
        String str2 = "zz";
        str2 = "zzz";
        Consumer<String> consumer = (s)->{
            name=s;
        };
        consumer.accept("aaa");
    }
}
