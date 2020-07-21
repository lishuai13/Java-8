package exercise.chapter5;

import entity.Album;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Question2 {

    @Test
    public void test() {
        Album album1 = new Album("左轮手枪","曲目列表",5);
        Album album2 = new Album("麦克雷","曲目列表",2);
        Album album3 = new Album("维和者","曲目列表",3);
        List<Album> albums = Arrays.asList(album1,album2,album3);
        collection(albums);
        highFunction(albums);
    }

    @Test
    public void test2(){
        Stream<String> names = Stream.of("you", "you", "she", "she", "she", "he");
        Map<String, Long> map = countWords(names);
        for(String key : map.keySet()){
            System.out.println(key+"->"+map.get(key));
        }
    }

    //WordCount
    private static Map<String, Long> countWords(Stream<String> names) {
        return names.collect(groupingBy(name -> name, counting()));
    }

    //收集器方法实现找出名字最长的人
    private static void collection(List<Album> albums){
        Album album1 = albums.stream()
                .collect(maxBy(Comparator.comparing(album -> album.getName().length()))).get();
        System.out.println(album1);
    }

    //高阶函数实现找出名字最长的人
    private static void highFunction(List<Album> albums){
        Optional<Album> max = albums.stream().max(Comparator.comparing(album -> album.getName().length()));
        System.out.println(max);
    }
}
