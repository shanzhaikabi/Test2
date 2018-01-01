package com.company.DZPK.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;

public class game_frame {

	private JFrame frame;
	private JTextField raise_field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					game_frame window = new game_frame();
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
	public game_frame() {
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
		
		JLabel player1_name_label = new JLabel("\u73A9\u5BB61");
		player1_name_label.setFont(new Font("宋体", Font.PLAIN, 22));
		player1_name_label.setBounds(27, 29, 120, 40);
		frame.getContentPane().add(player1_name_label);
		
		JLabel palyer1_label = new JLabel("\u5F53\u524D\u72B6\u6001");
		palyer1_label.setFont(new Font("宋体", Font.PLAIN, 18));
		palyer1_label.setBounds(27, 82, 120, 40);
		frame.getContentPane().add(palyer1_label);
		
		JLabel player2_name_label = new JLabel("\u73A9\u5BB62");
		player2_name_label.setFont(new Font("宋体", Font.PLAIN, 22));
		player2_name_label.setBounds(27, 135, 120, 40);
		frame.getContentPane().add(player2_name_label);
		
		JLabel player2_label = new JLabel("\u5F53\u524D\u72B6\u6001");
		player2_label.setFont(new Font("宋体", Font.PLAIN, 18));
		player2_label.setBounds(27, 188, 120, 40);
		frame.getContentPane().add(player2_label);
		
		JLabel palyer3_name_label = new JLabel("\u73A9\u5BB63");
		palyer3_name_label.setFont(new Font("宋体", Font.PLAIN, 22));
		palyer3_name_label.setBounds(27, 241, 120, 40);
		frame.getContentPane().add(palyer3_name_label);
		
		JLabel player3_label = new JLabel("\u5F53\u524D\u72B6\u6001");
		player3_label.setFont(new Font("宋体", Font.PLAIN, 18));
		player3_label.setBounds(27, 294, 120, 40);
		frame.getContentPane().add(player3_label);
		
		JLabel player4_name_label = new JLabel("\u73A9\u5BB64");
		player4_name_label.setFont(new Font("宋体", Font.PLAIN, 22));
		player4_name_label.setBounds(27, 347, 120, 40);
		frame.getContentPane().add(player4_name_label);
		
		JLabel player4_label = new JLabel("\u5F53\u524D\u72B6\u6001");
		player4_label.setFont(new Font("宋体", Font.PLAIN, 18));
		player4_label.setBounds(27, 400, 120, 40);
		frame.getContentPane().add(player4_label);
		
		JLabel player5_name_label = new JLabel("\u73A9\u5BB65");
		player5_name_label.setFont(new Font("宋体", Font.PLAIN, 22));
		player5_name_label.setBounds(27, 453, 120, 40);
		frame.getContentPane().add(player5_name_label);
		
		JLabel player5_label = new JLabel("\u5F53\u524D\u72B6\u6001");
		player5_label.setFont(new Font("宋体", Font.PLAIN, 18));
		player5_label.setBounds(27, 506, 120, 40);
		frame.getContentPane().add(player5_label);
		
		JLabel player6_name_label = new JLabel("\u73A9\u5BB66");
		player6_name_label.setFont(new Font("宋体", Font.PLAIN, 22));
		player6_name_label.setBounds(27, 559, 120, 40);
		frame.getContentPane().add(player6_name_label);
		
		JLabel player6_label = new JLabel("\u5F53\u524D\u72B6\u6001");
		player6_label.setFont(new Font("宋体", Font.PLAIN, 18));
		player6_label.setBounds(27, 612, 120, 40);
		frame.getContentPane().add(player6_label);
		
		JLabel board_label = new JLabel("\u5E95\u724C\u72B6\u51B5\uFF1A \u9ED1\u6843K  \u9ED1\u6843Q  \u9ED1\u68439  \u672A\u77E5  \u672A\u77E5");
		board_label.setFont(new Font("宋体", Font.PLAIN, 22));
		board_label.setBounds(257, 543, 698, 40);
		frame.getContentPane().add(board_label);
		
		JLabel hole_label = new JLabel("\u60A8\u7684\u624B\u724C\uFF1A \u9ED1\u6843J  \u9ED1\u684310");
		hole_label.setFont(new Font("宋体", Font.PLAIN, 22));
		hole_label.setBounds(257, 596, 334, 40);
		frame.getContentPane().add(hole_label);
		
		JLabel pot_label = new JLabel("\u5E95\u6C60\uFF1A  23333");
		pot_label.setFont(new Font("宋体", Font.PLAIN, 22));
		pot_label.setBounds(27, 679, 203, 40);
		frame.getContentPane().add(pot_label);
		
		JLabel error_label = new JLabel("\u5F53\u524D\u4E0D\u662F\u60A8\u7684\u56DE\u5408\uFF01");
		error_label.setForeground(Color.RED);
		error_label.setFont(new Font("宋体", Font.PLAIN, 22));
		error_label.setBounds(621, 596, 334, 40);
		frame.getContentPane().add(error_label);
		
		JTextArea gameflow_textarea = new JTextArea();
		frame.getContentPane().add(gameflow_textarea);
		gameflow_textarea.setText("\u6E38\u620F\u4FE1\u606F\r\nsjj \u5F03\u724C 2333333");
		gameflow_textarea.setLineWrap(true);
		gameflow_textarea.setEditable(false);
		gameflow_textarea.setFont(new Font("宋体", Font.PLAIN, 24));
		gameflow_textarea.setBounds(257, 32, 698, 498);
		
		JButton raise_button = new JButton("\u52A0\u6CE8");
		raise_button.setFont(new Font("宋体", Font.PLAIN, 22));
		raise_button.setBounds(460, 708, 120, 40);
		frame.getContentPane().add(raise_button);
		
		JButton call_button = new JButton("\u8DDF\u6CE8");
		call_button.setFont(new Font("宋体", Font.PLAIN, 22));
		call_button.setBounds(640, 708, 120, 40);
		frame.getContentPane().add(call_button);
		
		JButton fold_button = new JButton("\u5F03\u724C");
		fold_button.setFont(new Font("宋体", Font.PLAIN, 22));
		fold_button.setBounds(820, 708, 120, 40);
		frame.getContentPane().add(fold_button);
		
		JButton all_in_button = new JButton("ALL-IN");
		all_in_button.setFont(new Font("宋体", Font.PLAIN, 22));
		all_in_button.setBounds(257, 649, 683, 40);
		frame.getContentPane().add(all_in_button);
		
		raise_field = new JTextField();
		raise_field.setFont(new Font("宋体", Font.PLAIN, 22));
		raise_field.setBounds(257, 708, 160, 39);
		frame.getContentPane().add(raise_field);
		raise_field.setColumns(10);

	}
}
