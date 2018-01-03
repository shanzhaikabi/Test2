package com.company.DZPK.frame;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;

public class query_frame {

	private JFrame frame;
	public static JLabel time[]=new JLabel[10];//发生时间
	public static JLabel money[]=new JLabel[10];//当局的钱
	public static JLabel point[]=new JLabel[10];//当局事前得点
	public static JLabel delta[]=new JLabel[10];//当局得点变动
	public static JButton return_button;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					query_frame window = new query_frame();
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
	public query_frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5FB7\u5DDE\u6251\u514B\u5BF9\u6218\u7CFB\u7EDF");
		frame.setBounds(100, 100, 1052, 825);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6700\u8FD1\u5341\u573A\u6218\u7EE9");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 48));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(14, 13, 1006, 107);
		frame.getContentPane().add(lblNewLabel);

		return_button =new JButton("返回");
		return_button.setFont(new Font("宋体", Font.PLAIN, 36));
		return_button.setHorizontalAlignment(SwingConstants.CENTER);
		return_button.setBounds(820, 720, 160, 48);
		frame.getContentPane().add(return_button);

		time[0] = new JLabel("");
		time[0].setFont(new Font("宋体", Font.PLAIN, 36));
		time[0].setHorizontalAlignment(SwingConstants.CENTER);
		time[0].setBounds(100, 120, 160, 60);
		frame.getContentPane().add(time[0]);

		money[0] = new JLabel("");
		money[0].setFont(new Font("宋体", Font.PLAIN, 36));
		money[0].setHorizontalAlignment(SwingConstants.CENTER);
		money[0].setBounds(300, 120, 160, 60);
		frame.getContentPane().add(money[0]);

		point[0] = new JLabel("");
		point[0].setFont(new Font("宋体", Font.PLAIN, 36));
		point[0].setHorizontalAlignment(SwingConstants.CENTER);
		point[0].setBounds(500, 120, 160, 60);
		frame.getContentPane().add(point[0]);

		delta[0] = new JLabel("");
		delta[0].setFont(new Font("宋体", Font.PLAIN, 36));
		delta[0].setHorizontalAlignment(SwingConstants.CENTER);
		delta[0].setBounds(700, 120, 160, 60);
		frame.getContentPane().add(delta[0]);

		time[1] = new JLabel("");
		time[1].setFont(new Font("宋体", Font.PLAIN, 36));
		time[1].setHorizontalAlignment(SwingConstants.CENTER);
		time[1].setBounds(100, 180, 160, 60);
		frame.getContentPane().add(time[1]);

		money[1] = new JLabel("");
		money[1].setFont(new Font("宋体", Font.PLAIN, 36));
		money[1].setHorizontalAlignment(SwingConstants.CENTER);
		money[1].setBounds(300, 180, 160, 60);
		frame.getContentPane().add(money[1]);

		point[1] = new JLabel("");
		point[1].setFont(new Font("宋体", Font.PLAIN, 36));
		point[1].setHorizontalAlignment(SwingConstants.CENTER);
		point[1].setBounds(500, 180, 160, 60);
		frame.getContentPane().add(point[1]);

		delta[1] = new JLabel("");
		delta[1].setFont(new Font("宋体", Font.PLAIN, 36));
		delta[1].setHorizontalAlignment(SwingConstants.CENTER);
		delta[1].setBounds(700, 180, 160, 60);
		frame.getContentPane().add(delta[1]);

		time[2] = new JLabel("");
		time[2].setFont(new Font("宋体", Font.PLAIN, 36));
		time[2].setHorizontalAlignment(SwingConstants.CENTER);
		time[2].setBounds(100, 240, 160, 60);
		frame.getContentPane().add(time[2]);

		money[2] = new JLabel("");
		money[2].setFont(new Font("宋体", Font.PLAIN, 36));
		money[2].setHorizontalAlignment(SwingConstants.CENTER);
		money[2].setBounds(300, 240, 160, 60);
		frame.getContentPane().add(money[2]);

		point[2] = new JLabel("");
		point[2].setFont(new Font("宋体", Font.PLAIN, 36));
		point[2].setHorizontalAlignment(SwingConstants.CENTER);
		point[2].setBounds(500, 240, 160, 60);
		frame.getContentPane().add(point[2]);

