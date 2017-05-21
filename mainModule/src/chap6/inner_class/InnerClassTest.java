package chap6.inner_class;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * 内部类
 * Created by Jianghao Zhang on 2017/5/16.
 */
public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(10000, true);
        clock.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

class TalkingClock {
    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        //实际上编译器处理过程中将对外部类的对象的引用传递给了内部类的构造器
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }

    private class TimePrinter implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Date now = new Date();
            System.out.println("At the tone,the time is " + now);
            //内部类对象可以直接访问外部类对象的私有域，语句被编译后实际上类似  if(talkingClock.beep)
            if (beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}