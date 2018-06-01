package chap7.image;

import javax.swing.*;
import java.awt.*;

/**
 * @author zhangjianghao
 * @version 2018-05-31
 */
public class ImageTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame imageFrame = new ImageFrame();
            imageFrame.setTitle("ImageTest");
            imageFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            imageFrame.setVisible(true);
        });
    }
}

class ImageFrame extends JFrame {
    ImageFrame() {
        add(new ImageComponent());
        pack();
    }
}

class ImageComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private Image image;

    ImageComponent() {
        image = new ImageIcon(ClassLoader.getSystemResource("").getPath() + "chap7/funface.jpg").getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (image != null) {
            //图像的真实尺寸是1024*915，这里做缩小处理
            //int imageWidth = image.getWidth(this);
            int imageWidth = 102;
            //int imageHeight = image.getHeight(this);
            int imageHeight = 91;
            g2.drawImage(image, 0, 0, 102, 91, null);

            int frameWidth = getWidth();
            int frameHeight = getHeight();
            for (int i = 0; i * imageWidth <= frameWidth; i++) {
                for (int j = 0; j * imageHeight <= frameHeight; j++) {
                    if (i != 0 || j != 0) {
                        g2.copyArea(0, 0, imageWidth, imageHeight, i * imageWidth, j * imageHeight);
                    }
                }
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
