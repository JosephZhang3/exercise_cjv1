package chap4;

/**
 * @author JianghaoZhang
 * @date 3/13/2017
 * This program demonstrates parameter passing in Java.
 */
public class ParamTest {
    public static void main(String[] args) {
        /**
         * Test1:method can't modify primitive type parameters.
         */
        System.out.println("Testing tripleValue:");
        double percent = 10;
        System.out.println("Before execute method:percent=" + percent);
        tripleValue(percent);
        System.out.println("After execute method:percent=" + percent);
    }

    public static void tripleValue(double x) {
        x = 3 * x;
        System.out.println("End of method: x=" + x);
    }

}
