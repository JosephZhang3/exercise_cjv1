package chap3;

public class RecursiveTest {

    public static void main(String[] args) {
        printOut(76534);
    }

    public static void printOut(int n) {
        if (n >= 10)
            //通过递归，得到基准情况的输出（printOut(7)）,然后一级一级地调用基准情况的结果
            printOut(n / 10);
        System.out.print(n % 10);
    }

}
