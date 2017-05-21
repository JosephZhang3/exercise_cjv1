package chap6.callback;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * 定时器
 * Created by Administrator on 2016/2/21.
 */
public class TimerTest {
    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();
        //每隔10秒执行一次ActionListener对象中的actionPerformed()方法
        //在这里，因为是面向对象编程，所以传递的是对象。而不是像函数式编程那样，直接传递函数来实现回调（callback）
        Timer t = new Timer(10000, listener);
        t.start();

        JOptionPane.showMessageDialog(null, "quit program?");
        System.exit(0);//退出程序（同时销毁动作监听器对象）
    }
}

class TimePrinter implements ActionListener {
    public void actionPerformed(ActionEvent actionEvent) {
        Date now = new Date();
        System.out.println("At the tone,the time is" + now);
        Toolkit.getDefaultToolkit().beep();
    }
}