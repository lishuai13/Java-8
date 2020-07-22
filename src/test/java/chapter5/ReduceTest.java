package chapter5;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * reduce函数测试
 */
public class ReduceTest {

    //单个参数accumulator告诉reduce方法怎么去累计stream中的数据。
    //可能为空，所以返回Optional
    @Test
    public void test() {
        List<String> list = Arrays.asList("1", "2", "2");
        Optional<String> result1 = list.stream().reduce((a, b) -> a + "->" + b);
        result1.ifPresent(System.out::println);
    }

    //两个参数，第一个是初始值，不会为空，不返回Optional
    //问题并行计算
    @Test
    public void test2() {
        List<String> list = Arrays.asList("1", "2", "2");
        Optional<String> result1 = Optional.ofNullable(list.parallelStream().reduce("haa", (a, b) -> a + "->" + b));
        result1.ifPresent(System.out::println);
    }

    //三个参数,第三个参数用于并行时的数据的归一,将首数字与后面的数字做第二个参数的计算，再将所有并行的结果做第三个参数的运算
    @Test
    public void test3() {
        List<String> list = Arrays.asList("1", "2", "2");
        Optional<String> result1 = Optional.ofNullable(list.parallelStream().reduce("haa", ((a, b) -> a + "->" + b), ((a, b) -> a + "==" + b)));
        result1.ifPresent(System.out::println);
    }


    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3);
        Optional<Integer> result1 = intList.stream().reduce(Integer::sum);
        System.out.println(result1);

        Integer result2 = intList.stream().reduce(100, Integer::sum);
        System.out.println(result2);

        Integer result3 = intList.parallelStream().reduce(100, Integer::sum);
        System.out.println(result3);

        Integer result4 = intList.stream().reduce(100, Integer::sum, Integer::sum);
        System.out.println(result4);

        Integer result5 = intList.parallelStream().reduce(10,(a,b)->a*b,(a1,b1)->a1+b1);
        System.out.println(result5);

    }

    @Test
    public void test4(){
        List<Integer> num = Arrays.asList(1, 2, 3);
        Integer num1 = num.parallelStream().reduce(10, (x, y) -> x * y
//                , (x, y)->{
//            System.out.println("这里调用一次");
//            return x + y; }
            );
        System.out.println(num1);
    }
}