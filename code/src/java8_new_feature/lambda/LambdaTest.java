package java8_new_feature.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 闭包测试，将行为传递到函数里
 * Created by Jianghao Zhang on 2017/6/1.
 */
public class LambdaTest {
    public static void main(String[] args) {
        //使用lambda表达式替换runnable匿名类
        new Thread(() -> System.out.println("--")).start();

        //简化集合迭代
        List<String> features = Arrays.asList("lambda", "stream api", "date and time api");
        features.forEach(System.out::println);//这里使用了方法引用（method reference caller object 方法引用调用它的主调对象），双冒号操作符

        //函数式接口，将函数作为参数传递
        List<String> languages = Arrays.asList("C", "C++", "C#", "Java", "JavaScript", "python");
        System.out.print("打印以c开头的语言名");
        filter(languages, (String str) -> str.startsWith("C"));
        System.out.println();
        System.out.print("打印所有的语言名");
        filter(languages, (str) -> true);


    }

    private static void filter(List<String> names, Predicate<String> conditionFunc) {
        names.stream().filter((name) -> (conditionFunc.test(name))).forEach((name) ->
                System.out.print(name + " ")
        );
    }
}