		delta[2] = new JLabel("");
		delta[2].setFont(new Font("宋体", Font.PLAIN, 36));
		delta[2].setHorizontalAlignment(SwingConstants.CENTER);
		delta[2].setBounds(700, 240, 160, 60);
		frame.getContentPane().add(delta[2]);

		time[3] = new JLabel("");
		time[3].setFont(new Font("宋体", Font.PLAIN, 36));
		time[3].setHorizontalAlignment(SwingConstants.CENTER);
		time[3].setBounds(100, 300, 160, 60);
		frame.getContentPane().add(time[3]);

		money[3] = new JLabel("");
		money[3].setFont(new Font("宋体", Font.PLAIN, 36));
		money[3].setHorizontalAlignment(SwingConstants.CENTER);
		money[3].setBounds(300, 300, 160, 60);
		frame.getContentPane().add(money[3]);

		point[3] = new JLabel("");
		point[3].setFont(new Font("宋体", Font.PLAIN, 36));
		point[3].setHorizontalAlignment(SwingConstants.CENTER);
		point[3].setBounds(500, 300, 160, 60);
		frame.getContentPane().add(point[3]);

		delta[3] = new JLabel("");
		delta[3].setFont(new Font("宋体", Font.PLAIN, 36));
		delta[3].setHorizontalAlignment(SwingConstants.CENTER);
		delta[3].setBounds(700, 300, 160, 60);
		frame.getContentPane().add(delta[3]);

		time[4] = new JLabel("");
		time[4].setFont(new Font("宋体", Font.PLAIN, 36));
		time[4].setHorizontalAlignment(SwingConstants.CENTER);
		time[4].setBounds(100, 360, 160, 60);
		frame.getContentPane().add(time[4]);

		money[4] = new JLabel("");
		money[4].setFont(new Font("宋体", Font.PLAIN, 36));
		money[4].setHorizontalAlignment(SwingConstants.CENTER);
		money[4].setBounds(300, 360, 160, 60);
		frame.getContentPane().add(money[4]);

		point[4] = new JLabel("");
		point[4].setFont(new Font("宋体", Font.PLAIN, 36));
		point[4].setHorizontalAlignment(SwingConstants.CENTER);
		point[4].setBounds(500, 360, 160, 60);
		frame.getContentPane().add(point[4]);

		delta[4] = new JLabel("");
		delta[4].setFont(new Font("宋体", Font.PLAIN, 36));
		delta[4].setHorizontalAlignment(SwingConstants.CENTER);
		delta[4].setBounds(700, 360, 160, 60);
		frame.getContentPane().add(delta[4]);

		time[5] = new JLabel("");
		time[5].setFont(new Font("宋体", Font.PLAIN, 36));
		time[5].setHorizontalAlignment(SwingConstants.CENTER);
		time[5].setBounds(100, 420, 160, 60);
		frame.getContentPane().add(time[5]);

		money[5] = new JLabel("");
		money[5].setFont(new Font("宋体", Font.PLAIN, 36));
		money[5].setHorizontalAlignment(SwingConstants.CENTER);
		money[5].setBounds(300, 420, 160, 60);
		frame.getContentPane().add(money[5]);

		point[5] = new JLabel("");
		point[5].setFont(new Font("宋体", Font.PLAIN, 36));
		point[5].setHorizontalAlignment(SwingConstants.CENTER);
		point[5].setBounds(500, 420, 160, 60);
		frame.getContentPane().add(point[5]);

		delta[5] = new JLabel("");
		delta[5].setFont(new Font("宋体", Font.PLAIN, 36));
		delta[5].setHorizontalAlignment(SwingConstants.CENTER);
		delta[5].setBounds(700, 420, 160, 60);
		frame.getContentPane().add(delta[5]);

		time[6] = new JLabel("");
		time[6].setFont(new Font("宋体", Font.PLAIN, 36));
		time[6].setHorizontalAlignment(SwingConstants.CENTER);
		time[6].setBounds(100, 480, 160, 60);
		frame.getContentPane().add(time[6]);

