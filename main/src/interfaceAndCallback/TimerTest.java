package interfaceAndCallback;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by Administrator on 2016/2/21.
 */
public class TimerTest {
    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();
        //每隔10秒执行一次ActionListener中的actionPerformed()方法
        Timer t = new Timer(10000,listener);
        t.start();

        JOptionPane.showMessageDialog(null,"quit program?");
        System.exit(0);
    }
}

class TimePrinter implements ActionListener {
    public void actionPerformed(ActionEvent actionEvent) {
        Date now = new Date();
        System.out.println("At the tone,the time is" + now);
        Toolkit.getDefaultToolkit().beep();
    }
}