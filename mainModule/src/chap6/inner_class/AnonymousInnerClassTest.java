package chap6.inner_class;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * 匿名内部类
 * Created by Jianghao Zhang on 2017/5/30.
 */
public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        TalkingClock2 clock = new TalkingClock2();
        clock.start(1000, true);

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

class TalkingClock2 {
    public void start(int interval, final boolean beep) {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                System.out.println("At the tone,the time is " + now);
                if (beep) {
                    Toolkit.getDefaultToolkit().beep();
                    System.out.println("beeped one time!");
                }
            }
        };
        Timer t = new Timer(interval, listener);
        t.start();
    }
}
