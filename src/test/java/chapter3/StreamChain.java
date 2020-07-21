package chapter3;

import entity.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * stream流式计算整合
 * 将复杂问题分解为一个个小问题的连接，然后使用链式编程实现一个个小问题
 */
public class StreamChain {

    //stream引入：将年龄大于21岁的人的名字转大写并倒叙输出
    @Test
    public  void test() {
        User u1 = new User(1,"a",25);
        User u2 = new User(2,"b",22);
        User u3 = new User(3,"c",21);
        User u4 = new User(4,"d",30);
        User u5 = new User(5,"e",18);

        List<User> list = Arrays.asList(u1,u2,u3,u4,u5);

        //链式编程
        //将集合转换为stream对象，stream中的方法参数大多是函数式接口，可使用lambda简化
        //分析参考note.md
        list.stream().filter((User u)->{return u.getAge()>21;})
                .map((User u)->{return u.getName().toUpperCase();})
                .sorted((String name1,String name2)->{return name2.compareTo(name1);})
                .forEach((String s)->{ System.out.println(s); });

        //简化版本
        list.stream().filter(u-> u.getAge()>21)
                .map(u-> u.getName().toUpperCase())
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

    }

    //惰性求值方法与及早求值方法
    @Test
    public  void test2() {
        User u1 = new User(1,"a",25);
        User u2 = new User(2,"b",22);
        User u3 = new User(3,"c",21);
        User u4 = new User(4,"d",30);
        User u5 = new User(5,"e",18);

        List<User> list = Arrays.asList(u1,u2,u3,u4,u5);
        //这里什么也不会输出，因为filter是一个惰性求值方法，他只是描述stream，并没有产生新的集合
        list.stream().filter(user -> {
            System.out.println(user.toString());
            return user.getAge()>20; })
                //加上count就能有输出，因为count会从stream中产生值，是及早求值方法
                .count();
    }

}
