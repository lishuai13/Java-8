package demo4;

import entity.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * stream流式计算
 */
public class stream {

    public static void main(String[] args) {
        User u1 = new User(1,"a",25);
        User u2 = new User(2,"b",22);
        User u3 = new User(3,"c",21);
        User u4 = new User(4,"d",30);
        User u5 = new User(5,"e",18);

        List<User> list = Arrays.asList(u1,u2,u3,u4,u5);

        //将集合转换为stream对象，stream中的方法参数大多是函数式接口，可使用lambda简化
        //分析参考note.md
        list.stream().filter((User u)->{return u.getAge()>21;})
                .map((User u)->{return u.getName().toUpperCase();})
                .sorted((String name1,String name2)->{return name2.compareTo(name1);})
                .forEach((String s)->{
                });

        //简化版本
        list.stream().filter((u)-> u.getAge()>21)
                .map((u)-> u.getName().toUpperCase())
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

    }
}
