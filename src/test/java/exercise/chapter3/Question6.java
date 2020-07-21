package exercise.chapter3;

/**
 * 获取小写字母个数
 */
public class Question6 {

        public static long countStringLowercaseLetters(String string){
            return string.chars()//获得字母流
                    .filter(c->c>=97 && c<=122)//筛选出所有小写字母
                    .count();//统计数量
        }

    public static void main(String[] args) {
        String s = "AFAfasdfsafewD";
        long l = countStringLowercaseLetters(s);
        System.out.println(l);
    }
}
