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
    public static Pair calcMinAndMax(double[] values) {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (double v : values) {
            if (min > v) {
                min = v;
            }
            if (max < v) {
                max = v;
            }
        }
        return new Pair(min, max);
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
