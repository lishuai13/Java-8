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
        list.add(meatMenu);
        list.add(meatMenu);
        list.add(new Menu("chop", 0.08));
        return list;
    }

    //计数
    @Test
    public  void test1() {
        List<Menu> list = factory();
        //计算数量
        Long total = list.stream().map(m->m.getWeight()).collect(counting());
        //等同写法
        long total2 = list.stream().map(Menu::getWeight).count();
        System.out.println("===t1===" + total + ",===t2===" + total2);
    }


    //求最大值，最小值
    @Test
    public  void test2() {
        List<Menu> list = factory();
        //查找流中的最大值，maxBy参数为比较器
        Optional<Double> max = list.stream().map(m -> m.getWeight()).collect(maxBy((a,b)->{return a.compareTo(b);}));
        //等同写法
        Optional<Double> max2 = list.stream().map(m -> m.getWeight()).collect(maxBy(Comparator.comparing(a->a)));
        //等同写法
        Optional<Double> max3 = list.stream().map(Menu::getWeight).collect(maxBy(Double::compareTo));
        //等同写法
        Optional<Double> max4 = list.stream().map(Menu::getWeight).max(Double::compareTo);
        //等同写法
        Optional<Double> max5 = list.stream().map(Menu::getWeight).reduce(Double::max);
        //这是reduce独有的，maxBy不存在初始值
        Double max6 = list.stream().map(Menu::getWeight).reduce(0D, Double::max);


        //查找流中的最小值
        Optional<Double> min = list.stream().map(Menu::getWeight).collect(minBy(Double::compare));
        //等同写法
        Optional<Double> min2 = list.stream().map(Menu::getWeight).reduce(Double::min);
        //这是reduce独有的，minBy不存在初始值
        Double min3 = list.stream().map(Menu::getWeight).reduce(1D, Double::min);

        System.out.println("===max==="+max+",===max2==="+max2+",===max3==="+max3+",===max4==="+max4+",===max5==="+max5);
        System.out.println("===min==="+min+",===min2==="+min2+",===min3==="+min3);

    }

    //求和，平均值
    @Test
    public  void test3() {
        List<Menu> list = factory();
        //求和
        Double doubleSum = list.stream().map(Menu::getWeight).collect(summingDouble(s->s));
        //等同写法
        Double doubleSum2 = list.stream().mapToDouble(Menu::getWeight).sum();
        //等同写法
        Double doubleSum3 = list.stream().collect(summingDouble(Menu::getWeight));
        //求平均数
        Double averageWeight = list.stream().collect(averagingDouble(Menu::getWeight));
        System.out.println("===doubleSum===" + doubleSum + ",===averageWeight===" + averageWeight);
        //将汇总操作放在一个收集器进行
        DoubleSummaryStatistics doubleSummaryStatistics = list.stream().collect(summarizingDouble(Menu::getWeight));
        System.out.println(doubleSummaryStatistics.toString());

    }

    //连接字符串
    @Test
    public  void test4() {
        List<Menu> list = factory();
        //连接字符串
        String printStr = list.stream().map(Menu::getName).collect(joining(","));
        System.out.println("打印结果:"+printStr);
    }

    //reducing
    @Test
    public  void test5() {
        List<Menu> list = factory();
        //reducing
        double sum = list.stream().collect(reducing(0d, Menu::getWeight, Double::sum));
        System.out.println("===sum===" + sum);
        //相同效果
        Double sum1 = list.stream().mapToDouble(Menu::getWeight).sum();
        System.out.println("===sum1===" + sum1);

    }

    //分类，条件判断
    @Test
    public  void test6() {
        List<Menu> list = factory();
        //按体重是否大于2进行分组，
        Map<Boolean, List<Menu>> map = list.stream().collect(partitioningBy(menu -> menu.getWeight() > 2));
        System.out.println(map);

    }

    //分组，按属型相同的分为一组
    @Test
    public  void test7() {
        List<Menu> list = factory();
        //按name分类
        Map<String, List<Menu>> listMap = list.stream().collect(groupingBy(Menu::getName));
        System.out.println(listMap);
    }
}

