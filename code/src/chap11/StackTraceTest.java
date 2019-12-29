package chap11;

public class StackTraceTest {

    private static int factorial(int n) {
        System.out.println("factorial(" + n + "" + ").");
        Throwable t = new Throwable();
        StackTraceElement[] frames = t.getStackTrace();
        for (StackTraceElement frame : frames) {
            System.out.print("堆栈中的一帧:");
            System.out.println(frame);
        }
        int r;
        if (n <= 1) {
            r = 1;
        } else {
            r = n * factorial(n - 1);
        }
        System.out.println("return " + r);
        return r;
    }

    public static void main(String[] args) {
        factorial(5);
    }
}
