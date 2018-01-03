package com.company.DZPK.frame;

import com.company.DZPK.controller.Card;
import com.company.DZPK.model.UserData;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;

public class game_frame {

	public static JFrame frame;
	public static JTextField raise_field;
	public static JLabel ed_player1_name_label;
	public static JLabel ed_player1_money_label ;
	public static JLabel ed_player1_delta_label;
	public static JLabel player1_name_label;
	public static JLabel player1_label;
	public static JLabel ed_player2_name_label;
	public static JLabel ed_player2_money_label ;
	public static JLabel ed_player2_delta_label;
	public static JLabel player2_name_label;
	public static JLabel player2_label;
	public static JLabel ed_player3_name_label;
	public static JLabel ed_player3_money_label ;
	public static JLabel ed_player3_delta_label;
	public static JLabel player3_name_label;
	public static JLabel player3_label;
	public static JLabel ed_player5_name_label;
	public static JLabel ed_player5_money_label ;
	public static JLabel ed_player5_delta_label;
	public static JLabel player5_name_label;
	public static JLabel player5_label;
	public static JLabel ed_player4_name_label;
	public static JLabel ed_player4_money_label ;
	public static JLabel ed_player4_delta_label;
	public static JLabel player4_name_label;
	public static JLabel player4_label;
	public static JLabel ed_player6_name_label;
	public static JLabel ed_player6_money_label ;
	public static JLabel ed_player6_delta_label;
	public static JLabel player6_name_label;
	public static JLabel player6_label;
	public static JPanel ending_panel;
	public static JLabel ed_nuts_label;
	public static JLabel ed_winner_label;
	public static JLabel ed_board_label;
	public static JLabel ed_nuts_detail_label;
	public static JLabel ed_board_detail_label;
	public static JLabel ed_player2_hole_hand;
	public static JLabel ed_player3_hole_hand;
	public static JLabel ed_player4_hole_hand;
	public static JLabel ed_player5_hole_hand;
	public static JLabel ed_player6_hole_hand;
	public static JLabel ed_player1_hole_hand;
	public static JButton continue_button;
	public static JLabel board_label;
	public static JLabel hole_label;
	public static JLabel pot_label;
	public static JLabel error_label;
	public static JTextArea gameflow_textarea;
	public static JButton raise_button;
	public static JButton call_button;
	public static JButton fold_button;
	public static JButton all_in_button;
	public static game_frame window;
	public static int tableId;
	public static UserData userData;

    public static Card[] hole = new Card[2];
	public static Card[] board = new Card[5];

	public static String wait = "\u7b49\u5f85\u4e2d";
	public static String unknown = "\u672a\u77e5";
	public static String hole_string ="\u60A8\u7684\u624B\u724C\uFF1A";
	public static String board_string ="\u5E95\u724C\u72B6\u6001\uFF1A";
	public static String raise_string="\u52A0\u6CE8";
	public static String call_string="\u8DDF\u6CE8";
	public static String fold_string="\u5F03\u724C";
	public static String straight_flush_string="\u540C\u82B1\u987A";
	public static String four_of_a_kind_string="\u56DB\u6761";
	public static String full_house_string="\u846B\u82A6";
	public static String flush_string="\u540C\u82B1";
	public static String straight_string="\u987A\u5B50";
	public static String three_of_a_kind_string="\u4E09\u6761";
	public static String two_pair_string="\u4E24\u5BF9";
	public static String one_pair_string="\u4E00\u5BF9";
	public static String big_blind_string="\u5927\u76F2\u6CE8";
	public static String high_card_string="\u9AD8\u724C";
	public static String small_blind_string="\u5C0F\u76F2\u6CE8";
	public static String raise_high_string="\u7B79\u7801\u4E0D\u8DB3\uFF01";
	public static String raise_low_string="\u8DDF\u6CE8\u91D1\u989D\u4E0D\u8DB3\uFF01";
	public static String pot_string="\u5E95\u6C60\uFF1A";

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

    public static void show() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    window = new game_frame();
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
		ending_panel.hide();
		
		ed_nuts_label = new JLabel("\u540C \u82B1 Dark \u987A");
		ed_nuts_label.setHorizontalAlignment(SwingConstants.CENTER);
		ed_nuts_label.setFont(new Font("宋体", Font.PLAIN, 48));
		ed_nuts_label.setBounds(14, 13, 750, 60);
		ending_panel.add(ed_nuts_label);
		
