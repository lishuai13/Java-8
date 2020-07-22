package exercise.chapter6;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Question1 {

    public static int sequentialSumOfSquares(IntStream range) {
        return range.parallel()
                .map(x -> x * x) .sum();
    }


    private static int multiplyThrough(List<Integer> linkedListOfNumbers) {
        return linkedListOfNumbers.parallelStream() .reduce(5, (acc, x) -> x * acc,(a,b)->a+b);
    }

    @Test
    public void test(){
        List<Integer> intList = Arrays.asList(1, 2, 3);
        int i = multiplyThrough(intList);
        System.out.println(i);
    }

    private int slowSumOfSquares(List<Integer> linkedListOfNumbers) {
        return linkedListOfNumbers.parallelStream() .mapToInt(x -> x * x) .reduce(0, (acc, x) -> acc + x);
    }

    @Test
    public void test2(){
        List<Integer> intList = Arrays.asList(1, 2, 3);
        int i = slowSumOfSquares(intList);
        System.out.println(i);
    }




}
