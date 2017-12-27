package DZPK.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTree;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;

public class login_frame {

	private JFrame login_frame;
	private JTextField account_field;
	private JLabel currentpeople_label;
	private JLabel currentplayer_label;
	private JLabel currentgame_label;
	private JPasswordField password_field;
	private JTextPane game_textpane;
	private JLabel gamename_label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_frame window = new login_frame();
					window.login_frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login_frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		login_frame = new JFrame();
		login_frame.getContentPane().setEnabled(false);
		login_frame.setTitle("\u5FB7\u5DDE\u6251\u514B\u5BF9\u6218\u7CFB\u7EDF");
		login_frame.setBounds(100, 100, 1052, 825);
		login_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login_frame.getContentPane().setLayout(null);
		
		JLabel title_label = new JLabel("\u5FB7\u5DDE\u6251\u514B\u5728\u7EBF\u5BF9\u6218");
		title_label.setBounds(58, 62, 523, 92);
		login_frame.getContentPane().add(title_label);
		title_label.setHorizontalAlignment(SwingConstants.CENTER);
		title_label.setFont(new Font("����", Font.PLAIN, 60));
		
		currentpeople_label = new JLabel("\u5F53\u524D\u5728\u7EBF\u4EBA\u6570\uFF1A");
		currentpeople_label.setFont(new Font("����", Font.PLAIN, 32));
		currentpeople_label.setBounds(100, 419, 423, 79);
		login_frame.getContentPane().add(currentpeople_label);
		
		currentplayer_label = new JLabel("\u5F53\u524D\u5BF9\u6218\u4EBA\u6570\uFF1A");
		currentplayer_label.setFont(new Font("����", Font.PLAIN, 32));
		currentplayer_label.setBounds(100, 479, 423, 79);
		login_frame.getContentPane().add(currentplayer_label);
		
		currentgame_label = new JLabel("\u5F53\u524D\u5B8C\u6210\u5BF9\u5C40\uFF1A");
		currentgame_label.setFont(new Font("����", Font.PLAIN, 32));
		currentgame_label.setBounds(100, 539, 423, 79);
		login_frame.getContentPane().add(currentgame_label);
		
		JLabel other_label = new JLabel("\u672C\u516C\u53F8\u5176\u4ED6\u6E38\u620F");
		other_label.setHorizontalAlignment(SwingConstants.CENTER);
		other_label.setFont(new Font("����", Font.PLAIN, 18));
		other_label.setBounds(654, 82, 269, 63);
		login_frame.getContentPane().add(other_label);
		
		JLabel warning_label = new JLabel("<html><body>\t<center>\u5065\u5EB7\u6E38\u620F\u5FE0\u544A<br>\r\n\u62B5\u5236\u4E0D\u826F\u6E38\u620F,\u62D2\u7EDD\u76D7\u7248\u6E38\u620F\u3002<br>\r\n\u6CE8\u610F\u81EA\u6211\u4FDD\u62A4,\u8C28\u9632\u53D7\u9A97\u4E0A\u5F53\u3002<br>\r\n\u9002\u5EA6\u6E38\u620F\u76CA\u8111,\u6C89\u8FF7\u6E38\u620F\u4F24\u8EAB\u3002<br>\r\n\u5408\u7406\u5B89\u6392\u65F6\u95F4,\u4EAB\u53D7\u5065\u5EB7\u751F\u6D3B\u3002<br>");
		warning_label.setFont(new Font("宋体", Font.PLAIN, 24));
		warning_label.setHorizontalAlignment(SwingConstants.CENTER);
		warning_label.setBounds(537, 424, 403, 181);
		login_frame.getContentPane().add(warning_label);
		
		game_textpane = new JTextPane();
		game_textpane.setBounds(760, 158, 60, 60);
		login_frame.getContentPane().add(game_textpane);
		
		gamename_label = new JLabel("\u65E0");
		gamename_label.setFont(new Font("����", Font.PLAIN, 18));
		gamename_label.setHorizontalAlignment(SwingConstants.CENTER);
		gamename_label.setBounds(755, 231, 72, 18);
		login_frame.getContentPane().add(gamename_label);
		
		account_field = new JTextField();
		account_field.setFont(new Font("����", Font.PLAIN, 18));
		account_field.setBounds(160, 200, 320, 32);
		login_frame.getContentPane().add(account_field);
		account_field.setText("\u8BF7\u8F93\u5165\u7528\u6237\u540D");
		account_field.setColumns(10);
		
		password_field = new JPasswordField();
		password_field.setFont(new Font("����", Font.PLAIN, 18));
		password_field.setBounds(160, 260, 320, 32);
		login_frame.getContentPane().add(password_field);
		
		JButton login_button = new JButton("\u6CE8\u518C");
		login_button.setFont(new Font("����", Font.PLAIN, 18));
		login_button.setBounds(200, 323, 80, 32);
		login_frame.getContentPane().add(login_button);
		
		JButton register_button = new JButton("\u767B\u5F55");
		register_button.setFont(new Font("����", Font.PLAIN, 18));
		register_button.setBounds(360, 323, 80, 32);
		login_frame.getContentPane().add(register_button);
	}
}
