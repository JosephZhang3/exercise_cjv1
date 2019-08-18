package chap4;

/**
 * A <code>CommentTest</code> object represents how to <strong>annotate</strong> package,public class or interface,public or protected
 * constructor as well as method,public or protected field.<br>
 * This class is related to {@link chap4.EmployeeTest#main(String[])}.<br>
 * Just a nonsense toy program,don't trait it seriously.
 *
 * @author JianghaoZhang
 * @version 1.6
 * @since version 1.5
 */
public class CommentTest {
    /**
     * @param a 被减数
     * @param b 减数
     * @return 余数
     * @see chap4.Employee#raiseSalary(double)
     * @see <a href="http://www.cnblogs.com/zhangjianghao">home page of Author's blog</a>
     * @see "注释测试类"
     * @deprecated Use <code>newMinus()</code> instead.
     */
    public int minus(int a, int b) {
        return a - b;
    }
}
