package com.company.DZPK.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class detail_frame {

	public static  JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					detail_frame window = new detail_frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public detail_frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("德州扑克对战系统");
		frame.setBounds(100, 100, 1052, 825);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(false);
		
		JLabel sorry_label = new JLabel("\u975E\u5E38\u62B1\u6B49\uFF0C\u7531\u4E8E\u573A\u6B21\u4E0D\u8DB3\uFF0C\u65E0\u6CD5\u663E\u793A\u8BE6\u7EC6\u6570\u636E");
		sorry_label.setHorizontalAlignment(SwingConstants.CENTER);
		sorry_label.setFont(new Font("宋体", Font.PLAIN, 48));
		sorry_label.setBounds(14, 131, 1006, 222);
		frame.getContentPane().add(sorry_label);
		
		JButton return_button = new JButton("\u56DE\u53BB\u591A\u6253\u51E0\u628A");
		return_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main_frame.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		return_button.setFont(new Font("宋体", Font.PLAIN, 48));
		return_button.setBounds(297, 370, 450, 127);
		frame.getContentPane().add(return_button);
		
		JButton wa_button = new JButton("\u4E0D\u73A9\u4E86\u542C\u97F3\u4E50\u4F1A\u53BB");
		wa_button.setEnabled(false);
		wa_button.setFont(new Font("宋体", Font.PLAIN, 48));
		wa_button.setBounds(297, 533, 450, 127);
		frame.getContentPane().add(wa_button);
	}
}
