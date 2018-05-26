package chap7.draw;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by zhangjianghao on 2018-05-26.
 * 绘制矩形、椭圆、线（包括其特殊形式：圆）
 * <p>
 * 英语词汇
 * rectangle 矩形
 * ellipse 椭圆
 * circle 圆
 * diagonal 对角线
 * radius 半径
 */
public class DrawTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new DrawFrame();
            frame.setTitle("DrawTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class DrawFrame extends JFrame {
    DrawFrame() {
        add(new DrawComponent());
        pack();
    }
}

class DrawComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        double leftx = 100;
        double topy = 100;
        double width = 200;
        double height = 150;

        Rectangle2D rect = new Rectangle2D.Double(leftx, topy, width, height);
        g2.draw(rect);//绘制椭圆的外接矩形
        Ellipse2D ellipse = new Ellipse2D.Double();
        ellipse.setFrame(rect);//设定椭圆的外接矩形
        g2.draw(ellipse);//绘制椭圆

        //绘制外接矩形的两条对角线
        g2.draw(new Line2D.Double(leftx, topy, leftx + width, topy + height));
        g2.draw(new Line2D.Double(leftx, topy + height, leftx + width, topy));

        double centerX = rect.getCenterX();
        double centerY = rect.getCenterY();
        double radius = 150;
        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
        g2.draw(circle);//绘制圆
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}