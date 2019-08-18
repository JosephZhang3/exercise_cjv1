package chap7.font;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by zhangjianghao on 2018-05-27.
 * 给文字设置字体
 * <p>
 * 字体的高度分为上坡度、下坡度、行间距
 */
public class FontTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame fontFrame = new FontFrame();
            fontFrame.setTitle("FontTest");
            fontFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            fontFrame.setVisible(true);
        });
    }
}

class FontFrame extends JFrame {
    FontFrame() {
        add(new FontComponent());
        pack();
    }
}

class FontComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        String msg = "god like!";
        Font font = new Font("source code pro", Font.BOLD, 30);
        g2.setFont(font);

        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D stringBounds = font.getStringBounds(msg, context);//字符串边界，一个外接矩形

        double x = (getWidth() - stringBounds.getWidth()) / 2;
        double y = (getHeight() - stringBounds.getHeight()) / 2;

        double ascent = -stringBounds.getY();//上坡度为边界顶部的纵坐标
        double baseY = y + ascent;//基线的纵坐标为字符串边界顶部的高度加上坡度

        g2.drawString(msg, (int) x, (int) baseY);
        g2.setPaint(Color.MAGENTA);

        g2.draw(new Line2D.Double(x, baseY, x + stringBounds.getWidth(), baseY));//根据基线的起点和终点绘制出基线
        Rectangle2D rectangle2D = new Rectangle2D.Double(x, y, stringBounds.getWidth(), stringBounds.getHeight());
        g2.draw(rectangle2D);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
