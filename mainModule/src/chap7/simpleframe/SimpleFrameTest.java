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
                Toolkit tool = sf.getToolkit();
                System.out.println(SimpleFrame.class.getResource("/") + "chap7/funface.jpg");//      file:/C:/git-repos/exercise_cjv1/compile/chap7/funface.jpg

                String path = (SimpleFrame.class.getResource("/") + "chap7/funface.jpg").substring(6);
                Image img = tool.getImage(path);//注意这里的图像文件的路径必须以操作系统文件系统的盘符开头，不能以  file:/  开头
                sf.setIconImage(img);
                sf.setTitle("simpleFrame");

                sf.setLocation(220, 110);//定位组件 x,y
                sf.setBounds(440, 220, 500, 400);//定位组件和定义组件大小 参数依次为x,y,width,height
                sf.setLocationByPlatform(true);//让窗口系统根据底层平台自动决定窗口的位置

                //会在控制台打印出true
                //注意：类型为boolean的属性，获取方法由is开头，而不是get
                System.out.println(sf.isLocationByPlatform());

                sf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//定义用户关闭框架时的响应动作，这里是让程序简单地退出
                sf.setVisible(true);//设定是否可见
            }
        });
    }
}

class SimpleFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    SimpleFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}