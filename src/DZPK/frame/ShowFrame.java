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
        Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize(); // 获得显示器大小对象
        Dimension frameSize = frame.getSize();             // 获得窗口大小对象
        if (frameSize.width > displaySize.width)
            frameSize.width = displaySize.width;           // 窗口的宽度不能大于显示器的宽度
        if (frameSize.height > displaySize.height)
            frameSize.height = displaySize.height;          // 窗口的高度不能大于显示器的高度
        frame.setLocation((displaySize.width - frameSize.width) / 2,
                (displaySize.height - frameSize.height) / 2); // 设置窗口居中显示器显示

        frame.setVisible(true);
    }
}
