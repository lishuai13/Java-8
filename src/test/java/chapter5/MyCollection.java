package chapter5;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 自定义收集器，拼接字符串
 */
public class MyCollection {

    @Test
    public void test(){
        List<String> list = Arrays.asList("1","2","3","4","5","6","7");

        StringBuilder strBuffer = new StringBuilder("[");
        for(String str: list){
            if(strBuffer.length() > 1){
                strBuffer.append("_");
            }
            strBuffer.append(str);
        }
        strBuffer.append("]");

        System.out.println(strBuffer.toString());
    }


    @Test
    public void test3(){
        List<String> list = Arrays.asList("1","2","3","4","5","6","7","8");

        StringBuffer strBuffers = list.stream()
                .reduce(new StringBuffer("["),
                        (arr, element) -> {
                            if(arr.length() > 1){
                                arr.append("_");
                            }
                            arr.append(element);
                            return arr;
                        },
                        (left, right) -> left.append(right)
                );
        strBuffers.append("]");

        System.out.println(strBuffers.toString());
    }
}

