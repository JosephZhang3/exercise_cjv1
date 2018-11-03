package chap14.multiThreadBounce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * 使用多线程，实现多个球同时弹跳（每个球都在自己独立的线程中运行）
 */
public class BounceThread {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new MultiThreadBounceFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
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
        /**
         * 把小球移动和图像组件重绘放到线程的run()方法里
         */
        for (int i = 1; i <= STEPS; i++) {
            ball.move(ballComp.getBounds());
            System.out.println("jumped\t" + i + "\ttimes");
            //不像只有单个球在跳动，如果多个球同时跳动，那么就要完全擦除背景，把所有的球重绘一遍。
            //否则，如果调用  ballComp.paint(ballComp.getGraphics());  屏幕上的球会抖动并且有残留
            ballComp.repaint();
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

    MultiThreadBounceFrame() {
        setTitle("多个小球同时弹跳");

        ballComp = new BallComponent();
        add(ballComp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        /**
         * 每次点击start按钮，都会调用addBall()开启一个独立的线程，进而调用BallRunnable类的run()方法
         */
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

        /**
         * 创建线程并启动线程，核心代码
         */
        Runnable r = new BallRunnable(ball, ballComp);//可以看作是，把Ball对象封装了一下，让其和BallComponent对象在各个独立的线程里以多线程方式使用
        Thread t = new Thread(r);
        t.start();

    }
}