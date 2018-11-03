package chap14.multiThreadBounce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * 小球弹跳程序
 * Created by Jianghao Zhang on 2017/5/31.
 * Completed on 2018/11/03.
 */
public class Bounce {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new BounceFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class BounceFrame extends JFrame {
    private BallComponent ballComp;
    private static final int STEPS = 1000;
    private static final int DELAY = 3;

    /**
     * 构造器
     * 构造带有组件的边框，用于显示正在反弹的球和“开始”“结束”按钮。
     */
    BounceFrame() {
        setTitle("Bounce弹跳");

        ballComp = new BallComponent();
        add(ballComp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "start", e -> addBall());
        addButton(buttonPanel, "close", e -> System.exit(0));

        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    private void addButton(Container c, String title, ActionListener listener) {
        JButton btn = new JButton(title);
        c.add(btn);
        btn.addActionListener(listener);
    }

    private void addBall() {
        Ball ball = new Ball();
        ballComp.add(ball);

        for (int i = 1; i <= STEPS; i++) {
            ball.move(ballComp.getBounds());
            System.out.println("jumped\t" + i + "\ttimes");
            ballComp.paint(ballComp.getGraphics());
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}