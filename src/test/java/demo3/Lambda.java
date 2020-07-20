package demo3;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 四种函数式接口
 */
public class Lambda {
    //功能性接口，有参数，有返回值
    @Test
    public void test(){
        //匿名内部类
        Function function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        };
        //lambda
        Function<String,Integer> function2 = (String s)->{
            return Integer.parseInt(s);
        };
        Integer apply = function2.apply("123");
        System.out.println(apply);
    }

    //断定型接口，有参数，返回值为布尔值
    @Test
    public void test2(){
        //匿名内部类
        Predicate predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };
        //lambda形式
        Predicate<String> predicate2 = (String s)->{
            return s.isEmpty();
        };
        boolean test = predicate2.test("123");
        System.out.println(test);
    }

    //供给型接口，没有参数只有返回值
    @Test
    public void test3(){
        //匿名内部类
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "供给型接口，没有参数只有返回值";
            }
        };
        //lambda形式
        Supplier<String> supplier2 = ()->{
            return "供给型接口，没有参数只有返回值";
        };
        String s = supplier2.get();
        System.out.println(s);
    }

    //消费性接口，只有参数没有返回值
    @Test
    public void test4(){
        //匿名内部类
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        //lambda形式
        Consumer<String> consumer2 = (String s)->{
            System.out.println(s);
        };
        consumer2.accept("消费性接口只有参数，没有返回值");
    }
}
