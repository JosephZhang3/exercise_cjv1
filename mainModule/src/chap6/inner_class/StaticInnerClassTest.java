package chap6.inner_class;

/**
 * 静态内部类
 * Created by Jianghao Zhang on 2017/5/31.
 */
public class StaticInnerClassTest {
    public static void main(String[] args) {
        double[] d = new double[20];
        for (int i = 0; i < d.length; i++) {
            d[i] = 100 * Math.random();
        }
        ArrayAlg.Pair p = ArrayAlg.calcMinAndMax(d);
        System.out.println("min value = " + p.getFirst());
        System.out.println("max value = " + p.getSecond());
    }
}

class ArrayAlg {
    /**
     * 计算一个由double基本类型构成的数组的最小值和最大值
     *
     * @param values 双精度浮点型数组
     * @return Pair对象，包装两个double型数字，第一个数字是最小值，第二个数字是最大值
     */
    public static Pair calcMinAndMax(double[] values) {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (double v : values) {
            if (min > v) {
                min = v;//赋值次数越多，min值越小
            }
            if (max < v) {
                max = v;//赋值次数越多，max值越大
            }
        }
        return new Pair(min, max);//内部类对象是在static方法中构造的，所以内部类必须被声明为static
    }

    public static class Pair {//公共静态内部类
        private double first;
        private double second;

        public Pair(double f, double s) {
            first = f;
            second = s;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }
    }
}
