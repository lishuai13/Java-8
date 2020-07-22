package chapter5;

import entity.City;
import entity.Person;

import java.util.*;
import java.util.function.BinaryOperator;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

/**
 * 使用reducing自定义收集器
 */
public class  ReducingDemo {


    public static void main(String[] args) {
        //创建1000000个人
        List<Person> personList = getPersonList(1000000);
        //找出最高的身高
        functionStyle(personList);
    }

    private static void functionStyle(List<Person> personList) {
        long start = System.currentTimeMillis();

        Map<City, Optional<Person>> tallestByCity = personList.stream().
                collect(groupingBy(Person::getCity, reducing(BinaryOperator.maxBy(Comparator.comparingInt(Person::getHeight)))));
        long usedTime = System.currentTimeMillis() - start;
        tallestByCity.forEach((city, person) -> {
            person.ifPresent(p -> System.out.println(city.getName() + " -> " + p.getHeight()));
        });
    }


    private static List<Person> getPersonList(int numbers) {
        // 创建城市
        final City cityChengDu = new City("成都");
        final City cityNewYork = new City("纽约");
        List<Person> people = new ArrayList<>();
        // 创建指定数量的Person，并指定不同的城市和相对固定的身高值
        for (int i = 0; i < numbers; i++) {
            if (i % 2 == 0) {
                // 成都最大身高185
                people.add(new Person(cityChengDu, 185));
            } else if (i % 3 == 0) {
                people.add(new Person(cityChengDu, 170));
            } else if (i % 5 == 0) {
                // 成都最小身高160
                people.add(new Person(cityChengDu, 160));
            } else if (i % 7 == 0) {
                // 纽约最大身高200
                people.add(new Person(cityNewYork, 200));
            } else if (i % 9 == 0) {
                people.add(new Person(cityNewYork, 185));
            } else if (i % 11 == 0) {
                // 纽约最小身高165
                people.add(new Person(cityNewYork, 165));
            } else {
                // 默认添加纽约最小身高165
                people.add(new Person(cityNewYork, 165));
            }
        }
        return people;
    }
}

