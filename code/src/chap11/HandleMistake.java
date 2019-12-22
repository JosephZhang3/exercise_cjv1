package chap11;

/**
 * 异常处理的任务是什么？
 * 将控制权从错误产生的地方转移给能够处理这种情况的错误处理器。
 * 错误类型：
 * 1.用户输入错误，不赘述
 * 2.设备错误，比如打印机在打印过程中纸卡住了
 * 3.物理限制，比如硬盘满了没有剩余存储空间了
 * 4.代码错误，情况非常多
 *
 * Java在发生异常且未捕获的情况下是不会返回任何值的，如果没有Exception Handler处理这个异常，线程会立即结束。这点要脑袋里记清楚！
 *
 * 什么叫做 未检查异常 ？
 * Java把派生于Error类或者RuntimeException类的所有异常称为 未检查异常，其他的都视为已检查异常。
 * 编译器不关心未检查异常（比如 NPE，ArrayIndexOutOfBounds 空指针异常、数组索引越界异常等等，因为这些都是程序员自己该控制的问题）
 *
 * 什么时候需要throws异常，什么异常需要throws？
 * 1.调用一个抛出已检查异常的方法，例如调用FileInputStream类的构造器（这个构造器会抛出FileNotFoundException）
 * 2.程序运行过程中发现逻辑错误，例如在计算利息的中间步骤，发现成了负数，这时就要终止计算并且throw出一个自定义的业务异常（已检查异常）
 * 3.for循环时越界访问不存在的数组位置，例如 arr[-1] ，这时会抛出一个对此的未检查异常
 * 4.JVM和运行时库出现的内部错误
 *
 * 如果出现1或者2这两种情况，一定要通知调用方可能抛出异常，因为这两种情况是明显可预见的。
 * 而后两种情况，除非遇到非常奇葩的输入或者程序代码被手滑改错了，一般是不会出现的。即使出现了，也无能为力，因为想不到处理措施。所以不需要
 * 在方法签名中throws。
 *
 *
 */
public class HandleMistake {

    /**
     * IDEA live templates tips：输入psvm直接补全完整的main方法，输入fori或者foreach abbreviation 补全完整循环结构
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

            System.out.println("val of i is"+i);
        }
        try {
            Class Obj = Class.forName("chap11.NONexist");
            assert Obj.isArray() == false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
