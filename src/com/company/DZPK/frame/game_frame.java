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
import javax.swing.SwingConstants;

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
		
		JPanel ending_panel = new JPanel();
		ending_panel.setBounds(128, 80, 778, 560);
		frame.getContentPane().add(ending_panel);
		ending_panel.setLayout(null);
		
		JLabel ed_nuts_label = new JLabel("\u540C \u82B1 Dark \u987A");
		ed_nuts_label.setHorizontalAlignment(SwingConstants.CENTER);
		ed_nuts_label.setFont(new Font("����", Font.PLAIN, 48));
		ed_nuts_label.setBounds(14, 13, 750, 60);
		ending_panel.add(ed_nuts_label);
		
		JLabel ed_winner_label = new JLabel("\u53F8\u673A\u59EC");
		ed_winner_label.setFont(new Font("����", Font.PLAIN, 22));
		ed_winner_label.setBounds(14, 86, 120, 40);
		ending_panel.add(ed_winner_label);
		
		JLabel ed_board_label = new JLabel("\u5E95\u724C");
		ed_board_label.setFont(new Font("����", Font.PLAIN, 22));
		ed_board_label.setBounds(14, 139, 120, 40);
		ending_panel.add(ed_board_label);
		
		JLabel ed_nuts_detail_label = new JLabel("\u9ED1\u6843A \u9ED1\u6843K \u9ED1\u6843Q \u9ED1\u6843J \u9ED1\u684310");
		ed_nuts_detail_label.setHorizontalAlignment(SwingConstants.CENTER);
		ed_nuts_detail_label.setFont(new Font("����", Font.PLAIN, 22));
		ed_nuts_detail_label.setBounds(14, 86, 750, 40);
		ending_panel.add(ed_nuts_detail_label);
		
		JLabel ed_board_detail_label = new JLabel("\u9ED1\u6843K \u9ED1\u6843Q \u9ED1\u68439 \u672A\u77E5 \u672A\u77E5");
		ed_board_detail_label.setHorizontalAlignment(SwingConstants.CENTER);
		ed_board_detail_label.setFont(new Font("����", Font.PLAIN, 22));
		ed_board_detail_label.setBounds(14, 139, 750, 40);
		ending_panel.add(ed_board_detail_label);
		
		JLabel ed_player1_name_label = new JLabel("\u53F8\u673A\u59EC");
		ed_player1_name_label.setFont(new Font("����", Font.PLAIN, 22));
		ed_player1_name_label.setBounds(14, 192, 375, 40);
		ending_panel.add(ed_player1_name_label);
		
		JLabel ed_player1_money_label = new JLabel("25000");
		ed_player1_money_label.setFont(new Font("����", Font.PLAIN, 22));
		ed_player1_money_label.setBounds(389, 192, 189, 40);
		ending_panel.add(ed_player1_money_label);
		
		JLabel ed_player1_delta_label = new JLabel("+32000");
		ed_player1_delta_label.setFont(new Font("����", Font.PLAIN, 22));
		ed_player1_delta_label.setBounds(575, 192, 189, 40);
		ending_panel.add(ed_player1_delta_label);
		
		JLabel ed_player2_name_label = new JLabel("\u73A9\u5BB62");
		ed_player2_name_label.setFont(new Font("����", Font.PLAIN, 22));
		ed_player2_name_label.setBounds(14, 245, 375, 40);
		ending_panel.add(ed_player2_name_label);
		
		JLabel ed_player2_money_label = new JLabel("25000");
		ed_player2_money_label.setFont(new Font("����", Font.PLAIN, 22));
		ed_player2_money_label.setBounds(389, 245, 189, 40);
		ending_panel.add(ed_player2_money_label);
		
		JLabel ed_player2_delta_label = new JLabel("-16000");
		ed_player2_delta_label.setFont(new Font("����", Font.PLAIN, 22));
		ed_player2_delta_label.setBounds(575, 245, 189, 40);
		ending_panel.add(ed_player2_delta_label);
		
		JLabel ed_player3_name_label = new JLabel("\u73A9\u5BB63");
		ed_player3_name_label.setFont(new Font("����", Font.PLAIN, 22));
		ed_player3_name_label.setBounds(14, 298, 375, 40);
		ending_panel.add(ed_player3_name_label);
		
		JLabel ed_player3_money_label = new JLabel("25000");
		ed_player3_money_label.setFont(new Font("����", Font.PLAIN, 22));
		ed_player3_money_label.setBounds(389, 298, 189, 40);
		ending_panel.add(ed_player3_money_label);
		
		JLabel ed_player3_delta_label = new JLabel("-16000");
		ed_player3_delta_label.setFont(new Font("����", Font.PLAIN, 22));
		ed_player3_delta_label.setBounds(575, 298, 189, 40);
		ending_panel.add(ed_player3_delta_label);
		
		JLabel ed_player4_name_label = new JLabel("\u73A9\u5BB64");
		ed_player4_name_label.setFont(new Font("����", Font.PLAIN, 22));
		ed_player4_name_label.setBounds(14, 351, 375, 40);
		ending_panel.add(ed_player4_name_label);
		
		JLabel ed_player4_money_label = new JLabel("25000");
		ed_player4_money_label.setFont(new Font("����", Font.PLAIN, 22));
		ed_player4_money_label.setBounds(389, 351, 189, 40);
		ending_panel.add(ed_player4_money_label);
		
		JLabel ed_player4_delta_label = new JLabel("0");
		ed_player4_delta_label.setFont(new Font("����", Font.PLAIN, 22));
		ed_player4_delta_label.setBounds(575, 351, 189, 40);
		ending_panel.add(ed_player4_delta_label);
		
		JLabel ed_player5_name_label = new JLabel("\u73A9\u5BB65");
		ed_player5_name_label.setFont(new Font("����", Font.PLAIN, 22));
		ed_player5_name_label.setBounds(14, 404, 375, 40);
		ending_panel.add(ed_player5_name_label);
		
		JLabel ed_player5_money_label = new JLabel("25000");
		ed_player5_money_label.setFont(new Font("����", Font.PLAIN, 22));
		ed_player5_money_label.setBounds(389, 404, 189, 40);
		ending_panel.add(ed_player5_money_label);
		
		JLabel ed_player5_delta_label = new JLabel("0");
		ed_player5_delta_label.setFont(new Font("����", Font.PLAIN, 22));
		ed_player5_delta_label.setBounds(575, 404, 189, 40);
		ending_panel.add(ed_player5_delta_label);
		
		JLabel ed_player6_name_label = new JLabel("\u73A9\u5BB66");
		ed_player6_name_label.setFont(new Font("����", Font.PLAIN, 22));
		ed_player6_name_label.setBounds(14, 457, 375, 40);
		ending_panel.add(ed_player6_name_label);
		
		JLabel ed_player6_money_label = new JLabel("25000");
		ed_player6_money_label.setFont(new Font("����", Font.PLAIN, 22));
		ed_player6_money_label.setBounds(389, 457, 189, 40);
		ending_panel.add(ed_player6_money_label);
		
		JLabel ed_player6_delta_label = new JLabel("0");
		ed_player6_delta_label.setFont(new Font("����", Font.PLAIN, 22));
		ed_player6_delta_label.setBounds(575, 457, 189, 40);
		ending_panel.add(ed_player6_delta_label);
		
		JLabel ed_player1_hole_label = new JLabel("\u9ED1\u6843J \u9ED1\u684310");
		ed_player1_hole_label.setFont(new Font("����", Font.PLAIN, 22));
		ed_player1_hole_label.setBounds(120, 192, 189, 40);
		ending_panel.add(ed_player1_hole_label);
		
		JLabel ed_player2_hole_hand = new JLabel("\u9ED1\u684310 \u9ED1\u68437");
		ed_player2_hole_hand.setFont(new Font("����", Font.PLAIN, 22));
		ed_player2_hole_hand.setBounds(120, 245, 189, 40);
		ending_panel.add(ed_player2_hole_hand);
		
		JLabel ed_player3_hole_hand = new JLabel("\u7EA2\u6843J \u9ED1\u684310");
		ed_player3_hole_hand.setFont(new Font("����", Font.PLAIN, 22));
		ed_player3_hole_hand.setBounds(120, 298, 189, 40);
		ending_panel.add(ed_player3_hole_hand);
		
		JLabel ed_player4_hole_hand = new JLabel("\u5F03\u724C");
		ed_player4_hole_hand.setFont(new Font("����", Font.PLAIN, 22));
		ed_player4_hole_hand.setBounds(120, 351, 189, 40);
		ending_panel.add(ed_player4_hole_hand);
		
		JLabel ed_player5_hole_hand = new JLabel("\u5F03\u724C");
		ed_player5_hole_hand.setFont(new Font("����", Font.PLAIN, 22));
		ed_player5_hole_hand.setBounds(120, 404, 189, 40);
		ending_panel.add(ed_player5_hole_hand);
		
		JLabel ed_player6_hole_hand = new JLabel("\u5F03\u724C");
		ed_player6_hole_hand.setFont(new Font("����", Font.PLAIN, 22));
		ed_player6_hole_hand.setBounds(120, 457, 189, 40);
		ending_panel.add(ed_player6_hole_hand);
		
		JButton continue_button = new JButton("Continue");
		continue_button.setFont(new Font("����", Font.PLAIN, 22));
		continue_button.setBounds(309, 510, 160, 40);
		ending_panel.add(continue_button);
		
		JLabel player1_name_label = new JLabel("\u53F8\u673A\u59EC");
		player1_name_label.setFont(new Font("����", Font.PLAIN, 22));
		player1_name_label.setBounds(27, 29, 120, 40);
		frame.getContentPane().add(player1_name_label);
		
		JLabel palyer1_label = new JLabel("ALL-IN");
		palyer1_label.setFont(new Font("����", Font.PLAIN, 18));
		palyer1_label.setBounds(27, 82, 120, 40);
		frame.getContentPane().add(palyer1_label);
		
		JLabel player2_name_label = new JLabel("\u73A9\u5BB62");
		player2_name_label.setFont(new Font("����", Font.PLAIN, 22));
		player2_name_label.setBounds(27, 135, 120, 40);
		frame.getContentPane().add(player2_name_label);
		
		JLabel player2_label = new JLabel("\u5F53\u524D\u72B6\u6001");
		player2_label.setFont(new Font("����", Font.PLAIN, 18));
		player2_label.setBounds(27, 188, 120, 40);
		frame.getContentPane().add(player2_label);
		
		JLabel palyer3_name_label = new JLabel("\u73A9\u5BB63");
		palyer3_name_label.setFont(new Font("����", Font.PLAIN, 22));
		palyer3_name_label.setBounds(27, 241, 120, 40);
		frame.getContentPane().add(palyer3_name_label);
		
		JLabel player3_label = new JLabel("\u5F53\u524D\u72B6\u6001");
		player3_label.setFont(new Font("����", Font.PLAIN, 18));
		player3_label.setBounds(27, 294, 120, 40);
		frame.getContentPane().add(player3_label);
		
		JLabel player4_name_label = new JLabel("\u73A9\u5BB64");
		player4_name_label.setFont(new Font("����", Font.PLAIN, 22));
		player4_name_label.setBounds(27, 347, 120, 40);
		frame.getContentPane().add(player4_name_label);
		
		JLabel player4_label = new JLabel("\u5F53\u524D\u72B6\u6001");
		player4_label.setFont(new Font("����", Font.PLAIN, 18));
		player4_label.setBounds(27, 400, 120, 40);
		frame.getContentPane().add(player4_label);
		
		JLabel player5_name_label = new JLabel("\u73A9\u5BB65");
		player5_name_label.setFont(new Font("����", Font.PLAIN, 22));
		player5_name_label.setBounds(27, 453, 120, 40);
		frame.getContentPane().add(player5_name_label);
		
		JLabel player5_label = new JLabel("\u5F53\u524D\u72B6\u6001");
		player5_label.setFont(new Font("����", Font.PLAIN, 18));
		player5_label.setBounds(27, 506, 120, 40);
		frame.getContentPane().add(player5_label);
		
		JLabel player6_name_label = new JLabel("\u73A9\u5BB66");
		player6_name_label.setFont(new Font("����", Font.PLAIN, 22));
		player6_name_label.setBounds(27, 559, 120, 40);
		frame.getContentPane().add(player6_name_label);
		
		JLabel player6_label = new JLabel("\u5F53\u524D\u72B6\u6001");
		player6_label.setFont(new Font("����", Font.PLAIN, 18));
		player6_label.setBounds(27, 612, 120, 40);
		frame.getContentPane().add(player6_label);
		
		JLabel board_label = new JLabel("\u5E95\u724C\u72B6\u51B5\uFF1A \u9ED1\u6843K  \u9ED1\u6843Q  \u9ED1\u68439  \u672A\u77E5  \u672A\u77E5");
		board_label.setFont(new Font("����", Font.PLAIN, 22));
		board_label.setBounds(257, 543, 698, 40);
		frame.getContentPane().add(board_label);
		
		JLabel hole_label = new JLabel("\u60A8\u7684\u624B\u724C\uFF1A \u9ED1\u6843J  \u9ED1\u684310");
		hole_label.setFont(new Font("����", Font.PLAIN, 22));
		hole_label.setBounds(257, 596, 334, 40);
		frame.getContentPane().add(hole_label);
		
		JLabel pot_label = new JLabel("\u5E95\u6C60\uFF1A  23333");
		pot_label.setFont(new Font("����", Font.PLAIN, 22));
		pot_label.setBounds(27, 679, 203, 40);
		frame.getContentPane().add(pot_label);
		
		JLabel error_label = new JLabel("\u5F53\u524D\u4E0D\u662F\u60A8\u7684\u56DE\u5408\uFF01");
		error_label.setForeground(Color.RED);
		error_label.setFont(new Font("����", Font.PLAIN, 22));
		error_label.setBounds(621, 596, 334, 40);
		frame.getContentPane().add(error_label);
		
		JTextArea gameflow_textarea = new JTextArea();
		frame.getContentPane().add(gameflow_textarea);
		gameflow_textarea.setText("\u6E38\u620F\u4FE1\u606F\r\nsjj \u5F03\u724C 2333333");
		gameflow_textarea.setLineWrap(true);
		gameflow_textarea.setEditable(false);
		gameflow_textarea.setFont(new Font("����", Font.PLAIN, 24));
		gameflow_textarea.setBounds(257, 32, 698, 498);
		
		JButton raise_button = new JButton("\u52A0\u6CE8");
		raise_button.setFont(new Font("����", Font.PLAIN, 22));
		raise_button.setBounds(460, 708, 120, 40);
		frame.getContentPane().add(raise_button);
		
		JButton call_button = new JButton("\u8DDF\u6CE8");
		call_button.setFont(new Font("����", Font.PLAIN, 22));
		call_button.setBounds(640, 708, 120, 40);
		frame.getContentPane().add(call_button);
		
		JButton fold_button = new JButton("\u5F03\u724C");
		fold_button.setFont(new Font("����", Font.PLAIN, 22));
		fold_button.setBounds(820, 708, 120, 40);
		frame.getContentPane().add(fold_button);
		
		JButton all_in_button = new JButton("ALL-IN");
		all_in_button.setFont(new Font("����", Font.PLAIN, 22));
		all_in_button.setBounds(257, 649, 683, 40);
		frame.getContentPane().add(all_in_button);
		
		raise_field = new JTextField();
		raise_field.setFont(new Font("����", Font.PLAIN, 22));
		raise_field.setBounds(257, 708, 160, 39);
		frame.getContentPane().add(raise_field);
		raise_field.setColumns(10);

	}
}