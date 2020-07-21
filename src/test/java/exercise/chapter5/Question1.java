package exercise.chapter5;

import entity.Menu;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 */
public class Question1 {

    private static List<Menu> factory() {
        Menu meatMenu = new Menu("meat", 8.88);
        List<Menu> list = new ArrayList<>();
        list.add(new Menu("fish", 1.98));
        list.add(new Menu("apple", 0.88));
        list.add(new Menu("beaf", 2.18));
        list.add(meatMenu);
        list.add(meatMenu);
        list.add(new Menu("chop", 0.08));
        return list;
    }

    //转换大写
    @Test
    public  void test1() {
        List<Menu> list = factory();
        //计算数量
        String str = "aaa";
        Stream.of(str).map(String::toUpperCase).forEach(System.out::println);
    }

    //reduce实现count方法
    @Test
    public  void test2() {
        //计算数量
        Integer[] a = {1,2,3,4};
        Integer integer = Stream.of(a).map(s -> 1).reduce(Integer::sum).get();
        System.out.println(integer);
    }

    //使用flatMap连接列表
    @Test
    public  void test3() {
        List<Integer> list = Stream.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(8, 9, 10, 11, 12))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }







}

