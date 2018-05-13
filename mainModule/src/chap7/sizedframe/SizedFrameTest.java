package chap7.sizedframe;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * 确定合适的框架大小
 * Created by Jianghao Zhang on 2017/7/9.
 */
public class SizedFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new SizedFrame();
                frame.setVisible(true);
            }
        });
    }
}

class SizedFrame extends JFrame {
    SizedFrame() {
        Toolkit tool = Toolkit.getDefaultToolkit();
        Dimension screenSize = tool.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        System.out.println("屏幕的分辨率为" + screenWidth + "*" + screenHeight);

        setSize(screenWidth / 2, screenHeight / 2);
        setLocationByPlatform(true);

        //得到当前ClassPath的绝对URI路径，ClassPath即编译后的形成的文件夹的根路径
        System.out.println(SizedFrame.class.getResource("/"));//file:/C:/git-repos/exercise_cjv1/compile/
        System.out.println(ClassLoader.getSystemResource(""));//file:/C:/git-repos/exercise_cjv1/compile/

        URL url = ClassLoader.getSystemResource("");
        Image img = new ImageIcon(url.getPath() + "chap7/funface.jpg").getImage();
        setIconImage(img);

        setTitle("SizedFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setExtendedState(Frame.MAXIMIZED_BOTH);//设置窗口扩展状态为最大
    }
}
