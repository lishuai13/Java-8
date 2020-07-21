package chapter2.demo2;

import org.junit.Test;

/**
 * lambda表达式的简化操作
 */

public class AddLambda {

    //原始状态
    @Test
    public void test1() {

        Add a1 = (int a,int b)->{
            int result = a+b;
            System.out.println("add："+result);
            return result;
        };
        a1.add(1,2);
    }

    //省略参数类型，若有多个参数，需要同时加上或同时去掉参数
    @Test
    public void test2() {

        Add a1 = (a,b)->{
            int result = a+b;
            System.out.println("add："+result);
            return result;
        };
        a1.add(1, 2);
    }

    //一个参数的情况下，可以去点小括号，多个参数时，不可以
    //当执行的语句只有一条时，可以去掉花括号

    @Test
    public void test4() {
        //这里的a1指的是这个方法
        Add a1 = (a,b)->a+b;
        //这里的a2指的是这个方法
        Add a2 = (a,b)->a-b;
        //调用这两个方法
        int add = a1.add(1, 2);
        int add2 = a2.add(1, 2);
        System.out.println(add+","+add2);
    }
}