		money[6] = new JLabel("");
		money[6].setFont(new Font("宋体", Font.PLAIN, 36));
		money[6].setHorizontalAlignment(SwingConstants.CENTER);
		money[6].setBounds(300, 480, 160, 60);
		frame.getContentPane().add(money[6]);

		point[6] = new JLabel("");
		point[6].setFont(new Font("宋体", Font.PLAIN, 36));
		point[6].setHorizontalAlignment(SwingConstants.CENTER);
		point[6].setBounds(500, 480, 160, 60);
		frame.getContentPane().add(point[6]);

		delta[6] = new JLabel("");
		delta[6].setFont(new Font("宋体", Font.PLAIN, 36));
		delta[6].setHorizontalAlignment(SwingConstants.CENTER);
		delta[6].setBounds(700, 480, 160, 60);
		frame.getContentPane().add(delta[6]);

		time[7] = new JLabel("");
		time[7].setFont(new Font("宋体", Font.PLAIN, 36));
		time[7].setHorizontalAlignment(SwingConstants.CENTER);
		time[7].setBounds(100, 540, 160, 60);
		frame.getContentPane().add(time[7]);

		money[7] = new JLabel("");
		money[7].setFont(new Font("宋体", Font.PLAIN, 36));
		money[7].setHorizontalAlignment(SwingConstants.CENTER);
		money[7].setBounds(300, 540, 160, 60);
		frame.getContentPane().add(money[7]);

		point[7] = new JLabel("");
		point[7].setFont(new Font("宋体", Font.PLAIN, 36));
		point[7].setHorizontalAlignment(SwingConstants.CENTER);
		point[7].setBounds(500, 540, 160, 60);
		frame.getContentPane().add(point[7]);

		delta[7] = new JLabel("");
		delta[7].setFont(new Font("宋体", Font.PLAIN, 36));
		delta[7].setHorizontalAlignment(SwingConstants.CENTER);
		delta[7].setBounds(700, 540, 160, 60);
		frame.getContentPane().add(delta[7]);

		time[8] = new JLabel("");
		time[8].setFont(new Font("宋体", Font.PLAIN, 36));
		time[8].setHorizontalAlignment(SwingConstants.CENTER);
		time[8].setBounds(100, 600, 160, 60);
		frame.getContentPane().add(time[8]);

		money[8] = new JLabel("");
		money[8].setFont(new Font("宋体", Font.PLAIN, 36));
		money[8].setHorizontalAlignment(SwingConstants.CENTER);
		money[8].setBounds(300, 600, 160, 60);
		frame.getContentPane().add(money[8]);

		point[8] = new JLabel("");
		point[8].setFont(new Font("宋体", Font.PLAIN, 36));
		point[8].setHorizontalAlignment(SwingConstants.CENTER);
		point[8].setBounds(500, 600, 160, 60);
		frame.getContentPane().add(point[8]);

		delta[8] = new JLabel("");
		delta[8].setFont(new Font("宋体", Font.PLAIN, 36));
		delta[8].setHorizontalAlignment(SwingConstants.CENTER);
		delta[8].setBounds(700, 600, 160, 60);
		frame.getContentPane().add(delta[8]);

		time[9] = new JLabel("");
		time[9].setFont(new Font("宋体", Font.PLAIN, 36));
		time[9].setHorizontalAlignment(SwingConstants.CENTER);
		time[9].setBounds(100, 660, 160, 60);
		frame.getContentPane().add(time[9]);

		money[9] = new JLabel("");
		money[9].setFont(new Font("宋体", Font.PLAIN, 36));
		money[9].setHorizontalAlignment(SwingConstants.CENTER);
		money[9].setBounds(300, 660, 160, 60);
		frame.getContentPane().add(money[9]);

		point[9] = new JLabel("");
		point[9].setFont(new Font("宋体", Font.PLAIN, 36));
		point[9].setHorizontalAlignment(SwingConstants.CENTER);
		point[9].setBounds(500, 660, 160, 60);
		frame.getContentPane().add(point[9]);

		delta[9] = new JLabel("");
		delta[9].setFont(new Font("宋体", Font.PLAIN, 36));
		delta[9].setHorizontalAlignment(SwingConstants.CENTER);
		delta[9].setBounds(700, 660, 160, 60);
		frame.getContentPane().add(delta[9]);
	}
}
