package chapter5;

import entity.Menu;
import org.junit.Test;

import java.util.*;

import static java.util.stream.Collectors.*;
/**
 * 常见收集器方法
 */
public class App {

    private static List<Menu> factory() {
        Menu meatMenu = new Menu("meat", 8.88);
        List<Menu> list = new ArrayList<>();
        list.add(new Menu("fish", 1.98));
        list.add(new Menu("apple", 0.88));
        list.add(new Menu("beaf", 2.18));
        list.add(new Menu("meat", 8.88));
        list.add(new Menu("meat", 7.88));
        list.add(new Menu("chop", 0.08));
        return list;
    }

    //计数
    @Test
    public  void test1() {
        List<Menu> list = factory();
        //计算数量
        Long collect = list.stream().collect(counting());
        //等同写法
        Long collect2 = list.stream().count();
        System.out.println(collect);
    }


    //求最大值，最小值
    @Test
    public  void test2() {
        List<Menu> list = factory();

        Optional<Menu> max = list.stream().max(Comparator.comparing((Menu::getWeight)));
        max.ifPresent(System.out::println);

        Optional<Double> collect = list.stream().map(Menu::getWeight).collect(maxBy((a, b) -> {
            return a.compareTo(b);
        }));

        Optional<Double> collect1 = list.stream().map(Menu::getWeight).collect(minBy((a, b) -> {
            return a.compareTo(b);
        }));

        collect.ifPresent(System.out::println);
        collect1.ifPresent(System.out::println);
    }

    //求和，平均值
    @Test
    public  void test3() {
        List<Menu> list = factory();
        Double collect = list.stream().collect(summingDouble(Menu::getWeight));
        Double collect1 = list.stream().collect(averagingDouble(Menu::getWeight));
        Double collect3 = list.stream().map(Menu::getWeight).collect(summingDouble(s->s));
        System.out.println(collect+"-"+collect1+"-"+collect3);
        //将汇总操作放在一个收集器进行
        DoubleSummaryStatistics doubleSummaryStatistics = list.stream().collect(summarizingDouble(Menu::getWeight));
        System.out.println(doubleSummaryStatistics.toString());
    }

    //连接字符串,三个参数分别是间隔符，开头，结尾
    @Test
    public  void test4() {
        List<Menu> list = factory();
        //连接字符串
        String printStr = list.stream().map(Menu::getName).collect(joining(",","me[","]"));
        System.out.println("打印结果:"+printStr);
    }

    //分类，条件判断，使用类似groupingBy，支持组合收集器
    @Test
    public  void test6() {
        List<Menu> list = factory();
        //按体重是否大于2进行分组计数，
        Map<Boolean, Long> collect = list.stream().collect(partitioningBy(((menu -> menu.getWeight() > 2)), counting()));
        collect.forEach((k,v)-> System.out.println(k+"-"+v));


    }

    //分组，按属型相同的分为一组
    @Test
    public  void test7() {
        List<Menu> list = factory();
        //按name分类
        Map<String, List<Menu>> listMap = list.stream().collect(groupingBy(Menu::getName));
        //组合操作,2个:先使用上游收集器，再对结果使用下游收集器
        Map<String, Long> collect = list.stream().collect(groupingBy((Menu::getName), counting()));
        //组合操作,3个:先使用上游收集器，再对结果使用下游收集器,然后是中间收集器定型
        TreeMap<String, Optional<Menu>> collect1 = list.stream().collect(groupingBy((Menu::getName), TreeMap::new, maxBy((u1, u2) -> {
            return Double.compare(u1.getWeight(), u2.getWeight());
        })));
        listMap.forEach((k,v)-> System.out.println(k+"-"+v));
        collect.forEach((k,v)-> System.out.println(k+"-"+v));
        collect1.forEach((k,v)-> System.out.println(k+"-"+v));

    }

    //mapping,类似map，支持组合操作
    @Test
    public  void test8() {
        List<Menu> list = factory();
        String collect = list.stream().collect(mapping((Menu::getName), joining(",")));
        System.out.println(collect);

    }

    //toCollection
    @Test
    public  void test9() {
        List<Menu> list = factory();
        LinkedList<Menu> collect = list.stream().collect(toCollection(LinkedList::new));
        for (Menu menu : collect) {
            System.out.println(menu);
        }
    }

    //toMap
    @Test
    public  void test10() {
        List<Menu> list = factory();
        //指定键和值的映射函数
//        Map<String, String> collect = list.stream().collect(toMap(Menu::getName, Menu::toString));
//        collect.forEach((k,v)-> System.out.println(k+"-"+v));
        //第三个参数来约定冲突解决,传入的参数为重复的两个对象，返回的为保留的对象
        Map<String, String> collect1 = list.stream().collect(toMap(Menu::getName, Menu::toString,(s, a) -> a));
        collect1.forEach((k,v)-> System.out.println(k+"-"+v));
        //第四个参数用来提供另一个容器
        Map<String, String> collect2 = list.stream().collect(toMap(Menu::getName, Menu::toString,(s, a) -> a,TreeMap::new));
        collect2.forEach((k,v)-> System.out.println(k+"-"+v));
    }
}

