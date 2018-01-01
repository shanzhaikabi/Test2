package com.company.DZPK.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class main_frame {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_frame window = new main_frame();
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
	public main_frame() {
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
		
		JLabel username_label = new JLabel("\u73A9\u5BB6\u6635\u79F0\u6BB5\u4F4D");
		username_label.setFont(new Font("瀹嬩綋", Font.PLAIN, 24));
		username_label.setBounds(640, 20, 320, 72);
		frame.getContentPane().add(username_label);
		
		JComboBox game_combo_1 = new JComboBox();
		game_combo_1.setFont(new Font("宋体", Font.PLAIN, 22));
		game_combo_1.setModel(new DefaultComboBoxModel(new String[] {"", "\u56DB\u822C\u4E1C\u55B0\u8D64", "002", "003"}));
		game_combo_1.setSelectedIndex(1);
		game_combo_1.setBounds(60, 130, 240, 40);
		frame.getContentPane().add(game_combo_1);
		
		JComboBox game_combo_2 = new JComboBox();
		game_combo_2.setFont(new Font("宋体", Font.PLAIN, 22));
		game_combo_2.setModel(new DefaultComboBoxModel(new String[] {"", "001", "002", "003"}));
		game_combo_2.setSelectedIndex(0);
		game_combo_2.setBounds(60, 180, 240, 40);
		frame.getContentPane().add(game_combo_2);
		
		JComboBox game_combo_3 = new JComboBox();
		game_combo_3.setFont(new Font("宋体", Font.PLAIN, 22));
		game_combo_3.setModel(new DefaultComboBoxModel(new String[] {"", "001", "002", "003"}));
		game_combo_3.setBounds(60, 230, 240, 40);
		frame.getContentPane().add(game_combo_3);
		
		JButton yuyue_button_1 = new JButton("\u9884\u7EA6");
		yuyue_button_1.setFont(new Font("宋体", Font.PLAIN, 22));
		yuyue_button_1.setBounds(360, 130, 80, 40);
		frame.getContentPane().add(yuyue_button_1);
		
		JButton yuyue_button_2 = new JButton("\u9884\u7EA6");
		yuyue_button_2.setFont(new Font("宋体", Font.PLAIN, 22));
		yuyue_button_2.setBounds(360, 180, 80, 40);
		frame.getContentPane().add(yuyue_button_2);
		
		JButton yuyue_button_3 = new JButton("\u9884\u7EA6");
		yuyue_button_3.setFont(new Font("宋体", Font.PLAIN, 22));
		yuyue_button_3.setBounds(360, 230, 80, 40);
		frame.getContentPane().add(yuyue_button_3);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 22));
		textField.setText("\u8F93\u5165\u623F\u95F4\u53F7");
		textField.setBounds(630, 150, 240, 40);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton enter_button = new JButton("\u52A0\u5165\u623F\u95F4");
		enter_button.setFont(new Font("宋体", Font.PLAIN, 22));
		enter_button.setBounds(690, 210, 120, 40);
		frame.getContentPane().add(enter_button);
		
		JLabel userdata_label = new JLabel("\u2014\u2014\u4E2A\u4EBA\u6218\u7EE9\u2014\u2014");
		userdata_label.setHorizontalAlignment(SwingConstants.CENTER);
		userdata_label.setFont(new Font("宋体", Font.PLAIN, 22));
		userdata_label.setBounds(139, 372, 240, 40);
		frame.getContentPane().add(userdata_label);
		
		JLabel scoredata_label = new JLabel("\u5F97\u70B9");
		scoredata_label.setFont(new Font("宋体", Font.PLAIN, 22));
		scoredata_label.setBounds(139, 425, 240, 40);
		frame.getContentPane().add(scoredata_label);
		
		JLabel rankdata_label = new JLabel("\u987A\u4F4D");
		rankdata_label.setFont(new Font("宋体", Font.PLAIN, 22));
		rankdata_label.setBounds(139, 478, 240, 40);
		frame.getContentPane().add(rankdata_label);
		
		JLabel moneydata_label = new JLabel("\u6536\u652F");
		moneydata_label.setFont(new Font("宋体", Font.PLAIN, 22));
		moneydata_label.setBounds(139, 531, 240, 40);
		frame.getContentPane().add(moneydata_label);
		
		JButton qurey_button = new JButton("\u67E5\u8BE2\u8BE6\u7EC6\u6218\u7EE9");
		qurey_button.setFont(new Font("宋体", Font.PLAIN, 22));
		qurey_button.setBounds(169, 584, 180, 40);
		frame.getContentPane().add(qurey_button);
		
		JButton exit_button = new JButton("\u8F93\u5149\u4E86\u4E0D\u60F3\u73A9\u4E86");
		exit_button.setFont(new Font("宋体", Font.PLAIN, 22));
		exit_button.setBounds(820, 705, 200, 60);
		frame.getContentPane().add(exit_button);
		
		JLabel history_label = new JLabel("\u2014\u2014\u5386\u53F2\u5BF9\u5C40\u2014\u2014");
		history_label.setHorizontalAlignment(SwingConstants.CENTER);
		history_label.setFont(new Font("宋体", Font.PLAIN, 22));
		history_label.setBounds(602, 372, 240, 40);
		frame.getContentPane().add(history_label);
		
		JLabel history_label_1 = new JLabel("\u5386\u53F2\u5BF9\u5C401");
		history_label_1.setFont(new Font("宋体", Font.PLAIN, 22));
		history_label_1.setBounds(602, 425, 240, 40);
		frame.getContentPane().add(history_label_1);
		
		JLabel history_label_2 = new JLabel("\u5386\u53F2\u5BF9\u5C402");
		history_label_2.setFont(new Font("宋体", Font.PLAIN, 22));
		history_label_2.setBounds(602, 478, 240, 40);
		frame.getContentPane().add(history_label_2);
		
		JLabel history_label_3 = new JLabel("\u5386\u53F2\u5BF9\u5C403");
		history_label_3.setFont(new Font("宋体", Font.PLAIN, 22));
		history_label_3.setBounds(602, 531, 240, 40);
		frame.getContentPane().add(history_label_3);
		
		JButton replay_button = new JButton("\u5BF9\u5C40\u56DE\u653E");
		replay_button.setFont(new Font("宋体", Font.PLAIN, 22));
		replay_button.setBounds(632, 584, 180, 40);
		frame.getContentPane().add(replay_button);
	}
}
