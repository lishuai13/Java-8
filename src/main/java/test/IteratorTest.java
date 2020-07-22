package test;

import java.util.*;

public class IteratorTest {

    public static void main(String[] args) {
        Map<String,String>map = new HashMap<>();
        map.put("ss","ee");
        map.put("ww","qq");
        map.put("xx","zz");

        //先将map转化为entrySet再生成迭代器哦
        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();//返回所有的entry实体
        while (iterator.hasNext()) {
            Map.Entry<String, String> next1 = iterator.next();
            String key = next1.getKey();
            String value = next1.getValue();
            System.out.println(key+" "+value);
        }

        //通过键来遍历,定义泛型无需类型转换
        Iterator<String>  iterator1 = map.keySet().iterator();
        while (iterator1.hasNext()) {
            String s = iterator1.next() ;
            System.out.println(s);
        }
        //不定义泛型需要类型转换
        Iterator iterator2 = map.values().iterator();
        while (iterator2.hasNext()) {
            String s = (String)iterator2.next() ;
            System.out.println(s);
        }


        //for循环遍历
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        //java 8 forEach遍历
        map.forEach((k,v)->{
            System.out.println(k+v);
        });
    }
}
