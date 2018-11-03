package chap14.multiThreadBounce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * 使用多线程，实现多个球同时弹跳（每个球都在自己独立的线程中运行）
 */
public class BounceThread {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new MultiThreadBounceFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

}

class BallRunnable implements Runnable {
    private Ball ball;
    private BallComponent ballComp;
    private static final int STEPS = 1000;
    private static final int DELAY = 5;

    BallRunnable(Ball aBall, BallComponent aBallComp) {
        ball = aBall;
        ballComp = aBallComp;
    }

    @Override
    public void run() {
        for (int i = 1; i <= STEPS; i++) {
            ball.move(ballComp.getBounds());
            System.out.println("jumped\t" + i + "\ttimes");
            ballComp.repaint();//ballComp.getGraphics()
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MultiThreadBounceFrame extends JFrame {

    private BallComponent ballComp;

    /**
     * 构造器
     * 构造带有组件的边框，用于显示正在反弹的球和“开始”“结束”按钮。
     */
    MultiThreadBounceFrame() {
        setTitle("多个小球同时弹跳");


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

        Runnable r = new BallRunnable(ball, ballComp);
        Thread t = new Thread(r);
        t.start();
    }
}