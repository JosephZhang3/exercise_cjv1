package chap11.log;

import java.util.logging.Logger;

public class SimpleLoggerTest {

    private static final Logger myLogger = Logger.getLogger("chap11.log.SimpleLoggerTest");

    public static void main(String[] args) {
//        Logger.getGlobal().setLevel(Level.INFO);//actually INFO is the jre default level
//        Logger.getGlobal().info("we called logger once");

        int returnInt = demoMethod("p1", "p2");
        System.out.println(returnInt);
    }

    /**
     * 只有把日志级别设定成 FINER 才能正常调用entering()和exiting()方法
     * 如何设定？
     * 修改JDK安装路径下的 jre/lib/logging.properties 文件，
     * 把 .level= INFO 这一行
     * 替换成 chap11.log.SimpleLoggerTest.level= FINER
     * 再把 java.util.logging.ConsoleHandler.level = INFO 这一行
     * 替换成 java.util.logging.ConsoleHandler.level = FINER
     * 就一切OK了
     *
     * @param param1 第一个参数
     * @param param2 第二个参数
     * @return 整型值
     */
    private static int demoMethod(String param1, String param2) {
        myLogger.entering("chap11.log.SimpleLoggerTest", "demoMethod", new Object[]{param1, param2});
        myLogger.info("By default, We can use INFO level to output log record.");
        System.out.println("do sth...");
        System.out.println("do sth twice...");
        myLogger.exiting("chap11.log.SimpleLoggerTest", "demoMethod", 5);
        return 5;
    }
}