		ed_winner_label = new JLabel("\u53F8\u673A\u59EC");
		ed_winner_label.setFont(new Font("宋体", Font.PLAIN, 22));
		ed_winner_label.setBounds(14, 86, 120, 40);
		ending_panel.add(ed_winner_label);
		
		ed_board_label = new JLabel("\u5E95\u724C");
		ed_board_label.setFont(new Font("宋体", Font.PLAIN, 22));
		ed_board_label.setBounds(14, 139, 120, 40);
		ending_panel.add(ed_board_label);
		
		ed_nuts_detail_label = new JLabel("\u9ED1\u6843A \u9ED1\u6843K \u9ED1\u6843Q \u9ED1\u6843J \u9ED1\u684310");
		ed_nuts_detail_label.setHorizontalAlignment(SwingConstants.CENTER);
		ed_nuts_detail_label.setFont(new Font("宋体", Font.PLAIN, 22));
		ed_nuts_detail_label.setBounds(14, 86, 750, 40);
		ending_panel.add(ed_nuts_detail_label);
		
		ed_board_detail_label = new JLabel("\u9ED1\u6843K \u9ED1\u6843Q \u9ED1\u68439 \u672A\u77E5 \u672A\u77E5");
		ed_board_detail_label.setHorizontalAlignment(SwingConstants.CENTER);
		ed_board_detail_label.setFont(new Font("宋体", Font.PLAIN, 22));
		ed_board_detail_label.setBounds(14, 139, 750, 40);
		ending_panel.add(ed_board_detail_label);
		
		ed_player1_name_label = new JLabel("\u53F8\u673A\u59EC");
		ed_player1_name_label.setFont(new Font("宋体", Font.PLAIN, 22));
		ed_player1_name_label.setBounds(14, 192, 375, 40);
		ending_panel.add(ed_player1_name_label);
		
		ed_player1_money_label = new JLabel("25000");
		ed_player1_money_label.setFont(new Font("宋体", Font.PLAIN, 22));
		ed_player1_money_label.setBounds(389, 192, 189, 40);
		ending_panel.add(ed_player1_money_label);
		
		ed_player1_delta_label = new JLabel("+32000");
		ed_player1_delta_label.setFont(new Font("宋体", Font.PLAIN, 22));
		ed_player1_delta_label.setBounds(575, 192, 189, 40);
		ending_panel.add(ed_player1_delta_label);
		
		ed_player2_name_label = new JLabel("\u73A9\u5BB62");
		ed_player2_name_label.setFont(new Font("宋体", Font.PLAIN, 22));
		ed_player2_name_label.setBounds(14, 245, 375, 40);
		ending_panel.add(ed_player2_name_label);
		
		ed_player2_money_label = new JLabel("25000");
		ed_player2_money_label.setFont(new Font("宋体", Font.PLAIN, 22));
		ed_player2_money_label.setBounds(389, 245, 189, 40);
		ending_panel.add(ed_player2_money_label);
		
		ed_player2_delta_label = new JLabel("-16000");
		ed_player2_delta_label.setFont(new Font("宋体", Font.PLAIN, 22));
		ed_player2_delta_label.setBounds(575, 245, 189, 40);
		ending_panel.add(ed_player2_delta_label);
		
		ed_player3_name_label = new JLabel("\u73A9\u5BB63");
		ed_player3_name_label.setFont(new Font("宋体", Font.PLAIN, 22));
		ed_player3_name_label.setBounds(14, 298, 375, 40);
		ending_panel.add(ed_player3_name_label);
		
		ed_player3_money_label = new JLabel("25000");
		ed_player3_money_label.setFont(new Font("宋体", Font.PLAIN, 22));
		ed_player3_money_label.setBounds(389, 298, 189, 40);
		ending_panel.add(ed_player3_money_label);
		
		ed_player3_delta_label = new JLabel("-16000");
		ed_player3_delta_label.setFont(new Font("宋体", Font.PLAIN, 22));
		ed_player3_delta_label.setBounds(575, 298, 189, 40);
		ending_panel.add(ed_player3_delta_label);
		
