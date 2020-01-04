package chap11.log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.*;

public class LoggingImageViewer {

    private static Logger myOwnLogger = Logger.getLogger("chap11.log");

    public static void main(String[] args) {
        if (System.getProperty("java.util.logging.config.class") == null && System.getProperty("java.util.logging.config.file") == null) {
            try {
                myOwnLogger.setLevel(Level.ALL);
                Handler handler = new FileHandler("%h/myExercise.log", 0, 10);
                myOwnLogger.addHandler(handler);
            } catch (IOException e) {
                myOwnLogger.log(Level.SEVERE, "Can not create log file handler", e);
            }

            //use multi thread way to handle log
            EventQueue.invokeLater(() -> {
                Handler windowHandler = new WindowHandler();
                windowHandler.setLevel(Level.ALL);
                myOwnLogger.addHandler(windowHandler);

                JFrame frame = new ImageViewerFrame();
                frame.setTitle("Logging Image Viewer");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                myOwnLogger.fine("Now showing frame...");
                frame.setVisible(true);
            });
        }
    }
}

class ImageViewerFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;

    private JLabel label;
    private static Logger logger = Logger.getLogger("chap11.log");

    ImageViewerFrame() {
        logger.entering("ImageViewerFrame", "<constructor>");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(new FileOpenListener());

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(e -> {
            logger.fine("Exiting...");
            System.exit(0);
        });

        label = new JLabel();
        add(label);
        logger.exiting("ImageViewerFrame", "<constructor>");
    }

    private class FileOpenListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            logger.entering("ImageViewerFrame.FileOpenListener", "actionPerformed", e);

            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));
            chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
                @Override
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".gif") || f.isDirectory();
                }

                @Override
                public String getDescription() {
                    return "GIF images";
                }
            });

            int flag = chooser.showOpenDialog(ImageViewerFrame.this);
            if (flag == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getPath();
                logger.log(Level.FINE, "Reading file {0}", name);
                label.setIcon(new ImageIcon(name));
            } else {
                logger.fine("File open dialog canceled");
                logger.exiting("ImageViewerFrame.FileOpenListener", "actionPerformed");
            }
        }
    }
}

class WindowHandler extends StreamHandler {
    private JFrame frame;

    WindowHandler() {
        frame = new JFrame();
        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        frame.add(new JScrollPane(textArea));
        frame.setTitle("LogRecord TextArea");
        frame.setSize(200, 200);
        frame.setFocusableWindowState(false);
        frame.setVisible(true);

        super.setOutputStream(new OutputStream() {
            @Override
            public void write(int b) {
                //ignore
            }

            @Override
            public void write(byte[] b, int off, int len) {
                textArea.append(new String(b, off, len));//以off偏移量为起点，截取len长度
            }
        });
    }

    @Override
    public synchronized void publish(LogRecord record) {
        if (!frame.isVisible()) {
            throw new IllegalAccessError("*****Can not do publish when frame is not visible*****");
        }
        super.publish(record);
        flush();//Attention! you must flush the stream buffer every time when push logRecord!
    }
}