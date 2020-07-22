package chapter3;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 常用的流操作
 */
public class StreamMethods {
    //collect(toList())终止操作：由Stream中的值生成一个List列表，Set也可
    @Test
    public void collectToList() {
        String[] testStrings = { "java", "react", "angular", "vue" };

        List<String> list = Stream.of(testStrings)
                .collect(Collectors.toList());

        for (String s : list) {
            System.out.println(s);
        }
    }
    //map中间操作,Function函数式接口
    @Test
    public void mapTest() {
        String[] testStrings = { "java", "react", "angular", "vue" };

        List<String> list = Stream.of(testStrings)
                .map(test -> test.toUpperCase())
                .collect(Collectors.toList());

        for (String s : list) {
            System.out.println(s);
        }
    }

    //filter中间操作：遍历并筛选出满足条件的元素形成一个新的 stream 流。Predicate型
    @Test
    public void filterTest() {
        List<String> list = Arrays.asList("java", "react", "angular", "javascript", "vue");

        long count = list.stream().filter(p -> p.startsWith("j")).count();
        System.out.println(count);
    }

    //flatMap中间操作，可用Stream替换值，并将多个Stream流合并成一个Stream流。
    @Test
    public void flapMapTest() {
        List<Integer> list = Stream.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(8, 9, 10, 11, 12))
                .flatMap(test -> test.stream())
                .collect(Collectors.toList());

        for (Integer integer : list) {
            System.out.println(integer);
        }

    }
    //max 、min 终止操作，求Stream中的最大值、最小值。
    @Test
    public void maxTest() {
        String[] testStrings = { "java", "react", "angular", "javascript", "vue" };

        String max = Stream.of(testStrings).max(Comparator.comparing(String::length))
                .get();
        System.out.println(max);
    }

    //上述中的count，max，min都是reduce操作
    //reduce 终止操作，从 stream 的一组值中生成另一个值。
    //reduce方法的第一个参数值 0 是初始值，第二个lambda表达式参数
    // (accumulator, element) -> accumulator + element 是执行求和操作
    // 其中 accumulator 是累加器，element 是每次迭代的当前元素数值。
    @Test
    public void reduceSumTest() {
        int sum = Stream.of(5, 6, 7, 8).reduce(0, (accumulator, element) -> accumulator + element);

        System.out.println(sum);
    }
}