		ed_player4_name_label = new JLabel("\u73A9\u5BB64");
		ed_player4_name_label.setFont(new Font("宋体", Font.PLAIN, 22));
		ed_player4_name_label.setBounds(14, 351, 375, 40);
		ending_panel.add(ed_player4_name_label);
		
		ed_player4_money_label = new JLabel("25000");
		ed_player4_money_label.setFont(new Font("宋体", Font.PLAIN, 22));
		ed_player4_money_label.setBounds(389, 351, 189, 40);
		ending_panel.add(ed_player4_money_label);
		
		ed_player4_delta_label = new JLabel("0");
		ed_player4_delta_label.setFont(new Font("宋体", Font.PLAIN, 22));
		ed_player4_delta_label.setBounds(575, 351, 189, 40);
		ending_panel.add(ed_player4_delta_label);
		
		ed_player5_name_label = new JLabel("\u73A9\u5BB65");
		ed_player5_name_label.setFont(new Font("宋体", Font.PLAIN, 22));
		ed_player5_name_label.setBounds(14, 404, 375, 40);
		ending_panel.add(ed_player5_name_label);
		
		ed_player5_money_label = new JLabel("25000");
		ed_player5_money_label.setFont(new Font("宋体", Font.PLAIN, 22));
		ed_player5_money_label.setBounds(389, 404, 189, 40);
		ending_panel.add(ed_player5_money_label);
		
		ed_player5_delta_label = new JLabel("0");
		ed_player5_delta_label.setFont(new Font("宋体", Font.PLAIN, 22));
		ed_player5_delta_label.setBounds(575, 404, 189, 40);
		ending_panel.add(ed_player5_delta_label);
		
		ed_player6_name_label = new JLabel("\u73A9\u5BB66");
		ed_player6_name_label.setFont(new Font("宋体", Font.PLAIN, 22));
		ed_player6_name_label.setBounds(14, 457, 375, 40);
		ending_panel.add(ed_player6_name_label);
		
		ed_player6_money_label = new JLabel("25000");
		ed_player6_money_label.setFont(new Font("宋体", Font.PLAIN, 22));
		ed_player6_money_label.setBounds(389, 457, 189, 40);
		ending_panel.add(ed_player6_money_label);
		
		ed_player6_delta_label = new JLabel("0");
		ed_player6_delta_label.setFont(new Font("宋体", Font.PLAIN, 22));
		ed_player6_delta_label.setBounds(575, 457, 189, 40);
		ending_panel.add(ed_player6_delta_label);
		
		ed_player1_hole_hand = new JLabel("\u9ED1\u6843J \u9ED1\u684310");
		ed_player1_hole_hand.setFont(new Font("宋体", Font.PLAIN, 22));
		ed_player1_hole_hand.setBounds(120, 192, 189, 40);
		ending_panel.add(ed_player1_hole_hand);
		
		ed_player2_hole_hand = new JLabel("\u9ED1\u684310 \u9ED1\u68437");
		ed_player2_hole_hand.setFont(new Font("宋体", Font.PLAIN, 22));
		ed_player2_hole_hand.setBounds(120, 245, 189, 40);
		ending_panel.add(ed_player2_hole_hand);
		
		ed_player3_hole_hand = new JLabel("\u7EA2\u6843J \u9ED1\u684310");
		ed_player3_hole_hand.setFont(new Font("宋体", Font.PLAIN, 22));
		ed_player3_hole_hand.setBounds(120, 298, 189, 40);
		ending_panel.add(ed_player3_hole_hand);
		
		ed_player4_hole_hand = new JLabel("\u5F03\u724C");
		ed_player4_hole_hand.setFont(new Font("宋体", Font.PLAIN, 22));
		ed_player4_hole_hand.setBounds(120, 351, 189, 40);
		ending_panel.add(ed_player4_hole_hand);
		
		ed_player5_hole_hand = new JLabel("\u5F03\u724C");
		ed_player5_hole_hand.setFont(new Font("宋体", Font.PLAIN, 22));
		ed_player5_hole_hand.setBounds(120, 404, 189, 40);
		ending_panel.add(ed_player5_hole_hand);
		
		ed_player6_hole_hand = new JLabel("\u5F03\u724C");
		ed_player6_hole_hand.setFont(new Font("宋体", Font.PLAIN, 22));
		ed_player6_hole_hand.setBounds(120, 457, 189, 40);
		ending_panel.add(ed_player6_hole_hand);
		
