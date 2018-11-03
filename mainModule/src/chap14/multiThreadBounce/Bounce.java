package chap14.multiThreadBounce;

import javax.swing.*;

/**
 * 小球弹跳程序
 * Created by Jianghao Zhang on 2017/5/31.
 */
public class Bounce {
    public static void main(String[] args) {
//        EventQueue
    }
}

class BounceFrame extends JFrame {
    public static final int STEPS = 100;
    public static final int DELAY = 3;
    private BallComponent comp;

    /**
     * 构造带有组件的边框，用于显示正在反弹的球和“开始”“结束”按钮。
     */
    public BounceFrame() {
        setTitle("Bounce");

        comp = new BallComponent();
//        add(comp,BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
//        addButton
    }
}