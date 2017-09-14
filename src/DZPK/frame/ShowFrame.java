package DZPK.frame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Shanzhai on 2017/9/14.
 */
public class ShowFrame {
    public static void test(){
        JFrame frame = new JFrame("测试专用弹窗");
        frame.setSize(800,600);
        JPanel panel = new JPanel();
        JTextArea textArea = new JTextArea();

        panel.setLayout(new GridLayout());
        textArea.setText("test");
        //当TextArea里的内容过长时生成滚动条
        panel.add(new JScrollPane(textArea));
        frame.add(panel);

        frame.setVisible(true);
    }
}