		continue_button = new JButton("Continue");
		continue_button.setFont(new Font("宋体", Font.PLAIN, 22));
		continue_button.setBounds(309, 510, 160, 40);
		ending_panel.add(continue_button);
		
		player1_name_label = new JLabel("\u53F8\u673A\u59EC");
		player1_name_label.setFont(new Font("宋体", Font.PLAIN, 22));
		player1_name_label.setBounds(27, 29, 120, 40);
		frame.getContentPane().add(player1_name_label);
		
		player1_label = new JLabel("ALL-IN");
		player1_label.setFont(new Font("宋体", Font.PLAIN, 18));
		player1_label.setBounds(27, 82, 120, 40);
		frame.getContentPane().add(player1_label);
		
		player2_name_label = new JLabel("\u73A9\u5BB62");
		player2_name_label.setFont(new Font("宋体", Font.PLAIN, 22));
		player2_name_label.setBounds(27, 135, 120, 40);
		frame.getContentPane().add(player2_name_label);
		
		player2_label = new JLabel("\u5F53\u524D\u72B6\u6001");
		player2_label.setFont(new Font("宋体", Font.PLAIN, 18));
		player2_label.setBounds(27, 188, 120, 40);
		frame.getContentPane().add(player2_label);
		
		player3_name_label = new JLabel("\u73A9\u5BB63");
		player3_name_label.setFont(new Font("宋体", Font.PLAIN, 22));
		player3_name_label.setBounds(27, 241, 120, 40);
		frame.getContentPane().add(player3_name_label);
		
		player3_label = new JLabel("\u5F53\u524D\u72B6\u6001");
		player3_label.setFont(new Font("宋体", Font.PLAIN, 18));
		player3_label.setBounds(27, 294, 120, 40);
		frame.getContentPane().add(player3_label);
		
		player4_name_label = new JLabel("\u73A9\u5BB64");
		player4_name_label.setFont(new Font("宋体", Font.PLAIN, 22));
		player4_name_label.setBounds(27, 347, 120, 40);
		frame.getContentPane().add(player4_name_label);
		
		player4_label = new JLabel("\u5F53\u524D\u72B6\u6001");
		player4_label.setFont(new Font("宋体", Font.PLAIN, 18));
		player4_label.setBounds(27, 400, 120, 40);
		frame.getContentPane().add(player4_label);
		
		player5_name_label = new JLabel("\u73A9\u5BB65");
		player5_name_label.setFont(new Font("宋体", Font.PLAIN, 22));
		player5_name_label.setBounds(27, 453, 120, 40);
		frame.getContentPane().add(player5_name_label);
		
		player5_label = new JLabel("\u5F53\u524D\u72B6\u6001");
		player5_label.setFont(new Font("宋体", Font.PLAIN, 18));
		player5_label.setBounds(27, 506, 120, 40);
		frame.getContentPane().add(player5_label);
		
		player6_name_label = new JLabel("\u73A9\u5BB66");
		player6_name_label.setFont(new Font("宋体", Font.PLAIN, 22));
		player6_name_label.setBounds(27, 559, 120, 40);
		frame.getContentPane().add(player6_name_label);
		
		player6_label = new JLabel("\u5F53\u524D\u72B6\u6001");
		player6_label.setFont(new Font("宋体", Font.PLAIN, 18));
		player6_label.setBounds(27, 612, 120, 40);
		frame.getContentPane().add(player6_label);
		
		board_label = new JLabel("\u5E95\u724C\u72B6\u6001\uFF1A");
		board_label.setFont(new Font("宋体", Font.PLAIN, 22));
		board_label.setBounds(257, 543, 698, 40);
		frame.getContentPane().add(board_label);
		
		hole_label = new JLabel("\u60A8\u7684\u624B\u724C\uFF1A");
		hole_label.setFont(new Font("宋体", Font.PLAIN, 22));
		hole_label.setBounds(257, 596, 334, 40);
		frame.getContentPane().add(hole_label);
		
		pot_label = new JLabel("");
		pot_label.setFont(new Font("宋体", Font.PLAIN, 22));
		pot_label.setBounds(27, 679, 203, 40);
		frame.getContentPane().add(pot_label);
		
