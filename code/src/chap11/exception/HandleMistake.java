package chap11.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 异常处理的任务是什么？
 * 将控制权从错误产生的地方转移给能够处理这种情况的错误处理器。
 * 错误类型：
 * 1.用户输入错误，不赘述
 * 2.设备错误，比如打印机在打印过程中纸卡住了
 * 3.物理限制，比如硬盘满了没有剩余存储空间了
 * 4.代码错误，情况非常多
 * <p>
 * Java在发生异常且未捕获的情况下是不会返回任何值的，如果没有Exception Handler处理这个异常，线程会立即结束。这点要脑袋里记清楚！
 * <p>
 * 未检查异常 和 已检查异常的区别？
 * Java把派生于Error类或者RuntimeException类的所有异常称为 未检查异常，其他的都视为已检查异常。
 * 编译器不关心未检查异常（例如硬件错误，再例如 NPE，ArrayIndexOutOfBounds 空指针异常、数组索引越界异常等等，因为这些都是程序员自己该控制和想办法避免的问题）
 * <p>
 * 什么时候需要throws异常，什么异常需要throws？
 * 1.调用一个抛出已检查异常的方法，例如调用FileInputStream类的构造器（这个构造器会抛出FileNotFoundException）
 * 2.程序运行过程中发现逻辑错误，例如在计算利息的中间步骤，发现成了负数，这时就要终止计算并且throw出一个自定义的业务异常（已检查异常）
 * 3.for循环时越界访问不存在的数组位置，例如 arr[-1] ，这时会抛出一个对此的未检查异常
 * 4.JVM和运行时库出现的内部错误
 * <p>
 * 如果出现1或者2这两种情况，一定要通知调用方可能抛出异常，因为这两种情况是明显可预见的。
 * 而后两种情况，除非遇到非常奇葩的输入或者程序代码被手滑改错了，一般是不会出现的。即使出现了，也无能为力，因为想不到处理措施。所以不需要
 * 在方法签名中throws。
 * <p>
 * <p>
 * 如果finally语句中在关闭资源时发生了错误异常，那么资源就无法关闭。怎么避免这种情况？
 * 首先，这种情况下，原始的try块中的异常（如果有）会丢失，实际最后抛出的是finally块中的异常。
 * 解决方案：使用带资源的try语句，即使关闭资源的close方法抛出异常，这个异常会“被抑制”然后被自动捕获，不会覆盖try块中异常导致其丢失。
 */
public class HandleMistake {

    /**
     * IDEA live templates tips：输入psvm直接补全完整的main方法，输入fori或者foreach abbreviation 补全完整循环结构
     */
    public static void main(String[] args) {
//        errorInFinally();
        System.out.println(casesOfReturn());

        try {
            handleCloseResource();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * mock 如果在finally块中出现异常会发生什么？finally块会失效，线程会终止，资源不会被释放
     */
    public static void errorInFinally() {
        try {
            Class Obj = Class.forName("chap11.exception.NonExist");
            assert !Obj.isArray();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
//           int i = 3/0;
            System.out.println("执行了finally中的释放资源语句");
        }
    }

    /**
     * mock 如果在finally块中写return语句，会覆盖try中return的值
     */
    private static String casesOfReturn() {
        try {
            System.out.println("执行了try中的业务语句");
            return "try的返回值";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("执行了finally中的释放资源语句");
            return "finally的返回值";
        }
    }

    /**
     * 带资源的try语句，自动关闭资源，要求资源类实现AutoCloseable接口
     *
     * @throws FileNotFoundException 异常
     */
    private static void handleCloseResource() throws FileNotFoundException {
        try (Scanner in = new Scanner(new FileInputStream("C:/words.txt"));
             PrintWriter out = new PrintWriter("out.txt")
        ) {
            while (in.hasNext())
                out.println(in.next());
        }
    }
}
