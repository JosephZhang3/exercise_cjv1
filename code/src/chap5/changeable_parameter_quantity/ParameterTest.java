package chap5.changeable_parameter_quantity;

/**
 * 测试可变参数数量的方法
 * Created by Jianghao Zhang on 2017/5/13.
 */
public class ParameterTest {
    public static void main(String[] args) {
        System.out.println(max(3.1, 40.4, -6, 0));
    }

    //参数可以是任意类型，可以是基本类型，也可以是的
    public static double max(double... digits) {
        double largest = Double.MIN_VALUE;
        for (double x : digits) {
            if (x > largest) {
                largest = x;
            }
        }
        return largest;
    }
}
