package chap5.wrapper_and_autoboxing;

import java.util.ArrayList;

/**
 * 自动装箱测试
 * Created by Jianghao Zhang on 2017/5/12
 */
public class AutoboxingTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        System.out.println(list.get(0));//auto wrapping（自动打包）,is equivalent to ----> list.add(Integer.valueOf(3))

        int i = list.get(0);
        System.out.println(i);//auto unboxing（自动拆箱）,is equivalent to ----> list.get(i).intValue()

        Integer j = 4;
        j++;
        System.out.println(j);//在算术表达式中自动装箱和拆箱

        Integer a = 1000;
        Integer b = 1000;
        if (a == b) {
            System.out.println("a == b");//控制台并不会打印
        }
        Integer c = 100;
        Integer d = 100;
        if (c == d) {
            System.out.println("c == d");//控制台会打印，因为，自动装箱规范要求，boolean、byte、char<=127、介于-128~127之间的short和int
            // 被包装到固定的对象中，也就是说，100这个值会被包装到一个固定的对象中，c和d分别被初始化，但实际上引用的是同一个对象。
        }
    }
}
