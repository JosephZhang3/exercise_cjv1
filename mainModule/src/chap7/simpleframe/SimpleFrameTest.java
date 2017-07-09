package chap7.simpleframe;

import javax.swing.*;
import java.awt.*;

/**
 * 创建框架（顶层窗口）
 * Created by Jianghao Zhang on 2017/7/9.
 */
public class SimpleFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleFrame sf = new SimpleFrame();
                sf.setLocation(220, 110);//重新定义组件位置【相对于整个显示器屏幕】 x,y
                sf.setBounds(440, 220, 500, 400);//重新定义组件位置【相对于整个显示器屏幕】和大小 x,y,w,h
                sf.setLocationByPlatform(true);//让窗口系统自动决定窗口的位置

                //会在控制台打印出true  类型为boolean的属性，获取方法由is开头
                System.out.println(sf.isLocationByPlatform());

                sf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                sf.setVisible(true);
            }
        });
    }
}

class SimpleFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HIGHT = 200;

    public SimpleFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HIGHT);
    }
}