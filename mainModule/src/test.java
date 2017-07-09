import java.time.Clock;

/**
 * Created by Administrator on 2016/11/30.
 * just for test.
 * Project git root path:
 * 笔记本      /c/Users/Jianghao Zhang/IdeaProjects/exercise_cjv1  （空格不会被shell识别，这个坑...）
 */
public class test {
    public static void main(String[] args) {
        System.out.println("test class can be use!");

/*
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


        a:
        //倒数循环，从10到0
        for (int m = 10; m >= 0; m--) {
            System.out.println("outer m is:" + m);
            for (int n = 0; n <= 10; n++) {//正数循环，从0到10
                System.out.println("inner n is:" + n);
                if (m == n) {
                    continue;
                }
                System.out.println("m != n");
                break a;
            }
        }

        //递归实现字符串翻转

        System.out.println(Clock.systemDefaultZone().millis());

        System.out.println(
                "hello".length()
        );
*/

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
}
