package chap7.message;

import javax.swing.*;
import java.awt.*;

/**
 * 在组件中显示信息
 */
public class MessageTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new MessageFrame();
            frame.setTitle("message component");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class MessageFrame extends JFrame {
    MessageFrame() {
        add(new MessageComponent());
        pack();//使用默认的首选大小，而不是自定义大小
    }

}

class MessageComponent extends JComponent {
    private static final int MESSAGE_X = 250;
    private static final int MESSAGE_Y = 200;

    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 500;

    /**
     * 绘制组件
     *
     * @param g 图形类，度量单位是像素
     */
    public void paintComponent(Graphics g) {
        g.drawString("Still a helloworld app", MESSAGE_X, MESSAGE_Y);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
