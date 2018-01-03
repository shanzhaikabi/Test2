package com.company.DZPK.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class  game_final_frame {

	private JFrame frame;
	public static JLabel[] player_rank_label=new JLabel[6];
	public static JLabel[] player_name=new JLabel[6];
	public static JLabel[] player_money=new JLabel[6];
	public static JLabel[] player_point=new JLabel[6];
	public static JLabel[] player_delta=new JLabel[6];
	public static JLabel title_label;
	public static JButton return_button;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					game_final_frame window = new game_final_frame();
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
	public game_final_frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5FB7\u5DDE\u6251\u5120B\u5BF9\u6218\u7CFB\u7EDF");
		frame.setBounds(100, 100, 1052, 825);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		player_rank_label[0] = new JLabel("\u4E00\u4F4D");
		player_rank_label[0].setFont(new Font("宋体", Font.PLAIN, 32));
		player_rank_label[0].setBounds(120, 120, 180, 50);
		player_rank_label[0].setVisible(true);
		frame.getContentPane().add(player_rank_label[0]);
		
		player_rank_label[1] = new JLabel("\u4E24\u4F4D");
		player_rank_label[1].setFont(new Font("宋体", Font.PLAIN, 32));
		player_rank_label[1].setBounds(120, 200, 180, 50);
		player_rank_label[1].setVisible(true);
		frame.getContentPane().add(player_rank_label[1]);
		
		player_rank_label[2] = new JLabel("\u4E09\u4F4D");
		player_rank_label[2].setFont(new Font("宋体", Font.PLAIN, 32));
		player_rank_label[2].setBounds(120, 280, 180, 50);
		player_rank_label[2].setVisible(true);
		frame.getContentPane().add(player_rank_label[2]);
		
		player_rank_label[3] = new JLabel("\u56DB\u4F4D");
		player_rank_label[3].setFont(new Font("宋体", Font.PLAIN, 32));
		player_rank_label[3].setBounds(120, 360, 180, 50);
		player_rank_label[3].setVisible(true);
		frame.getContentPane().add(player_rank_label[3]);
		
		player_rank_label[4] = new JLabel("\u4E94\u4F4D");
		player_rank_label[4].setFont(new Font("宋体", Font.PLAIN, 32));
		player_rank_label[4].setBounds(120, 440, 180, 50);
		player_rank_label[4].setVisible(true);
		frame.getContentPane().add(player_rank_label[4]);
		
		player_rank_label[5] = new JLabel("\u516D\u4F4D");
		player_rank_label[5].setFont(new Font("宋体", Font.PLAIN, 32));
		player_rank_label[5].setBounds(120, 520, 180, 50);
		player_rank_label[5].setVisible(true);
		frame.getContentPane().add(player_rank_label[5]);
		
		player_name[0] = new JLabel("sijiji");
		player_name[0].setFont(new Font("宋体", Font.PLAIN, 32));
		player_name[0].setBounds(300, 120, 180, 50);
		player_name[0].setVisible(true);
		frame.getContentPane().add(player_name[0]);
		
		player_money[0] = new JLabel("sijiji");
		player_money[0].setFont(new Font("宋体", Font.PLAIN, 32));
		player_money[0].setBounds(480, 120, 180, 50);
		player_money[0].setVisible(true);
		frame.getContentPane().add(player_money[0]);
		
		player_point[0] = new JLabel("sijiji");
		player_point[0].setFont(new Font("宋体", Font.PLAIN, 32));
		player_point[0].setBounds(660, 120, 180, 50);
		player_point[0].setVisible(true);
		frame.getContentPane().add(player_point[0]);
		
		player_delta[0] = new JLabel("sijiji");
		player_delta[0].setFont(new Font("宋体", Font.PLAIN, 32));
		player_delta[0].setBounds(840, 120, 180, 50);
		player_delta[0].setVisible(true);
		frame.getContentPane().add(player_delta[0]);
		
		player_name[1] = new JLabel("sijiji");
		player_name[1].setFont(new Font("宋体", Font.PLAIN, 32));
		player_name[1].setBounds(300, 200, 180, 50);
		player_name[1].setVisible(true);
		frame.getContentPane().add(player_name[1]);
		
		player_money[1] = new JLabel("sijiji");
		player_money[1].setFont(new Font("宋体", Font.PLAIN, 32));
		player_money[1].setBounds(480, 200, 180, 50);
		player_money[1].setVisible(true);
		frame.getContentPane().add(player_money[1]);
		
		player_point[1] = new JLabel("sijiji");
		player_point[1].setFont(new Font("宋体", Font.PLAIN, 32));
		player_point[1].setBounds(660, 200, 180, 50);
		player_point[1].setVisible(true);
		frame.getContentPane().add(player_point[1]);
		
		player_delta[1] = new JLabel("sijiji");
		player_delta[1].setFont(new Font("宋体", Font.PLAIN, 32));
		player_delta[1].setBounds(840, 200, 180, 50);
		player_delta[1].setVisible(true);
		frame.getContentPane().add(player_delta[1]);
		
		
		player_name[2] = new JLabel("sijiji");
		player_name[2].setFont(new Font("宋体", Font.PLAIN, 32));
		player_name[2].setBounds(300, 280, 180, 50);
		player_name[2].setVisible(true);
		frame.getContentPane().add(player_name[2]);
		
		player_money[2] = new JLabel("sijiji");
		player_money[2].setFont(new Font("宋体", Font.PLAIN, 32));
		player_money[2].setBounds(480, 280, 180, 50);
		player_money[2].setVisible(true);
		frame.getContentPane().add(player_money[2]);
		
		player_point[2] = new JLabel("sijiji");
		player_point[2].setFont(new Font("宋体", Font.PLAIN, 32));
		player_point[2].setBounds(660, 280, 180, 50);
		player_point[2].setVisible(true);
		frame.getContentPane().add(player_point[2]);
		
		player_delta[2] = new JLabel("sijiji");
		player_delta[2].setFont(new Font("宋体", Font.PLAIN, 32));
		player_delta[2].setBounds(840, 280, 180, 50);
		player_delta[2].setVisible(true);
		frame.getContentPane().add(player_delta[2]);
		
		player_name[3] = new JLabel("sijiji");
		player_name[3].setFont(new Font("宋体", Font.PLAIN, 32));
		player_name[3].setBounds(300, 360, 180, 50);
		player_name[3].setVisible(true);
		frame.getContentPane().add(player_name[3]);
		
		player_money[3] = new JLabel("sijiji");
		player_money[3].setFont(new Font("宋体", Font.PLAIN, 32));
		player_money[3].setBounds(480, 360, 180, 50);
		player_money[3].setVisible(true);
		frame.getContentPane().add(player_money[3]);
		
		player_point[3] = new JLabel("sijiji");
		player_point[3].setFont(new Font("宋体", Font.PLAIN, 32));
		player_point[3].setBounds(660, 360, 180, 50);
		player_point[3].setVisible(true);
		frame.getContentPane().add(player_point[3]);
		
		player_delta[3] = new JLabel("sijiji");
		player_delta[3].setFont(new Font("宋体", Font.PLAIN, 32));
		player_delta[3].setBounds(840, 360, 180, 50);
		player_delta[3].setVisible(true);
		frame.getContentPane().add(player_delta[3]);
		
		player_name[4] = new JLabel("sijiji");
		player_name[4].setFont(new Font("宋体", Font.PLAIN, 32));
		player_name[4].setBounds(300, 440,180, 50);
		player_name[4].setVisible(true);
		frame.getContentPane().add(player_name[4]);
		
		player_money[4] = new JLabel("sijiji");
		player_money[4].setFont(new Font("宋体", Font.PLAIN, 32));
		player_money[4].setBounds(480, 440, 180, 50);
		player_money[4].setVisible(true);
		frame.getContentPane().add(player_money[4]);
		
		player_point[4] = new JLabel("sijiji");
		player_point[4].setFont(new Font("宋体", Font.PLAIN, 32));
		player_point[4].setBounds(660, 440, 180, 50);
		player_point[4].setVisible(true);
		frame.getContentPane().add(player_point[4]);
		
		player_delta[4] = new JLabel("sijiji");
		player_delta[4].setFont(new Font("宋体", Font.PLAIN, 32));
		player_delta[4].setBounds(840, 440, 180, 50);
		player_delta[4].setVisible(true);
		frame.getContentPane().add(player_delta[4]);
		
		player_name[5] = new JLabel("sijiji");
		player_name[5].setFont(new Font("宋体", Font.PLAIN, 32));
		player_name[5].setBounds(300, 520, 180, 50);
		player_name[5].setVisible(true);
		frame.getContentPane().add(player_name[5]);
		
		player_money[5] = new JLabel("sijiji");
		player_money[5].setFont(new Font("宋体", Font.PLAIN, 32));
		player_money[5].setBounds(480, 520, 180, 50);
		player_money[5].setVisible(true);
		frame.getContentPane().add(player_money[5]);
		
		player_point[5] = new JLabel("sijiji");
		player_point[5].setFont(new Font("宋体", Font.PLAIN, 32));
		player_point[5].setBounds(660, 520, 180, 50);
		player_point[5].setVisible(true);
		frame.getContentPane().add(player_point[5]);
		
		player_delta[5] = new JLabel("sijiji");
		player_delta[5].setFont(new Font("宋体", Font.PLAIN, 32));
		player_delta[5].setBounds(840, 520, 180, 50);
		player_delta[5].setVisible(true);
		frame.getContentPane().add(player_delta[5]);
		
		title_label = new JLabel("\u6E38\u620F\u7ED3\u675F");
		title_label.setHorizontalAlignment(SwingConstants.CENTER);
		title_label.setFont(new Font("宋体", Font.PLAIN, 60));
		title_label.setBounds(14, 13, 1006, 83);
		frame.getContentPane().add(title_label);
		
		return_button = new JButton("\u8FD4\u56DE\u5927\u5385");
		return_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		return_button.setFont(new Font("宋体", Font.PLAIN, 32));
		return_button.setBounds(823, 682, 197, 83);
		frame.getContentPane().add(return_button);
		

		
	}
}
