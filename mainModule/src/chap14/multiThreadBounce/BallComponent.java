package chap14.multiThreadBounce;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * 弹球图像组件
 */
public class BallComponent extends JPanel {
    private static final int DEFAULT_WIDTH = 450;
    private static final int DEFAULT_HEIGHT = 350;

    private java.util.List<Ball> balls = new ArrayList<>();

    public void add(Ball b) {
        balls.add(b);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);//擦除背景
        Graphics2D g2d = (Graphics2D) g;
        for (Ball b : balls) {
            g2d.fill(b.getShape());
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
