package chap13.collection.set;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Use a set ADT to print all unique words from System.in
 * 使用一种抽象数据结构set来打印出来自系统输入流的所有唯一的（不重复的）字符串，注意是无序的
 * 可以把set理解成无序且不包含重复元素的list，当然了，它还没有索引
 */
public class HashSetTest {
    public static void main(String[] args) {
        Set<String> words = new HashSet<>();
        long totalTime = 0;

        Scanner in = new Scanner(System.in);
        while (!in.hasNext("eof")) {//遇到输入字符串为eof时，结束监听控制台的输入
            String word = in.next();
            System.out.println("控制台输入的字符串为->" + word);
            long callTime = System.nanoTime();
            words.add(word);
            callTime = System.nanoTime() - callTime;
            totalTime += callTime;
        }

        for (String word : words) {
            System.out.println(word);
        }

        System.out.println("......");
        System.out.println(words.size() + " distinct words are stored in " + totalTime + " milliseconds.");
    }
}