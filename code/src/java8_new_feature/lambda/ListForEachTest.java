package java8_new_feature.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ListForEachTest {
    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(10, 11, 12, 13, 14, 15, 16, 17, 18);
/*
        numList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("current iterate num is "+integer);
            }
        });
        */

        /*
        iterable接口的foreach方法是一个有具体实现的方法，接受一个<函数式接口>作为参数
        参见  java.lang.Iterable.forEach
        */
        numList.forEach(i -> {
            System.out.println("current iterate num is " + i);
        });
    }
}
