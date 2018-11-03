package chap13.collection.view_and_wrapper;

import java.util.HashSet;
import java.util.Set;

/**
 * 把集合类对象转换为数组
 */
public class TransformCollection2Array {
    public static void main(String[] args) {
        Set<String> strSet = new HashSet<>();
        strSet.add("Fred");
        strSet.add("Gary");
        strSet.add("Kristin");
        strSet.add("Paul");

//        String[] strArray = (String[]) strSet.toArray();//toArray()方法返回Object[]对象数组，对象数组不能被强制转化为字符串数组，不能把抽象的转化成具体的，报错：cannot be cast to [Ljava.lang.String;

        String[] strArray = strSet.toArray(new String[0]);
        for (String str : strArray) {
            System.out.println(str);
        }
    }
}
