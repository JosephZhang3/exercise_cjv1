package java8_new_feature;

/**
 * Created by Administrator on 2016/11/30.
 * just for src.
 * Project git root path:
 * 笔记本      /c/Users/Jianghao Zhang/IdeaProjects/exercise_cjv1  （空格不会被shell识别，这个坑...）
 */
public class InternStringTest {
    public static void main(String[] args) {
/*
运行时常量池 字符串

        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern());
        System.out.println(s2);
        System.out.println(s2.intern() == s2);//false,why???

        String s1 = new StringBuilder("go").append("od").toString();
        System.out.println(s1.intern());
        System.out.println(s1);
        System.out.println(s1.intern() == s1);//true

        String s3 = new String("good");
        System.out.println(s3.intern());
        System.out.println(s3);
        System.out.println(s3.intern() == s3);//false


        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);//false
        System.out.println(s1 == s5);//true
        System.out.println(s1 == s6);//true
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());
    }
 */
    }
}