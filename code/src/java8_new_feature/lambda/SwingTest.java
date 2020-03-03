package java8_new_feature.lambda;

import javax.swing.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class SwingTest {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        JButton jButton = new JButton();
        jButton.setText("鼠标滚轮滑动时打印日志");
        //参数e表示MouseWheelEvent对象，为MouseWheelListener类唯一必须实现的方法的唯一参数
        //因为它的类型可以由编译器自动推断出来，所以不需要多余的显式声明
        jButton.addMouseWheelListener(e -> System.out.println("mouse wheel used"));

/*
        jButton.addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent e) {
                System.out.println("mouse wheel used");
            }
        });
        */

        jFrame.add(jButton);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