		error_label = new JLabel("\u5F53\u524D\u4E0D\u662F\u60A8\u7684\u56DE\u5408\uFF01");
		error_label.setForeground(Color.RED);
		error_label.setFont(new Font("宋体", Font.PLAIN, 22));
		error_label.setBounds(621, 596, 334, 40);
		frame.getContentPane().add(error_label);
		
		gameflow_textarea = new JTextArea();
		frame.getContentPane().add(gameflow_textarea);
		gameflow_textarea.setText(wait);
		gameflow_textarea.setLineWrap(true);
		gameflow_textarea.setEditable(false);
		gameflow_textarea.setFont(new Font("宋体", Font.PLAIN, 24));
		gameflow_textarea.setBounds(257, 32, 698, 498);
		
		raise_button = new JButton("\u52A0\u6CE8");
		raise_button.setFont(new Font("宋体", Font.PLAIN, 22));
		raise_button.setBounds(460, 708, 120, 40);
		frame.getContentPane().add(raise_button);
		
		call_button = new JButton("\u8DDF\u6CE8");
		call_button.setFont(new Font("宋体", Font.PLAIN, 22));
		call_button.setBounds(640, 708, 120, 40);
		frame.getContentPane().add(call_button);
		
		fold_button = new JButton("\u5F03\u724C");
		fold_button.setFont(new Font("宋体", Font.PLAIN, 22));
		fold_button.setBounds(820, 708, 120, 40);
		frame.getContentPane().add(fold_button);
		
		all_in_button = new JButton("ALL-IN");
		all_in_button.setFont(new Font("宋体", Font.PLAIN, 22));
		all_in_button.setBounds(257, 649, 683, 40);
		frame.getContentPane().add(all_in_button);
		
		raise_field = new JTextField();
		raise_field.setFont(new Font("宋体", Font.PLAIN, 22));
		raise_field.setBounds(257, 708, 160, 39);
		frame.getContentPane().add(raise_field);
		raise_field.setColumns(10);

	}


    public static void setPlayerNameLabel(String string,int playerId){
	    switch (playerId){
        case 1:
            player1_name_label.setText(string);
            if(string.length() > 0)
                player1_label.setText(game_frame.wait);
            else player1_label.setText("");
            break;
        case 2:
            player2_name_label.setText(string);
            if(string.length() > 0)
                player2_label.setText(game_frame.wait);
            else player2_label.setText("");
            break;
        case 3:
            player3_name_label.setText(string);
            if(string.length() > 0)
                player3_label.setText(game_frame.wait);
            else player3_label.setText("");
        case 4:
            player4_name_label.setText(string);
            if(string.length() > 0)
                player4_label.setText(game_frame.wait);
            else player4_label.setText("");
            break;
        case 5:
            player5_name_label.setText(string);
            if(string.length() > 0)
                player5_label.setText(game_frame.wait);
            else player5_label.setText("");
            break;
        case 6:
            player6_name_label.setText(string);
            if(string.length() > 0)
                player6_label.setText(game_frame.wait);
            else player6_label.setText("");
            break;
        }
	}

	public static void setPlayerLabel(String string,int playerId){
        switch (playerId){
            case 1:
                player1_label.setText(string);
                break;
            case 2:
                player2_label.setText(string);
                break;
            case 3:
                player3_label.setText(string);
                break;
            case 4:
                player4_label.setText(string);
                break;
            case 5:
                player5_label.setText(string);
                break;
            case 6:
                player6_label.setText(string);
                break;
        }
    }

    public static void updateHole(){
	    String holeS = hole_string;
	    for(int i = 0;i < 2;i++){
	        if (hole[i] == null) holeS += unknown;
	        else {
	            holeS += hole[i].getColorS() + hole[i].getNumS();
            }
	        holeS += "  ";
        }
        hole_label.setText(holeS);
    }

    public static void updateBoard(){
        String boardS = board_string;
        for(int i = 0;i < 5;i++){
            if (hole[i] == null) boardS += unknown;
            else {
                boardS += board[i].getColorS() + board[i].getNumS();
            }
            boardS += "  ";
        }
        board_label.setText(boardS);
    }

    public static void addCard(int id,int place){
	    Card card = new Card(id);
	    if (place < 2){
	        hole[place] = card;
	        updateHole();
        }
        else{
	        board[place - 2] = card;
	        updateBoard();
        }
    }
}
