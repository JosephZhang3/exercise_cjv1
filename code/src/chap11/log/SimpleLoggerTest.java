package chap11.log;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleLoggerTest {

    public static final Logger myLogger = Logger.getLogger("chap11.log.SimpleLoggerTest");

    public static void main(String[] args) {
        myLogger.entering("chap11.log","");
        Logger.getGlobal().setLevel(Level.ALL);
        Logger.getGlobal().fine("we called logger once");
        Logger.getGlobal().info("we called logger once");

    }

    private static int me(){

        return -1;
    }
}
