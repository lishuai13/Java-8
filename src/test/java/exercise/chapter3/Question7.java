package exercise.chapter3;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 找出小写字母个数最多的字符串
 */
public class Question7 {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        for(int i=1;i<10;i++){
            StringBuilder sb=new StringBuilder();
            sb.append("d".repeat(i + 1));
            list.add(sb.toString());
        }
        String max=list.stream().max(Comparator.comparing(s ->getCount(s) )).get();
        System.out.println(max);
    }

    private static long getCount(String str){
        return str.chars().filter(c->c>=97 && c<=122).count();
    }
}
